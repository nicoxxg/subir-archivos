package com.example.demomultiplefileuploan.repository;

import com.example.demomultiplefileuploan.models.Archivo;
import com.example.demomultiplefileuploan.models.ClientFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ClientFileRepository extends JpaRepository<ClientFile,Long> {
}
