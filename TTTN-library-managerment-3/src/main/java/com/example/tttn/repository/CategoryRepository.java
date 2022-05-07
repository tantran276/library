package com.example.tttn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tttn.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
