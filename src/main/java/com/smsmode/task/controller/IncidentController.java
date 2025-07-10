package com.smsmode.task.controller;

import com.smsmode.task.resource.incident.IncidentPostResource;
import com.smsmode.task.resource.incident.IncidentItemGetResource;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@RequestMapping("/incidents")
public interface IncidentController {

    @PostMapping(consumes = "multipart/form-data")
    ResponseEntity<IncidentItemGetResource> createIncident(
            @RequestPart("payload") @Valid IncidentPostResource incidentPostResource,
            @RequestPart(value = "files", required = false) MultipartFile[] incidentImages);

    @GetMapping
    ResponseEntity<Page<IncidentItemGetResource>> getAllIncidents(
            @RequestParam(value = "search", required = false) String search,
            Pageable pageable);

}
