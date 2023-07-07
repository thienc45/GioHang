package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "KHACHHANG")
public class KhachHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "MAKHACHHANG")
    private String maKhachHang;

    @Column(name = "CCCD")
    private String cccd;

    @Column(name = "TEN")
    private String ten;

    @Column(name = "SDT")
    private String sdt;

    @Column(name = "CAPBAC")
    private Integer capBac;

    @Column(name = "DIACHI")
    private String diaChi;

    @Column(name = "MATKHAU")
    private String matKhau;
}
