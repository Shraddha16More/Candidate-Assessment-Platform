package com.sp.assess.controller;

import com.sp.assess.entity.Admin;
import com.sp.assess.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    // Register Admin
    @PostMapping("/register")
    public Admin registerAdmin(@RequestBody Admin admin) {
        return adminService.registerAdmin(admin);
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        return adminService.authenticate(username, password);
    }
}
