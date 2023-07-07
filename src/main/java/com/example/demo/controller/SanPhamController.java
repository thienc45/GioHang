package com.example.demo.controller;

import com.example.demo.entity.SanPham;
import com.example.demo.service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sanpham")
public class SanPhamController {
    @Autowired
    private SanPhamService sanPhamService;

    @GetMapping("/")
    public String getAllSanPham(Model model) {
        model.addAttribute("sanphams", sanPhamService.getAllSanPham());
        return "/sanpham/sanpham-list";
    }

    @GetMapping("/create")
    public String createSanPhamForm(Model model) {
        model.addAttribute("sanpham", new SanPham());
        return "/sanpham/sanpham-form";
    }

    @PostMapping("/create")
    public String createSanPhamSubmit(@ModelAttribute SanPham sanPham) {
        sanPhamService.createSanPham(sanPham);
        return "redirect:/sanpham/";
    }

    @GetMapping("/edit/{id}")
    public String editSanPhamForm(@PathVariable  Integer id, Model model) {
        model.addAttribute("sanpham", sanPhamService.getSanPhamById(id).orElse(null));
        return "/sanpham/sanpham-form";
    }

    @PostMapping("/edit/{id}")
    public String editSanPhamSubmit(@PathVariable Integer id, @ModelAttribute SanPham sanPham) {
        sanPhamService.updateSanPham(id, sanPham);
        return "redirect:/sanpham/";
    }

    @GetMapping("/delete/{id}")
    public String deleteSanPham(@PathVariable Integer id) {
        sanPhamService.deleteSanPham(id);
        return "redirect:/sanpham/";
    }

}
