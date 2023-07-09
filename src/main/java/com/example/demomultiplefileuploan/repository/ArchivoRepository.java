package com.example.demomultiplefileuploan.repository;

import com.example.demomultiplefileuploan.models.Archivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ArchivoRepository extends JpaRepository<Archivo,Long> {
}
