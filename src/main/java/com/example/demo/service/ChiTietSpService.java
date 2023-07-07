package com.example.demo.service;

import com.example.demo.entity.ChiTietSP;

import java.util.List;

public interface ChiTietSpService {

    List<ChiTietSP> getAllChiTietSp();

    ChiTietSP getChiTietSpById(Integer id);

    void saveChiTietSp(ChiTietSP chiTietSp);

    void deleteChiTietSp(Integer id);

    List<ChiTietSP> getChiTietSPByHoaDonId(Integer hoaDonId);
}
