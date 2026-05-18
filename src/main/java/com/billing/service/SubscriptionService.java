package com.billing.service;

import java.util.List;

import com.billing.dto.SubscriptionDTO;

public interface SubscriptionService {

    SubscriptionDTO createSubscription(SubscriptionDTO dto);

    List<SubscriptionDTO> getAllSubscriptions();

    SubscriptionDTO getSubscriptionById(Long id);

    SubscriptionDTO updateSubscription(Long id,
                                       SubscriptionDTO dto);

    void deleteSubscription(Long id);
}
