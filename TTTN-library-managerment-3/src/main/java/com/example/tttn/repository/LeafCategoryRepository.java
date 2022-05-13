package com.example.tttn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.tttn.entity.Category;

@Repository
public interface LeafCategoryRepository extends JpaRepository<Category, Long>{

}
