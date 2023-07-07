package com.example.demo.service.impl;
import com.example.demo.entity.KhachHang;
import com.example.demo.repository.KhachHangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KhachHangService {

    @Autowired
    private KhachHangRepository khachHangRepository;

    public KhachHang findByMaKhachHang(String maKhachHang) {
        return khachHangRepository.findByMaKhachHang(maKhachHang);
    }
}
