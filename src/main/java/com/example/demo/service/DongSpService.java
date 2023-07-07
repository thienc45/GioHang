package com.example.demo.service;

import com.example.demo.entity.DongSP;

import java.util.List;

public interface DongSpService {
    List<DongSP> getAllDongSp();

    DongSP getDongSpById(Integer id);

    void saveDongSp(DongSP dongSp);

    void deleteDongSp(Integer id);
}
