package com.smsmode.task.service.impl;

import com.smsmode.task.dao.service.CategoryDaoService;
import com.smsmode.task.dao.service.ImageDaoService;
import com.smsmode.task.dao.service.IncidentDaoService;
import com.smsmode.task.dao.specification.CategorySpecification;
import com.smsmode.task.exception.InternalServerException;
import com.smsmode.task.exception.enumeration.InternalServerExceptionTitleEnum;
import com.smsmode.task.mapper.IncidentMapper;
import com.smsmode.task.model.CategoryModel;
import com.smsmode.task.model.ImageModel;
import com.smsmode.task.model.IncidentModel;
import com.smsmode.task.resource.incident.IncidentItemGetResource;
import com.smsmode.task.resource.incident.IncidentPostResource;
import com.smsmode.task.service.IncidentService;
import com.smsmode.task.service.StorageService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URI;
import java.util.HashSet;
import java.util.Set;

@Slf4j
@Service
@RequiredArgsConstructor
public class IncidentServiceImpl implements IncidentService {
    private final IncidentDaoService incidentDaoService;
    private final CategoryDaoService categoryDaoService;
    private final ImageDaoService imageDaoService;
    private final StorageService storageService;
    private final IncidentMapper incidentMapper;

    @Override
    @Transactional
    public ResponseEntity<IncidentItemGetResource> create(IncidentPostResource incidentPostResource, MultipartFile[] incidentImages) {

        IncidentModel incidentModel = incidentMapper.postResourceToModel(incidentPostResource);

        // Load and attach categories
        Set<CategoryModel> categories = new HashSet<>();
        for (String categoryId : incidentPostResource.getCategoryIds()) {
            CategoryModel category = categoryDaoService.findOneBy(CategorySpecification.withIdEqual(categoryId));
            categories.add(category);
        }
        incidentModel.setCategories(categories);

        // Save incident first (must have ID before attaching images)
        incidentModel = incidentDaoService.save(incidentModel);

        // Process and save each image
        if (!ObjectUtils.isEmpty(incidentImages)) {
            for (MultipartFile image : incidentImages) {
                if (image != null && !image.isEmpty()) {
                    ImageModel imageModel = new ImageModel();
                    imageModel.setIncident(incidentModel);
                    imageModel.setFileName(image.getOriginalFilename());

                    // Save image model to generate ID
                    imageModel = imageDaoService.save(imageModel);

                    // Generate path and store file
                    String imagePath = storageService.generateIncidentImagePath(imageModel);
                    try {
                        String savedFileName = storageService.storeFile(imagePath, image.getInputStream());
                        if (ObjectUtils.isEmpty(savedFileName)) {
                            throw new InternalServerException(InternalServerExceptionTitleEnum.FILE_UPLOAD,
                                    "An unexpected error occurred while saving the incident image. Please try again later.");
                        }
                    } catch (IOException e) {
                        log.warn("An error occurred when storing incident image", e);
                        throw new InternalServerException(InternalServerExceptionTitleEnum.FILE_UPLOAD,
                                "An unexpected error occurred while saving the image. Please try again later.");
                    }
                }
            }
        }

        // Return response DTO
        IncidentItemGetResource response = incidentMapper.modelToItemGetResource(incidentModel);
        return ResponseEntity.created(URI.create("")).body(response);
    }
}
