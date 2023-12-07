package com.web.onlineshop.repository;

import com.web.onlineshop.repository.model.FlavourCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlavourCategoryRepository extends JpaRepository<FlavourCategory, Integer> {

}
