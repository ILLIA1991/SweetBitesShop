package com.web.onlineshop.controller;

import com.web.onlineshop.dto.FlavourCategoryDTO;
import com.web.onlineshop.service.FlavourCategoryService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Flavour Category Management API", description = "API for CRUD operations with flavour categories")
@RestController
@RequestMapping("/categories")
public class FlavourCategoryController {
    private final FlavourCategoryService flavourCategoryService;

    public FlavourCategoryController(FlavourCategoryService flavourCategoryService) {
        this.flavourCategoryService = flavourCategoryService;
    }
    @Tag(name = "Retrieving all flavour categories", description = "In case no flavour category is found, the response will have a status of 404")
    @GetMapping
    public List<FlavourCategoryDTO> getAll() {
        return flavourCategoryService.getAllFlavours();
    }

    @Tag(name = "Fetching a flavour category by ID", description = "In case the flavour category is not found, the response will have a status of 404")
    @GetMapping("/{id}")
    public FlavourCategoryDTO getById(@PathVariable Integer id) {
        return flavourCategoryService.getFlavourById(id);
    }

   @PostMapping
   public Integer flavourCreate(@RequestBody FlavourCategoryDTO flavourToCreate) {
        return flavourCategoryService.createFlavour(flavourToCreate);
   }

   @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        flavourCategoryService.deleteById(id);
   }

   @PutMapping("/{id}")
    public FlavourCategoryDTO update(@PathVariable Integer id, @RequestBody FlavourCategoryDTO flavourToUpdate) {
        return flavourCategoryService.updateFlavour(id, flavourToUpdate);
   }
}

