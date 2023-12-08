package com.web.onlineshop.service.impl;

import com.web.onlineshop.dto.FlavourCategoryDTO;
import com.web.onlineshop.exception.OnlineShopNotFoundException;
import com.web.onlineshop.repository.FlavourCategoryRepository;
import com.web.onlineshop.repository.mappers.FlavourCategoryMapper;
import com.web.onlineshop.repository.model.FlavourCategory;
import com.web.onlineshop.service.FlavourCategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FlavourCategoryImpl implements FlavourCategoryService {
    private final FlavourCategoryRepository flavourCategoryRepository;
    private final FlavourCategoryMapper flavourCategoryMapper;

    public FlavourCategoryImpl(FlavourCategoryRepository flavourCategoryRepository, FlavourCategoryMapper flavourCategoryMapper) {
        this.flavourCategoryRepository = flavourCategoryRepository;
        this.flavourCategoryMapper = flavourCategoryMapper;
    }

    @Override
    public List<FlavourCategoryDTO> getAllFlavours() {
        List<FlavourCategory> allFlavourCategory = flavourCategoryRepository.findAll();

        return allFlavourCategory.stream()
                .map(flavourCategoryMapper::toFlavourCategoryDTO)
                .collect(Collectors.toList());
    }

    @Override
    public FlavourCategoryDTO getFlavourById(Integer id) {
        FlavourCategory flavourCategory = flavourCategoryRepository.findById(id).orElseThrow(() -> new OnlineShopNotFoundException("FlavourCategoryController is not found"));
        return flavourCategoryMapper.toFlavourCategoryDTO(flavourCategory);
    }
}