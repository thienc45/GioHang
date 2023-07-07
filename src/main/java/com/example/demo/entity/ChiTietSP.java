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
@Table(name = "CHITIETSP")
public class ChiTietSP {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "MACTSP")
    private String maCTSP;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IDSP")
    private SanPham sanPham;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IDDONGSP")
    private DongSP dongSP;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IDMAUSAC")
    private MauSac mauSac;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IDCHATLIEU")
    private ChatLieu chatLieu;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IDSIZE")
    private Size size;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IDNSX")
    private NSX nsx;

    @Column(name = "ANH")
    private String anh;

    @Column(name = "SOLUONGTON")
    private Integer soLuongTon;

    @Column(name = "GIA")
    private Integer gia;

    @Column(name = "MAVACH")
    private Integer maVach;

    @Column(name = "MOTA")
    private String moTa;
}
