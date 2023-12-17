package com.web.onlineshop.dto;

import com.web.onlineshop.repository.model.Product;

import java.math.BigDecimal;
import java.util.Objects;

public class ProductDTO {
    private Integer id;
    private String name;
    private FlavourCategoryDTO flavourCategoryDTO;
    private BigDecimal price;

    public ProductDTO() {
    }

    public ProductDTO(Integer id, String name, FlavourCategoryDTO flavourCategoryDTO, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.flavourCategoryDTO = flavourCategoryDTO;
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

    public FlavourCategoryDTO getFlavourCategoryDTO() {
        return flavourCategoryDTO;
    }

    public void setFlavourCategoryDTO(FlavourCategoryDTO flavourCategoryDTO) {
        this.flavourCategoryDTO = flavourCategoryDTO;
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
        ProductDTO that = (ProductDTO) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(flavourCategoryDTO, that.flavourCategoryDTO) && Objects.equals(price, that.price);
    }

    @Override
    public String toString() {
        return "ProductDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", flavourCategoryDTO=" + flavourCategoryDTO +
                ", price=" + price +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, flavourCategoryDTO, price);
    }

    public Product toProduct() {
        Product product = new Product();
        product.setId(this.id);
        product.setName(this.name);
        if (this.flavourCategoryDTO != null) {
            product.setFlavourCategory(this.flavourCategoryDTO.toFlavourCategory());
        }
        product.setPrice(this.price);
        return product;
    }
}
