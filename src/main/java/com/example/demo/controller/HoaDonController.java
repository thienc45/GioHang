package com.example.demo.controller;

import com.example.demo.entity.ChiTietSP;
import com.example.demo.entity.HoaDon;
import com.example.demo.entity.HoaDonChiTiet;
import com.example.demo.service.ChiTietSpService;
import com.example.demo.service.HoaDonChiTietService;
import com.example.demo.service.HoaDonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/giohang")
public class HoaDonController {
    private final HoaDonService hoaDonService;
    private final HoaDonChiTietService hoaDonChiTietService;
    private final ChiTietSpService chiTietSPService;

    @Autowired
    public HoaDonController(HoaDonService hoaDonService, HoaDonChiTietService hoaDonChiTietService,
                            ChiTietSpService chiTietSPService) {
        this.hoaDonService = hoaDonService;
        this.hoaDonChiTietService = hoaDonChiTietService;
        this.chiTietSPService = chiTietSPService;
    }

//    @GetMapping("/danh-sach")
//    public String danhSachHoaDon(Model model) {
//        // Lấy danh sách hóa đơn từ service
//        List<HoaDon> hoaDonList = hoaDonService.getAllHoaDon();
//        // Thêm danh sách hóa đơn vào model để truyền cho view
//        model.addAttribute("hoaDonList", hoaDonList);
//        return "danh-sach-hoa-don";
//    }

    @GetMapping("/danh-sach")
    public String danhSachHoaDon(Model model) {
        // Lấy danh sách hóa đơn từ service
        List<HoaDon> hoaDonList = hoaDonService.getAllHoaDon();

        // Tính tổng tiền cho mỗi hóa đơn
        for (HoaDon hoaDon : hoaDonList) {
            List<HoaDonChiTiet> hoaDonChiTietList = hoaDonChiTietService.getHoaDonChiTietByHoaDon(hoaDon);
            int tongTien = 0;
            for (HoaDonChiTiet hoaDonChiTiet : hoaDonChiTietList) {
                int thanhTien = hoaDonChiTiet.getSoLuong() * hoaDonChiTiet.getDonGia();
                tongTien += thanhTien;
            }
            hoaDon.setTongTien(tongTien);
        }

        // Thêm danh sách hóa đơn vào model để truyền cho view
        model.addAttribute("hoaDonList", hoaDonList);

        return "danh-sach-hoa-don";
    }

    @GetMapping("/tao-hoa-don")
    public String taoHoaDon(Model model) {
        // Tạo đối tượng HoaDon và thêm vào model để truyền cho view
        HoaDon hoaDon = new HoaDon();
        model.addAttribute("hoaDon", hoaDon);
        return "tao-hoa-don";
    }

    @PostMapping("/luu-hoa-don")
    public String luuHoaDon(@ModelAttribute("hoaDon") HoaDon hoaDon) {
        // Lưu hóa đơn vào cơ sở dữ liệu thông qua service
        hoaDonService.saveHoaDon(hoaDon);
        return "redirect:/giohang/danh-sach";
    }

    @GetMapping("/them-san-pham/{hoaDonId}")
    public String themSanPham(@PathVariable("hoaDonId") Integer hoaDonId, Model model) {
        // Lấy hóa đơn theo ID
        HoaDon hoaDon = hoaDonService.getHoaDonById(hoaDonId);
        // Lấy danh sách chi tiết sản phẩm từ service
        List<ChiTietSP> chiTietSPList = chiTietSPService.getAllChiTietSp();
        // Thêm danh sách chi tiết sản phẩm và hóa đơn vào model để truyền cho view
        model.addAttribute("chiTietSPList", chiTietSPList);
        model.addAttribute("hoaDon", hoaDon);
        return "them-san-pham";
    }

