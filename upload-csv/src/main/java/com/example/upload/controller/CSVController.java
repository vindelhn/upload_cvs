package com.example.upload.controller;


import com.example.upload.helper.CSVHelper;
import com.example.upload.service.CSVService;

import com.example.upload.service.FtpService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.File;
import java.net.URI;

@CrossOrigin("http://localhost:8080")
@RestController
@RequestMapping("/api/csv")
@RequiredArgsConstructor
public class CSVController {

    final CSVService fileService;

    private final FtpService ftpService;


    @Operation(summary = "carga y sube archivo csv al ftp, tipo de datos (multipart/form-data)")
    @PostMapping("/upload")
    public ResponseEntity<Void> upload(@RequestParam("file") MultipartFile file) {
        String message = "";
        URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/upload").buildAndExpand(file.getOriginalFilename()).toUri();
         if (CSVHelper.hasCSVFormat(file)) {
            try {

                fileService.save(file);


                message = "Uploaded the file successfully: " + file.getOriginalFilename();


            } catch (Exception e) {
                System.out.println(e.getMessage()+"");
                message = "Could not upload the file: " + file.getOriginalFilename() + "!";
                return ResponseEntity.created(uri).build();
            }


        }


        ftpService.uploadToFtpServer(file);

        return ResponseEntity.created(uri).build();

    }





}
