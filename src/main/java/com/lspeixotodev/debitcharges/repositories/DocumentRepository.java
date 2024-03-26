package com.lspeixotodev.debitcharges.repositories;

import com.lspeixotodev.debitcharges.entities.Document;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DocumentRepository extends JpaRepository<Document, UUID> {
}
