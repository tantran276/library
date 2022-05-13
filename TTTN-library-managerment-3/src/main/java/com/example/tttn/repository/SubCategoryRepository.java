package com.example.tttn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.tttn.entity.SubCategory;

@Repository
public interface SubCategoryRepository extends JpaRepository<SubCategory, Long>{

}