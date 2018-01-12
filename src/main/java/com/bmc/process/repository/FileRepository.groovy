package com.bmc.process.repository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.bmc.process.model.Dto;
import com.bmc.process.model.MethodRepository;
import com.google.gson.Gson;

class FileRepository implements Repository {
    Gson gson = new Gson();

    @Override
    public List<MethodRepository> read(String pathToLogFile) throws IOException{
        List<MethodRepository> methods = new ArrayList<>();
        List<String> lines;
        lines = Files.readAllLines(Paths.get(pathToLogFile));
        for (int i = 9; i < lines.size(); i++) {
            String line = lines.get(i);
            if(!line.isEmpty()) {
                methods.add(gson.fromJson(lines.get(i), MethodRepository.class));
            }
        }
        return methods;
    }

    @Override
    public void write(Dto dto, String pathToJsonFile) throws IOException {
        Files.write(Paths.get(pathToJsonFile), gson.toJson(dto).getBytes());
    }
}
