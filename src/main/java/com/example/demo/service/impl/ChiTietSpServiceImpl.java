package com.example.demo.service.impl;

import com.example.demo.entity.ChiTietSP;
import com.example.demo.repository.ChiTietSpRepository;
import com.example.demo.service.ChiTietSpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChiTietSpServiceImpl implements ChiTietSpService {
    @Autowired
    ChiTietSpRepository chiTietSpRepository;


    @Override
    public List<ChiTietSP> getAllChiTietSp() {
        return chiTietSpRepository.findAll();
    }

    @Override
    public ChiTietSP getChiTietSpById(Integer id) {
        return chiTietSpRepository.findById(id).orElse(null);
    }

    @Override
    public void saveChiTietSp(ChiTietSP chiTietSp) {
        chiTietSpRepository.save(chiTietSp);
    }

    @Override
    public void deleteChiTietSp(Integer id) {
        chiTietSpRepository.deleteById(id);
    }

    @Override
    public List<ChiTietSP> getChiTietSPByHoaDonId(Integer hoaDonId) {
        return null;
    }

}
