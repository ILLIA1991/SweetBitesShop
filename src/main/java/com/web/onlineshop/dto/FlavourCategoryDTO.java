package com.web.onlineshop.dto;

import com.web.onlineshop.repository.mappers.FlavourCategoryMapper;
import com.web.onlineshop.repository.model.FlavourCategory;

import java.util.Objects;

public class FlavourCategoryDTO {

    private Integer id;
    private String name;
    private String description;

    public FlavourCategoryDTO() {

    }

    public FlavourCategoryDTO(Integer id) {
        this.id = id;
    }

    public FlavourCategoryDTO(Integer id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FlavourCategoryDTO that = (FlavourCategoryDTO) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description);
    }

    @Override
    public String toString() {
        return "FlavourCategoryDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public FlavourCategory toFlavourCategory() {
        return FlavourCategoryMapper.INSTANCE.toFlavourCategory(this);
    }
}
