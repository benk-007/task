package com.smsmode.task.controller.impl;

import com.smsmode.task.controller.IncidentController;
import com.smsmode.task.resource.incident.IncidentItemGetResource;
import com.smsmode.task.resource.incident.IncidentPostResource;
import com.smsmode.task.service.IncidentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
public class IncidentControllerImpl implements IncidentController {

    private final IncidentService incidentService;

    @Override
    public ResponseEntity<IncidentItemGetResource> createIncident(IncidentPostResource incidentPostResource, MultipartFile[] incidentImages) {
        return incidentService.create(incidentPostResource, incidentImages);
    }
}
