package com.lspeixotodev.debitcharges.controllers;

import com.lspeixotodev.debitcharges.services.DocumentService;
import com.lspeixotodev.debitcharges.services.ProcessedFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping(value = "/api/v1/document")
public class DocumentController {

    @Autowired
    public DocumentService documentService;

    @Autowired
    public ProcessedFileService processedFileService;

    @PostMapping("/input-csv")
    public ResponseEntity<String> processDebitsFromCsvFile(@RequestParam MultipartFile file) throws Exception {
        CompletableFuture<List<String[]>> records = documentService.processDebitsFromFile3(file);

        List<String[]> accessibleRecords = records.get();

        processedFileService.createNewProcessedFileRegister(file, accessibleRecords);

        return ResponseEntity.ok("File processed successfully");

    }
}
