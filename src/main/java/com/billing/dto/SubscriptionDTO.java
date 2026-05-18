package com.billing.dto;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SubscriptionDTO {

	  private Long id;

	    private LocalDate startDate;

	    private LocalDate endDate;

	    private String status;

	    private Long userId;

	    private Long planId;
}
