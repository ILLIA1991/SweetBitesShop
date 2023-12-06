package com.web.onlineshop.controller;

import com.web.onlineshop.dto.FlavourCategoryDTO;
import com.web.onlineshop.service.FlavourCategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class FlavourCategoryController {
    private final FlavourCategoryService flavourCategoryService;

    public FlavourCategoryController(FlavourCategoryService flavourCategoryService) {
        this.flavourCategoryService = flavourCategoryService;
    }

    @GetMapping
    public List<FlavourCategoryDTO> getAll() {
        return flavourCategoryService.getAllFlavours();
    }

    @GetMapping("/{id}")
    public FlavourCategoryDTO getById(@PathVariable Integer id) {
        return flavourCategoryService.getFlavourById(id);
    }
}