    @PostMapping("/luu-san-pham")
    public String luuSanPham(@RequestParam("hoaDonId") Integer hoaDonId, @RequestParam("chiTietSPId") Integer chiTietSPId) {
        // Lấy hóa đơn theo ID
        HoaDon hoaDon = hoaDonService.getHoaDonById(hoaDonId);
        // Lấy chi tiết sản phẩm theo ID
        ChiTietSP chiTietSP = chiTietSPService.getChiTietSpById(chiTietSPId);
        // Tạo đối tượng HoaDonChiTiet và thiết lập hóa đơn và chi tiết sản phẩm
        HoaDonChiTiet hoaDonChiTiet = new HoaDonChiTiet();
        hoaDonChiTiet.setHoaDon(hoaDon);
        hoaDonChiTiet.setChiTietSP(chiTietSP);
        hoaDonChiTiet.setTenSP(chiTietSP.getSanPham().getTen());
        hoaDonChiTiet.setSoLuong(1);
        hoaDonChiTiet.setDonGia(chiTietSP.getGia());
        // Lưu hóa đơn chi tiết vào cơ sở dữ liệu thông qua service
        hoaDonChiTietService.saveHoaDonChiTiet(hoaDonChiTiet);
        return "redirect:/giohang/danh-sach";
    }

    @PostMapping("/thanh-toan/{hoaDonId}")
    public String thanhToan(@PathVariable("hoaDonId") Integer hoaDonId, @RequestParam("soTien") Integer soTien, RedirectAttributes redirectAttributes) {
        HoaDon hoaDon = hoaDonService.getHoaDonById(hoaDonId);

        // Tính tổng tiền
        List<HoaDonChiTiet> hoaDonChiTietList = hoaDonChiTietService.getHoaDonChiTietByHoaDon(hoaDon);
        int tongTien = 0;
        for (HoaDonChiTiet hoaDonChiTiet : hoaDonChiTietList) {
            int thanhTien = hoaDonChiTiet.getSoLuong() * hoaDonChiTiet.getDonGia();
            tongTien += thanhTien;
        }
        hoaDon.setTongTien(tongTien);

        if (soTien >= hoaDon.getTongTien()) {
            // Thực hiện thanh toán
            hoaDon.setTrangThai(2);
            hoaDonService.saveHoaDon(hoaDon);
            return "redirect:/giohang/danh-sach";
        } else {
            // Gửi thông báo lỗi
            redirectAttributes.addFlashAttribute("error", "not_enough_money");
            return "redirect:/giohang/danh-sach";
        }
    }


    @GetMapping("/chi-tiet/{hoaDonId}")
    public String chiTietHoaDon(@PathVariable("hoaDonId") Integer hoaDonId, Model model) {
        // Lấy hóa đơn theo ID
        HoaDon hoaDon = hoaDonService.getHoaDonById(hoaDonId);

        // Lấy danh sách chi tiết sản phẩm của hóa đơn từ service
        List<HoaDonChiTiet> hoaDonChiTietList = hoaDonChiTietService.getHoaDonChiTietByHoaDon(hoaDon);

        // Tạo HashMap để lưu trữ thông tin chi tiết sản phẩm
        Map<String, Integer> chiTietSanPham = new HashMap<>();

        // Tính tổng số lượng và tổng tiền
        int tongSoLuong = 0;
        int tongTien = 0;
        for (HoaDonChiTiet hoaDonChiTiet : hoaDonChiTietList) {
            String tenSanPham = hoaDonChiTiet.getTenSP();
            int soLuong = hoaDonChiTiet.getSoLuong();
            int donGia = hoaDonChiTiet.getDonGia();

            // Cập nhật số lượng sản phẩm trong HashMap
            chiTietSanPham.put(tenSanPham, chiTietSanPham.getOrDefault(tenSanPham, 0) + soLuong);

            // Tính tổng tiền
            int thanhTien = soLuong * donGia;
            tongTien += thanhTien;

            // Cập nhật tổng số lượng
            tongSoLuong += soLuong;
        }

        // Thêm danh sách chi tiết sản phẩm, hóa đơn, tổng số lượng và tổng tiền vào model để truyền cho view
        model.addAttribute("hoaDonChiTietList", hoaDonChiTietList);
        model.addAttribute("hoaDon", hoaDon);
        model.addAttribute("chiTietSanPham", chiTietSanPham);
        model.addAttribute("tongSoLuong", tongSoLuong);
        model.addAttribute("tongTien", tongTien);

        return "chi-tiet-hoa-don";
    }




}
