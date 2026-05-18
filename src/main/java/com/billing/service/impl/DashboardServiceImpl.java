package com.billing.service.impl;
import org.springframework.stereotype.Service;

import com.billing.dto.DashboardDTO;
import com.billing.service.DashboardService;

@Service
public class DashboardServiceImpl
        implements DashboardService {

    @Override
    public DashboardDTO getDashboardData() {

        return DashboardDTO.builder()
                .totalUsers(100L)
                .totalPlans(10L)
                .totalSubscriptions(50L)
                .totalPayments(25L)
                .totalRevenue(50000.0)
                .build();
    }
}
