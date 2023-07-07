package com.example.demo.service;

import com.example.demo.entity.NSX;

import java.util.List;

public interface   NSXService {
    List<NSX> getAllNSX();

    NSX getNSXById(Integer id);

    void saveNSX(NSX nsx);

    void deleteNSX(Integer id);
}
