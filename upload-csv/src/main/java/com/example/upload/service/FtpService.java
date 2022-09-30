package com.example.upload.service;

import com.example.upload.model.FTPServerProperty;
import lombok.RequiredArgsConstructor;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class FtpService {

    private final FTPServerProperty ftpServerProperty;

    public void uploadToFtpServer(MultipartFile file) {

        FTPClient con = null;

        try {
            con = new FTPClient();
            con.connect(ftpServerProperty.getServer().getUri(), ftpServerProperty.getServer().getPort());

            if (con.login(ftpServerProperty.getServer().getUsername(), ftpServerProperty.getServer().getPassword())) {
                con.enterLocalPassiveMode(); // important!
                con.setFileType(FTP.BINARY_FILE_TYPE);

                boolean result = con.storeFile(file.getOriginalFilename(), file.getInputStream());
                con.logout();
                con.disconnect();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
