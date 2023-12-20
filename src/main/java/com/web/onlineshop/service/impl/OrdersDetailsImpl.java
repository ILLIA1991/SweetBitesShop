package com.web.onlineshop.service.impl;

import com.web.onlineshop.dto.OrderDetailsDTO;
import com.web.onlineshop.repository.OrdersDetailsRepository;
import com.web.onlineshop.repository.ProductRepository;
import com.web.onlineshop.repository.mappers.OrdersDetailsMapper;
import com.web.onlineshop.repository.model.OrdersDetails;
import com.web.onlineshop.repository.model.Product;
import com.web.onlineshop.service.OrdersDetailsService;
import com.web.onlineshop.validator.OrderDetailsValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrdersDetailsImpl implements OrdersDetailsService {

    private final OrdersDetailsRepository detailsRepository;
    private final OrdersDetailsMapper detailsMapper;
    private final ProductRepository productRepository;
    private final OrderDetailsValidator orderDetailsValidator;


    @Autowired
    public OrdersDetailsImpl(OrdersDetailsRepository detailsRepository, @Qualifier("ordersDetailsMapper") OrdersDetailsMapper detailsMapper, ProductRepository productRepository, OrderDetailsValidator orderDetailsValidator) {
        this.detailsRepository = detailsRepository;
        this.detailsMapper = detailsMapper;
        this.productRepository = productRepository;
        this.orderDetailsValidator = orderDetailsValidator;
    }

    @Override
    public List<OrderDetailsDTO> getAll() {
        List<OrdersDetails> allDetails = detailsRepository.findAll();
        return allDetails.stream()
                .map(detailsMapper::toOrderDetailsDTO)
                .collect(Collectors.toList());
    }

    /*
   @Override
    public BigDecimal calculateTotalPrice(Integer productId, Integer quantity) {
        orderDetailsValidator.validateOrderDetails(orderDetailsDTO.getQuantity());
        Product product = productRepository.findById(productId).orElse(null);
        if (product == null) {
            return null;
        }
        return product.getPrice()
                .multiply(new BigDecimal(quantity));
     */
    @Override
    public BigDecimal calculateTotalPrice(Integer productId, Integer quantity) {
        OrderDetailsDTO orderDetailsDTO = new OrderDetailsDTO();
        orderDetailsDTO.setQuantity(quantity);

        orderDetailsValidator.validateOrderDetails(orderDetailsDTO);

        Product product = productRepository.findById(productId).orElse(null);
        if (product == null) {
            return null;
        }

        return product.getPrice().multiply(new BigDecimal(quantity));
    }
}





