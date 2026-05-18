package com.billing.service;

import java.util.List;

import com.billing.dto.PlanDTO;

public interface PlanService {

    PlanDTO createPlan(PlanDTO dto);

    List<PlanDTO> getAllPlans();

    PlanDTO getPlanById(Long id);

    PlanDTO updatePlan(Long id, PlanDTO dto);

    void deletePlan(Long id);
}
