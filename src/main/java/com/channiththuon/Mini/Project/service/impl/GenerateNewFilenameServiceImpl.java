package com.channiththuon.Mini.Project.service.impl;

import com.channiththuon.Mini.Project.service.GenerateNewFilenameService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class GenerateNewFilenameServiceImpl implements GenerateNewFilenameService {
    @Override
    public String generateNewFilename(String originalFilename) {
        LocalDateTime now = LocalDateTime.now();
        String timestamp = now.format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        int lastIndexOfDot = originalFilename.lastIndexOf(".");
        if (lastIndexOfDot == -1) {
            return timestamp ;
        }

        String extension = originalFilename.substring(lastIndexOfDot);
        return timestamp + extension;
    }
}
