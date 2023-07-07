package com.example.demo.service.impl;

import com.example.demo.entity.NSX;
import com.example.demo.repository.NSXRepository;
import com.example.demo.service.NSXService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class NSXServiceImpl implements NSXService {
    @Autowired
    private final NSXRepository nsxRepository;

    public NSXServiceImpl(NSXRepository nsxRepository) {
        this.nsxRepository = nsxRepository;
    }

    @Override
    public List<NSX> getAllNSX() {
        return nsxRepository.findAll();
    }

    @Override
    public NSX getNSXById(Integer id) {
        return nsxRepository.findById(id).orElse(null);
    }

    @Override
    public void saveNSX(NSX nsx) {
        nsxRepository.save(nsx);
    }

    @Override
    public void deleteNSX(Integer id) {
        nsxRepository.deleteById(id);
    }
}
