package com.billing.controller;
import com.billing.dto.SubscriptionDTO;
import com.billing.service.SubscriptionService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subscriptions")
@RequiredArgsConstructor
public class SubscriptionController {

    private final SubscriptionService service;

    @PostMapping
    public SubscriptionDTO createSubscription(
            @RequestBody SubscriptionDTO dto) {

        return service.createSubscription(dto);
    }

    @GetMapping
    public List<SubscriptionDTO> getAllSubscriptions() {

        return service.getAllSubscriptions();
    }

    @GetMapping("/{id}")
    public SubscriptionDTO getSubscriptionById(
            @PathVariable Long id) {

        return service.getSubscriptionById(id);
    }

    @PutMapping("/{id}")
    public SubscriptionDTO updateSubscription(
            @PathVariable Long id,
            @RequestBody SubscriptionDTO dto) {

        return service.updateSubscription(id, dto);
    }

    @DeleteMapping("/{id}")
    public String deleteSubscription(
            @PathVariable Long id) {

        service.deleteSubscription(id);

        return "Subscription deleted successfully";
    }
}
