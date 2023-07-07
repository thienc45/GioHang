package com.example.demo.service.impl;

import com.example.demo.entity.MauSac;
import com.example.demo.repository.MauSacRepository;
import com.example.demo.service.MauSacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MauSacServiceImpl  implements MauSacService {
   @Autowired
   MauSacRepository mauSacRepository;

    @Override
    public List<MauSac> getAllMauSac() {
        return mauSacRepository.findAll();
    }

    @Override
    public MauSac getMauSacById(Integer id) {
        return mauSacRepository.findById(id).orElse(null);
    }

    @Override
    public void saveMauSac(MauSac mauSac) {
        mauSacRepository.save(mauSac);
    }

    @Override
    public void deleteMauSac(Integer id) {
        mauSacRepository.deleteById(id);
    }
}
