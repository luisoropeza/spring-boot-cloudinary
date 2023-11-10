package com.example.demo.Configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

@Configuration
public class CloudinaryConfig {
    @Bean
    public Cloudinary cloudinary() {
        Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "dvqh29igh",
                "api_key", "426737489267867",
                "api_secret", "CThHc9uOSfdm78uAdBuTu-SzX-0",
                "secure", true));
        return cloudinary;
    }
}
