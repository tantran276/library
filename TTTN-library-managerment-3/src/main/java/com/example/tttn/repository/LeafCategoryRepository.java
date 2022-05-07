package com.example.tttn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tttn.entity.Category;

public interface LeafCategoryRepository extends JpaRepository<Category, Long>{

}
