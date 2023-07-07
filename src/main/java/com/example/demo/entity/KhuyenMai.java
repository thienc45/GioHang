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

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "KHUYENMAI")
public class KhuyenMai {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "MAKHUYENMAI")
    private String maKhuyenMai;

    @Column(name = "TEN")
    private String ten;

    @Column(name = "MUCGIAMGIA")
    private Integer mucGiamGia;

    @Column(name = "NGAYBATDAU")
    private Date ngayBatDau;

    @Column(name = "NGAYKETTHUC")
    private Date ngayKetThuc;

    @Column(name = "TRANGTHAI")
    private Integer trangThai;
}
