package com.billing.controller;
import com.billing.dto.PlanDTO;
import com.billing.service.PlanService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/plans")
@RequiredArgsConstructor
public class PlanController {

    private final PlanService service;

    @PostMapping
    public PlanDTO createPlan(@RequestBody PlanDTO dto) {

        return service.createPlan(dto);
    }

    @GetMapping
    public List<PlanDTO> getAllPlans() {

        return service.getAllPlans();
    }

    @GetMapping("/{id}")
    public PlanDTO getPlanById(@PathVariable Long id) {

        return service.getPlanById(id);
    }

    @PutMapping("/{id}")
    public PlanDTO updatePlan(@PathVariable Long id,
                              @RequestBody PlanDTO dto) {

        return service.updatePlan(id, dto);
    }

    @DeleteMapping("/{id}")
    public String deletePlan(@PathVariable Long id) {

        service.deletePlan(id);

        return "Plan deleted successfully";
    }
}
