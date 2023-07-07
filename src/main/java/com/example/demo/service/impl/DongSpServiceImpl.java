package com.example.demo.service.impl;


import com.example.demo.entity.DongSP;
import com.example.demo.repository.DongSpRepository;
import com.example.demo.service.DongSpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DongSpServiceImpl implements DongSpService {
    @Autowired
    DongSpRepository dongSpRepository;

    @Override
    public List<DongSP> getAllDongSp() {
        return dongSpRepository.findAll();
    }

    @Override
    public DongSP getDongSpById(Integer id) {
        return dongSpRepository.findById(id).orElse(null);
    }

    @Override
    public void saveDongSp(DongSP dongSp) {
        dongSpRepository.save(dongSp);
    }



    @Override
    public void deleteDongSp(Integer id) {
        dongSpRepository.deleteById(id);
    }
}
