package com.example.demo.service;

import com.example.demo.entity.MauSac;

import java.util.List;

public interface MauSacService {

    List<MauSac> getAllMauSac();

    MauSac getMauSacById(Integer id);

    void saveMauSac(MauSac mauSac);

    void deleteMauSac(Integer id);
}
