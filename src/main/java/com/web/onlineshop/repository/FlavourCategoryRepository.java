package com.web.onlineshop.repository;

import com.web.onlineshop.dto.FlavourCategoryDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlavourCategoryRepository extends JpaRepository<FlavourCategoryDTO, Integer> {
}
