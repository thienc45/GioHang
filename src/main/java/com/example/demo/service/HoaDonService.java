package com.example.demo.service;

import com.example.demo.entity.HoaDon;

import java.util.List;

public interface HoaDonService {

    List<HoaDon> getAllHoaDon();

    HoaDon getHoaDonById(Integer id);

    void saveHoaDon(HoaDon hoaDon);

    void deleteHoaDon(Integer id);
}
