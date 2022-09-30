package com.example.upload.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("ftp")
public class FTPServerProperty {

    @Getter
    @Setter
    private  Server server;


    @Getter
    @Setter
    public static class Server{

        private String uri;

        private int port;

        private String username;

        private String password;

    }
}
