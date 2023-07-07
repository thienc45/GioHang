package com.example.demo.service;

import com.example.demo.entity.ChiTietSP;
import com.example.demo.entity.HoaDon;
import com.example.demo.entity.HoaDonChiTiet;

import java.util.List;

public interface HoaDonChiTietService {

    List<HoaDonChiTiet> getAllHoaDonChiTiet();

    HoaDonChiTiet getHoaDonChiTietById(Integer id);

    void saveHoaDonChiTiet(HoaDonChiTiet hoaDonChiTiet);

    void deleteHoaDonChiTiet(Integer id);


    List<HoaDonChiTiet> getHoaDonChiTietByHoaDon(HoaDon hoaDon);
}
