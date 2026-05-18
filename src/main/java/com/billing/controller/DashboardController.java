package com.billing.controller;
import com.billing.dto.DashboardDTO;
import com.billing.service.DashboardService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/dashboard")
@RequiredArgsConstructor
public class DashboardController {

    private final DashboardService service;

    @GetMapping
    public DashboardDTO getDashboardData() {

        return service.getDashboardData();
    }
}
