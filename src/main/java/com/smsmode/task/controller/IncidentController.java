package com.smsmode.task.controller;

import com.smsmode.task.resource.incident.IncidentPostResource;
import com.smsmode.task.resource.incident.IncidentItemGetResource;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

@RequestMapping("/incidents")
public interface IncidentController {
    @PostMapping(consumes = "multipart/form-data")
    ResponseEntity<IncidentItemGetResource> createIncident(
            @RequestPart("payload") @Valid IncidentPostResource incidentPostResource,
            @RequestPart(value = "file", required = false) MultipartFile[] incidentImages);

}
