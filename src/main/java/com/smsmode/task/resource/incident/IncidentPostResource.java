package com.smsmode.task.resource.incident;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Set;

@Data
public class IncidentPostResource {
    @NotBlank
    private String name;

    @NotBlank
    private String reporterId;

    private String reviewerId;

    private String rentalId;

    @NotBlank
    private String severity;

    @NotBlank
    private String status;

    private String tags;

    private String description;

    @NotNull
    private Set<String> categoryIds;

}
