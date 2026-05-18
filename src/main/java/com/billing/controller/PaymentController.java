package com.billing.controller;
import com.billing.dto.PaymentDTO;
import com.billing.service.PaymentService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService service;

    @PostMapping
    public PaymentDTO createPayment(
            @RequestBody PaymentDTO dto) {

        return service.createPayment(dto);
    }

    @GetMapping
    public List<PaymentDTO> getAllPayments() {

        return service.getAllPayments();
    }

    @GetMapping("/{id}")
    public PaymentDTO getPaymentById(
            @PathVariable Long id) {

        return service.getPaymentById(id);
    }
}
