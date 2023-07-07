package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "HOADONCHITIET")
public class HoaDonChiTiet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IDHOADON")
    private HoaDon hoaDon;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IDCTSP")
    private ChiTietSP chiTietSP;

    @Column(name = "TENSP")
    private String tenSP;

    @Column(name = "TENNSX")
    private String tenNSX;

    @Column(name = "DONGSP")
    private String dongSP;

    @Column(name = "MAUSAC")
    private String mauSac;

    @Column(name = "ANH")
    private String anh;

    @Column(name = "SIZE")
    private String size;

    @Column(name = "SOLUONG")
    private Integer soLuong;

    @Column(name = "DONGIA")
    private Integer donGia;

    @Column(name = "TRANGTHAI")
    private Integer trangThai;
}
