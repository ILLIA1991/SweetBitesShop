package com.web.onlineshop.repository.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "product")
@Data
@AllArgsConstructor
@NoArgsConstructor //Добавил пустой конструктор
@Getter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name")
    private String name;
    @OneToOne
    @JoinColumn(name = "category_id")
    private FlavourCategory flavourCategory;
    @Column(name = "price")
    private BigDecimal price;


    public Integer getId() {
        return id;
    }
}
