package com.smsmode.task.service;

import com.smsmode.task.resource.incident.IncidentItemGetResource;
import com.smsmode.task.resource.incident.IncidentPostResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface IncidentService {
    ResponseEntity<IncidentItemGetResource> create(IncidentPostResource incidentPostResource, MultipartFile[] incidentImages);
}
