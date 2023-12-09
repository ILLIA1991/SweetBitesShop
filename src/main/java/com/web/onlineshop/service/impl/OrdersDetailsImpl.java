package com.web.onlineshop.service.impl;

import com.web.onlineshop.dto.OrderDetailsDTO;
import com.web.onlineshop.repository.OrdersDetailsRepository;
import com.web.onlineshop.repository.ProductRepository;
import com.web.onlineshop.repository.mappers.OrdersDetailsMapper;
import com.web.onlineshop.repository.model.OrdersDetails;
import com.web.onlineshop.repository.model.Product;
import com.web.onlineshop.service.OrdersDetailsService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class OrdersDetailsImpl implements OrdersDetailsService {

    private final OrdersDetailsRepository detailsRepository;
    private final OrdersDetailsMapper detailsMapper;

    private final ProductRepository productRepository;

    public OrdersDetailsImpl(OrdersDetailsRepository detailsRepository, OrdersDetailsMapper detailsMapper, ProductRepository productRepository) {
        this.detailsRepository = detailsRepository;
        this.detailsMapper = detailsMapper;
        this.productRepository = productRepository;
    }

    @Override
    public List<OrderDetailsDTO> getAll() {
        List<OrdersDetails> allDetails = detailsRepository.findAll();
        return allDetails.stream()
                .map(detailsMapper::toOrderDetailsDTO)
                .collect(Collectors.toList());
    }

    @Override
    public BigDecimal calculateTotalPrice(Integer productId, Integer quantity) {
        Product product = productRepository.findById(productId).orElse(null);
        if(product == null) {
            return null;
        }
        return product.getPrice()
                .multiply(new BigDecimal(quantity));
    }
}
