package com.web.onlineshop.repository.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "flavour_categories")

public class FlavourCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name")
    @Enumerated(EnumType.STRING)
    private NameFlavours name; //изменили с flavour
    @Column(name = "description")
    private String description;

    public FlavourCategory() {
    }

    public FlavourCategory(Integer id, NameFlavours name, String description) {
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

    public NameFlavours getName() {
        return name;
    }

    public void setName(NameFlavours name) {
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
        FlavourCategory that = (FlavourCategory) o;
        return Objects.equals(id, that.id) && name == that.name && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description);
    }

    @Override
    public String toString() {
        return "FlavourCategory{" +
                "id=" + id +
                ", flavours=" + name +
                ", description='" + description + '\'' +
                '}';
    }
}
