package com.example.tttn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.tttn.entity.Publisher;

@Repository
public interface PublisherRepository extends JpaRepository<Publisher, Long>{

}