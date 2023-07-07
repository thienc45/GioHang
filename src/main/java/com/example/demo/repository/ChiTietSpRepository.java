package com.example.demo.repository;

import com.example.demo.entity.ChiTietSP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChiTietSpRepository extends JpaRepository<ChiTietSP, Integer> {



}
