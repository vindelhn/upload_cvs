package com.example.upload.service;

import com.example.upload.model.Empleado;
import com.example.upload.helper.CSVHelper;
import com.example.upload.repository.EmpleadoRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class CSVService {
    final EmpleadoRepository repository;

    public CSVService(EmpleadoRepository repository) {
        this.repository = repository;
    }

    public void save(MultipartFile file) {
        int i=0;
        try {
            int batchSize = 1000;
            List<Empleado> tutorials = CSVHelper.csvToTutorials(file.getInputStream());
            int totalElementos = tutorials.size();
            for(i=0;i<totalElementos;i+=batchSize){
                if(i+batchSize>totalElementos){
                    List<Empleado> subiendo = tutorials.subList(i,totalElementos);
                    repository.saveAll(subiendo);
                    System.out.println("Saved "+i+" "+(i+batchSize));
                    break;
                }
                List<Empleado> subiendo = tutorials.subList(i,i+batchSize);
                repository.saveAll(subiendo);
                System.out.println("Saved "+i+" "+(i+batchSize));
            }

        } catch (IOException e) {
            System.out.println(i);

            throw new RuntimeException("fail to store csv data: " + e.getMessage());
        }
    }


}
