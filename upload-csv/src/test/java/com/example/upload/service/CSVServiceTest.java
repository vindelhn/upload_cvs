package com.example.upload.service;

import com.example.upload.repository.EmpleadoRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class CSVServiceTest {


//    @Autowired
//    private EmpleadoRepository empleadoRepository;

//    private CSVService csvService;

    @BeforeEach
    void setUp() {
//        csvService = new CSVService(empleadoRepository);
   }

    @AfterEach
    void tearDown() {
//        empleadoRepository.deleteAll();
   }

    @Test
    void save() {


//        try {
//            MultipartFile multipartFile = new MockMultipartFile("ejemplo2.csv", new FileInputStream(new File("ejemplo2.csv")));
//
//            csvService.save(multipartFile);
//
//            System.out.println( "ARCHIVO GENERADO: "+ multipartFile.getOriginalFilename());
//        } catch (Exception e) {
//            System.out.println( e.getMessage() );
//        }





    }
}
