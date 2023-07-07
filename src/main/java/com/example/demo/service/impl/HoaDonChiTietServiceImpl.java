package com.example.demo.service.impl;

import com.example.demo.entity.ChiTietSP;
import com.example.demo.entity.HoaDon;
import com.example.demo.entity.HoaDonChiTiet;
import com.example.demo.repository.HoaDonChiTietRepository;
import com.example.demo.service.HoaDonChiTietService;
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class HoaDonChiTietServiceImpl implements HoaDonChiTietService {
    private final HoaDonChiTietRepository hoaDonChiTietRepository;

    @Autowired
    public HoaDonChiTietServiceImpl(HoaDonChiTietRepository hoaDonChiTietRepository) {
        this.hoaDonChiTietRepository = hoaDonChiTietRepository;
    }



    @Override
    public List<HoaDonChiTiet> getAllHoaDonChiTiet() {
        return hoaDonChiTietRepository.findAll();
    }

    @Override
    public HoaDonChiTiet getHoaDonChiTietById(Integer id) {
        return hoaDonChiTietRepository.findById(id).orElse(null);
    }

    @Override
    public void saveHoaDonChiTiet(HoaDonChiTiet hoaDonChiTiet) {
        hoaDonChiTietRepository.save(hoaDonChiTiet);
    }

    @Override
    public void deleteHoaDonChiTiet(Integer id) {
        hoaDonChiTietRepository.deleteById(id);
    }



    public List<HoaDonChiTiet> getHoaDonChiTietByHoaDon(HoaDon hoaDon) {
        return hoaDonChiTietRepository.findByHoaDon(hoaDon);
    }
}
