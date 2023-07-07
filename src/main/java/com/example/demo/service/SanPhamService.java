package com.example.demo.service;

import com.example.demo.entity.SanPham;

import java.util.List;
import java.util.Optional;

public interface SanPhamService {
    List<SanPham> getAllSanPham();
    Optional<SanPham> getSanPhamById(Integer id);
    SanPham createSanPham(SanPham sanPham);
    SanPham updateSanPham(Integer id, SanPham sanPham);
    void deleteSanPham(Integer id);
}
