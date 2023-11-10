package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.ArchivoModel;

@Repository
public interface ArchivoRepository extends JpaRepository<ArchivoModel, String> {

}
