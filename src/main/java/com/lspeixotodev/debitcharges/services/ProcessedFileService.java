package com.lspeixotodev.debitcharges.services;

import com.lspeixotodev.debitcharges.entities.ProcessedFile;
import com.lspeixotodev.debitcharges.repositories.ProcessedFileRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class ProcessedFileService {
    @Autowired
    public ProcessedFileRepository processedFileRepository;

    public void createNewProcessedFileRegister(MultipartFile file, List<String[]> accessibleRecords) {
        ProcessedFile newProcessedFile = createProcessedFile(file, accessibleRecords);

        processedFileRepository.save(newProcessedFile);

    }

    private static ProcessedFile createProcessedFile(MultipartFile file, List<String[]> accessibleRecords) {
        ProcessedFile newProcessedFile = new ProcessedFile();

        newProcessedFile.setFileName(file.getOriginalFilename());
        newProcessedFile.setFileSize(file.getSize());
        newProcessedFile.setProcessedDebits(accessibleRecords.size());

        return newProcessedFile;
    }

    public List<ProcessedFile> findAllProcessedFiles() {
        return processedFileRepository.findAll();
    }
}
