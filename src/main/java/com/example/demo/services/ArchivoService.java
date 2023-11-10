package com.example.demo.services;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.example.demo.models.ArchivoModel;
import com.example.demo.repositories.ArchivoRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ArchivoService {
    private final ArchivoRepository archivoRepository;
    private final Cloudinary cloudinary;

    public List<ArchivoModel> getAllArchivos() {
        return archivoRepository.findAll();
    }

    public ArchivoModel saveArchivo(MultipartFile file) throws IOException {
        @SuppressWarnings("unchecked")
        Map<String, Object> uploadResult = cloudinary.uploader().upload(file.getBytes(),
                ObjectUtils.asMap("folder", "Test", "resource_type", "auto"));
        String publicId = uploadResult.get("public_id").toString();
        String url = uploadResult.get("url").toString();
        ArchivoModel archivo = new ArchivoModel();
        archivo.setId(publicId);
        archivo.setUrl(url);
        return archivoRepository.save(archivo);
    }

    public void deleteArchivo(List<String> idList) throws Exception {
        cloudinary.api().deleteResources(idList, ObjectUtils.asMap("folder", "Test", "resource_type", "auto"));
        archivoRepository.deleteAllById(idList);
    }
}
