package com.lspeixotodev.debitcharges.repositories;

import com.lspeixotodev.debitcharges.entities.ProcessedFile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProcessedFileRepository extends JpaRepository<ProcessedFile, Long> {

}
