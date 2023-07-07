package com.example.demo.service;

import com.example.demo.entity.Size;

import java.util.List;

public interface SizeService {
    List<Size> getAllSizes();

    Size getSizeById(Integer id);

    void saveSize(Size size);

    void deleteSize(Integer id);
}
