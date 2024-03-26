package com.lspeixotodev.debitcharges.utils;

import com.lspeixotodev.debitcharges.entities.Document;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.multipart.MultipartFile;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CSVHelper {
    public static String TYPE = "text/csv";
    static String[] Headers = {"name", "governmentId", "email", "debtAmount", "debtDueDate", "debtId"};

    public static boolean hasCSVFormat(MultipartFile file) {

        return TYPE.equals(file.getContentType());
    }

    public static List<Document> csvToDocuments(InputStream is) {
        try (
                BufferedReader fileReader = new BufferedReader(
                        new InputStreamReader(is, StandardCharsets.UTF_8)
                );

                CSVParser csvParser = new CSVParser(
                        fileReader,
                        CSVFormat.DEFAULT.withFirstRecordAsHeader()
                                .withIgnoreHeaderCase()
                                .withTrim());
        ) {

            List<Document> documents = new ArrayList<>();

            Iterable<CSVRecord> csvRecords = csvParser.getRecords();

            for (CSVRecord csvRecord : csvRecords) {

                if(documents.size() > 100) {
                    break;
                }

                Document document = new Document(
                        UUID.fromString(csvRecord.get("debtId")),
                        csvRecord.get("name"),
                        Integer.parseInt(csvRecord.get("governmentId")),
                        csvRecord.get("email"),
                        Long.parseLong(csvRecord.get("debtAmount")),
                        Date.valueOf(csvRecord.get("debtDueDate"))
                );

                documents.add(document);

            }

            return documents;

        } catch (IOException e) {
            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        }
    }
}
