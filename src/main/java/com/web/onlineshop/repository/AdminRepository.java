package com.web.onlineshop.repository;

import com.web.onlineshop.repository.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
}
