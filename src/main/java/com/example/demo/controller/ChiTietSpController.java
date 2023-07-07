package com.example.demo.controller;

import com.example.demo.entity.ChiTietSP;
import com.example.demo.service.ChiTietSpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/chitietsp")
public class ChiTietSpController {
    @Autowired
    ChiTietSpService chiTietSpService;


    @GetMapping("/list")
    public String listChiTietSp(Model model) {
        List<ChiTietSP> chiTietSpList = chiTietSpService.getAllChiTietSp();
        model.addAttribute("chitietspList", chiTietSpList);
        return "chitietsp/chitietsp-list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        ChiTietSP chiTietSp = new ChiTietSP();
        model.addAttribute("chitietsp", chiTietSp);
        return "chitietsp/chitietsp-form";
    }

    @PostMapping("/save")
    public String saveChiTietSp(@ModelAttribute("chitietsp") ChiTietSP chiTietSp) {
        chiTietSpService.saveChiTietSp(chiTietSp);
        return "redirect:/chitietsp/list";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model) {
        ChiTietSP chiTietSp = chiTietSpService.getChiTietSpById(id);
        model.addAttribute("chitietsp", chiTietSp);
        return "chitietsp/chitietsp-form";
    }

    @GetMapping("/delete/{id}")
    public String deleteChiTietSp(@PathVariable("id") Integer id) {
        chiTietSpService.deleteChiTietSp(id);
        return "redirect:/chitietsp/list";
    }

}
