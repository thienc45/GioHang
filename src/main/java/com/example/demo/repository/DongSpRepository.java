package com.example.demo.repository;

import com.example.demo.entity.DongSP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DongSpRepository extends JpaRepository<DongSP, Integer> {
}
