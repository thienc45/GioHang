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

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "NHANVIEN")
public class NhanVien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "MANV")
    private String maNV;

    @Column(name = "CCCD")
    private String cccd;

    @Column(name = "TEN")
    private String ten;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IDCHUCVU")
    private ChucVu chucVu;

    @Column(name = "GIOITINH")
    private boolean gioiTinh;

    @Column(name = "NGAYSINH")
    private Date ngaySinh;

    @Column(name = "SDT")
    private String sdt;

    @Column(name = "DIACHI")
    private String diaChi;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "MATKHAU")
    private String matKhau;

    @Column(name = "TRANGTHAI")
    private boolean trangThai;
}
