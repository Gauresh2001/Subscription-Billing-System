package com.billing.service.impl;


import com.billing.dto.SubscriptionDTO;
import com.billing.entity.Plan;
import com.billing.entity.Subscription;
import com.billing.entity.User;
import com.billing.repository.PlanRepository;
import com.billing.repository.SubscriptionRepository;
import com.billing.repository.UserRepository;
import com.billing.service.SubscriptionService;


import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SubscriptionServiceImpl
        implements SubscriptionService {

    private final SubscriptionRepository repository;
    private final UserRepository userRepository;
    private final PlanRepository planRepository;

    @Override
    public SubscriptionDTO createSubscription(
            SubscriptionDTO dto) {

        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() ->
                        new RuntimeException("User not found"));

        Plan plan = planRepository.findById(dto.getPlanId())
                .orElseThrow(() ->
                        new RuntimeException("Plan not found"));

        Subscription subscription = Subscription.builder()
                .startDate(dto.getStartDate())
                .endDate(dto.getEndDate())
                .status(dto.getStatus())
                .user(user)
                .plan(plan)
                .build();

        Subscription saved = repository.save(subscription);

        return mapToDTO(saved);
    }

    @Override
    public List<SubscriptionDTO> getAllSubscriptions() {

        return repository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public SubscriptionDTO getSubscriptionById(Long id) {

        Subscription subscription = repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Subscription not found"));

        return mapToDTO(subscription);
    }

    @Override
    public SubscriptionDTO updateSubscription(
            Long id,
            SubscriptionDTO dto) {

        Subscription subscription = repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Subscription not found"));

        subscription.setStatus(dto.getStatus());

        Subscription updated = repository.save(subscription);

        return mapToDTO(updated);
    }

    @Override
    public void deleteSubscription(Long id) {

        repository.deleteById(id);
    }

    private SubscriptionDTO mapToDTO(
            Subscription subscription) {

        return SubscriptionDTO.builder()
                .id(subscription.getId())
                .startDate(subscription.getStartDate())
                .endDate(subscription.getEndDate())
                .status(subscription.getStatus())
                .userId(subscription.getUser().getId())
                .planId(subscription.getPlan().getId())
                .build();
    }
}
