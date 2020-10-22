package com.isoftstone.lsfile.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.MultipartConfigElement;
import java.io.File;

@Configuration
public class TomcatFileConfig {

    @Value("${temporary-file}")
    String temporaryFile;

    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigElement element = null;
        System.out.println(element);

        File tmp = new File(temporaryFile);
        if (!tmp.exists()) {
            tmp.mkdirs();
        }
        MultipartConfigFactory factory = new MultipartConfigFactory();
        factory.setLocation(temporaryFile);
        return factory.createMultipartConfig();
    }
}
