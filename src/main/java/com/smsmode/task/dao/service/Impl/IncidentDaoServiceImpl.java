package com.smsmode.task.dao.service.Impl;

import com.smsmode.task.dao.service.IncidentDaoService;
import com.smsmode.task.dao.repository.IncidentRepository;
import com.smsmode.task.model.IncidentModel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class IncidentDaoServiceImpl implements IncidentDaoService {

    private final IncidentRepository incidentRepository;

    @Override
    public IncidentModel save(IncidentModel incidentModel) {
        return incidentRepository.save(incidentModel);
    }
}
