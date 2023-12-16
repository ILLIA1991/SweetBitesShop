package com.web.onlineshop.service;

import com.web.onlineshop.dto.FlavourCategoryDTO;

import java.util.List;

public interface FlavourCategoryService {

    List<FlavourCategoryDTO> getAllFlavours();

    FlavourCategoryDTO getFlavourById(Integer id);

    Integer createFlavour(FlavourCategoryDTO flavourCategoryDTO);

    void deleteById(Integer id);

    FlavourCategoryDTO updateFlavour(Integer id, FlavourCategoryDTO flavourToUpdate);
}
