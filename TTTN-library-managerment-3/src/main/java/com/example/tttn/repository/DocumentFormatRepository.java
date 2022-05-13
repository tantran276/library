package com.example.tttn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.tttn.entity.DocumentFormat;

@Repository
public interface DocumentFormatRepository extends JpaRepository<DocumentFormat, Long>{

}
