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
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "HOADON")
public class HoaDon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "MAHOADON")
    private String maHoaDon;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IDNHANVIEN")
    private NhanVien nhanVien;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IDKHACHHANG")
    private KhachHang khachHang;

    @Column(name = "SDT")
    private String sdt;

    @Column(name = "DIACHI")
    private String diaChi;

    @Column(name = "HINHTHUCGIAOHANG")
    private Integer hinhThucGiaoHang;

    @Column(name = "HINHTHUCTHANHTOAN")
    private Integer hinhThucThanhToan;

    @Column(name = "LYDO")
    private String lyDo;

    @Column(name = "NGAYSHIP")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date ngayShip;

    @Column(name = "NGAYTHANHTOAN")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date ngayThanhToan;

    @Column(name = "TIENKHACHTRA")
    private Integer tienKhachTra;

    @Column(name = "TIENKHACHCHUYENKHOAN")
    private Integer tienKhachChuyenKhoan;

    @Column(name = "NGAYTAO")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date ngayTao = new Date();

    @Column(name = "TRANGTHAI")
    private Integer trangThai;

    @Column(name = "TONGTIEN")
    private Integer tongTien;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IDKHUYENMAI")
    private KhuyenMai khuyenMai;

    @Column(name = "TIENSAUGIAMGIA")
    private Integer tienSauGiamGia;
}
