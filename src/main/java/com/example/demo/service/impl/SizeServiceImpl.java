package com.example.demo.service.impl;

import com.example.demo.entity.Size;
import com.example.demo.repository.SizeRepository;
import com.example.demo.service.SizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SizeServiceImpl implements SizeService{
    @Autowired
    SizeRepository sizeRepository;

    @Override
    public List<Size> getAllSizes() {
        return sizeRepository.findAll();
    }

    @Override
    public Size getSizeById(Integer id) {
        return sizeRepository.findById(id).orElse(null);
    }

    @Override
    public void saveSize(Size size) {
        sizeRepository.save(size);
    }

    @Override
    public void deleteSize(Integer id) {
        sizeRepository.deleteById(id);
    }
}
