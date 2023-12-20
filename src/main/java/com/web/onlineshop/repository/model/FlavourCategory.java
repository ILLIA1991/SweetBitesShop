package com.web.onlineshop.repository.model;

import jakarta.persistence.*;

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
    public String toString() {
        return "FlavourCategory{" +
                "id=" + id +
                ", flavours=" + name +
                ", description='" + description + '\'' +
                '}';
    }
}
