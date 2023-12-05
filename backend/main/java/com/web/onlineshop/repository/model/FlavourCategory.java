package com.web.onlineshop.repository.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
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
}
