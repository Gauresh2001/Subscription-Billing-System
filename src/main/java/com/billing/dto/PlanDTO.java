package com.billing.dto;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PlanDTO {

    private Long id;

    private String planName;

    private Double price;

    private Integer durationInMonths;

    private String description;

    private String status;
}
