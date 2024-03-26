package com.lspeixotodev.debitcharges.services;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class DocumentService {

    /**
     * Este método processa um arquivo CSV carregado pelo usuário e retorna uma lista de registros.
     * O método usa a classe BufferedReader para ler o arquivo linha por linha e o método split para analisar cada linha em campos.
     * Se houver um erro ao ler o arquivo, uma exceção será lançada.
     *
     * @param file o arquivo CSV enviado
     * @return uma lista de registros analisados do arquivo
     */
    @Async
    public CompletableFuture<List<String[]>> processDebitsFromFile3(MultipartFile file) {
        List<String[]> records = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                records.add(fields);
            }
        } catch (IOException e) {
            throw new RuntimeException("Ocorreu algum problema ao processar o arquivo CSV: " + e.getMessage());
        }

        return CompletableFuture.completedFuture(records);
    }

}
