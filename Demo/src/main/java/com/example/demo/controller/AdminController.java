package com.example.demo.controller;

import com.example.demo.domain.Admin;
import com.example.demo.service.AdminService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("admin")
@Slf4j
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;

    @GetMapping
    public ResponseEntity<List<Admin>> listAll() {

        return ResponseEntity.ok(adminService.listAll());
    }

    @PostMapping
    public ResponseEntity<Admin> save(@RequestBody Admin admin) {

        Admin newAdmin = adminService.save(admin);
        return ResponseEntity.ok(newAdmin);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Admin> delete(@PathVariable int id) {

        adminService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
