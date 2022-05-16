package com.example.tttn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.tttn.entity.Reservation;

@Repository
public interface BorrowRepository extends JpaRepository<Reservation, Long>{

}