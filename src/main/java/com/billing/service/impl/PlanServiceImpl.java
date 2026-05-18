package com.billing.service.impl;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import com.billing.dto.PlanDTO;
import com.billing.entity.Plan;
import com.billing.repository.PlanRepository;
import com.billing.service.PlanService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PlanServiceImpl implements PlanService {

    private final PlanRepository repository;

    @Override
    public PlanDTO createPlan(PlanDTO dto) {

        Plan plan = Plan.builder()
                .planName(dto.getPlanName())
                .price(dto.getPrice())
                .durationInMonths(dto.getDurationInMonths())
                .description(dto.getDescription())
                .status(dto.getStatus())
                .build();

        Plan saved = repository.save(plan);

        return mapToDTO(saved);
    }

    @Override
    public List<PlanDTO> getAllPlans() {

        return repository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PlanDTO getPlanById(Long id) {

        Plan plan = repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Plan not found"));

        return mapToDTO(plan);
    }

    @Override
    public PlanDTO updatePlan(Long id, PlanDTO dto) {

        Plan plan = repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Plan not found"));

        plan.setPlanName(dto.getPlanName());
        plan.setPrice(dto.getPrice());
        plan.setDurationInMonths(dto.getDurationInMonths());
        plan.setDescription(dto.getDescription());
        plan.setStatus(dto.getStatus());

        Plan updated = repository.save(plan);

        return mapToDTO(updated);
    }

    @Override
    public void deletePlan(Long id) {

        repository.deleteById(id);
    }

    private PlanDTO mapToDTO(Plan plan) {

        return PlanDTO.builder()
                .id(plan.getId())
                .planName(plan.getPlanName())
                .price(plan.getPrice())
                .durationInMonths(plan.getDurationInMonths())
                .description(plan.getDescription())
                .status(plan.getStatus())
                .build();
    }
}
