package com.web.onlineshop.configuration;

import com.web.onlineshop.repository.mappers.*;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ClientMapper clientMapper() {

        return Mappers.getMapper(ClientMapper.class);
    }

    @Bean
    public ProductMapper productMapper() {

        return Mappers.getMapper(ProductMapper.class);
    }

    @Bean
    public FlavourCategoryMapper flavourCategoryMapper() {
        return Mappers.getMapper(FlavourCategoryMapper.class);
    }

    @Bean
    public OrderMapper orderMapper() {
        return Mappers.getMapper(OrderMapper.class);
    }

    @Bean
    public OrdersDetailsMapper ordersDetailsMapper() {
        return Mappers.getMapper(OrdersDetailsMapper.class);
    }
}
