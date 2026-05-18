package com.billing.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DashboardDTO {

    private Long totalUsers;

    private Long totalPlans;

    private Long totalSubscriptions;

    private Long totalPayments;
    
    private Double totalRevenue;

}
