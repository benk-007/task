package com.smsmode.task.dao.service.Impl;

import com.smsmode.task.dao.repository.ImageRepository;
import com.smsmode.task.dao.service.ImageDaoService;
import com.smsmode.task.model.ImageModel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ImageDaoServiceImpl implements ImageDaoService {
    private final ImageRepository imageRepository;

    @Override
    public ImageModel save(ImageModel imageModel) {
        return imageRepository.save(imageModel);
    }
}
