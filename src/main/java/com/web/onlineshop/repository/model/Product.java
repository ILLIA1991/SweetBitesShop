package com.web.onlineshop.repository.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name")
    private String name;

    //@ManyToMany
    //@Column(name = "category_id")
    @ManyToOne //Добавил тут такую связь
    @JoinColumn(name = "category_id")
    private FlavourCategory flavourCategory;
    @Column(name = "price")
    private BigDecimal price;


    public Product() {
    }

    public Product(Integer id, String name, FlavourCategory flavourCategory, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.flavourCategory = flavourCategory;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FlavourCategory getFlavourCategory() {
        return flavourCategory;
    }

    public void setFlavourCategory(FlavourCategory flavourCategory) {
        this.flavourCategory = flavourCategory;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id) && Objects.equals(name, product.name) && Objects.equals(flavourCategory, product.flavourCategory) && Objects.equals(price, product.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, flavourCategory, price);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", flavourCategory=" + flavourCategory +
                ", price=" + price +
                '}';
    }
}
