package com.lspeixotodev.debitcharges.controllers;

import com.lspeixotodev.debitcharges.entities.ProcessedFile;
import com.lspeixotodev.debitcharges.services.ProcessedFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/files")
public class ProcessedFileController {
    @Autowired
    public ProcessedFileService processedFileService;

    @GetMapping()
    public ResponseEntity<List<ProcessedFile>> findAllProcessedFiles() {
        return ResponseEntity.ok(processedFileService.findAllProcessedFiles());
    }
}
