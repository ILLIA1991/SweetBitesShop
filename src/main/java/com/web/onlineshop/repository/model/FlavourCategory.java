package com.web.onlineshop.repository.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Objects;


@Entity
@Table(name = "flavour_categories")
public class FlavourCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name")
    @Enumerated(EnumType.STRING)
    private NameFlavours flavours;
    @Column(name = "description")
    private String description;

    public FlavourCategory() {
    }

    public FlavourCategory(Integer id, NameFlavours flavours, String description) {
        this.id = id;
        this.flavours = flavours;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public NameFlavours getFlavours() {
        return flavours;
    }

    public void setFlavours(NameFlavours flavours) {
        this.flavours = flavours;
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
        return Objects.equals(id, that.id) && flavours == that.flavours && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, flavours, description);
    }

    @Override
    public String toString() {
        return "FlavourCategory{" +
                "id=" + id +
                ", flavours=" + flavours +
                ", description='" + description + '\'' +
                '}';
    }
}
