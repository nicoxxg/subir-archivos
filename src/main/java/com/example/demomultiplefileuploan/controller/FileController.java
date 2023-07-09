package com.example.demomultiplefileuploan.controller;

import com.example.demomultiplefileuploan.models.Archivo;
import com.example.demomultiplefileuploan.models.ClientFile;
import com.example.demomultiplefileuploan.repository.ArchivoRepository;
import com.example.demomultiplefileuploan.repository.ClientFileRepository;
import com.example.demomultiplefileuploan.services.FileServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/api")
public class FileController {
    @Autowired
    ClientFileRepository clientFileRepository;
    @Autowired
    ArchivoRepository archivoRepository;

    @Autowired
    private FileServiceApi fileServiceApi;
    @PostMapping("/client/{idClient}/files/upload")
    public ResponseEntity<Object> uploadFiles(@PathVariable long idClient, @RequestParam List<MultipartFile> files){
        try {
            ClientFile cliente = clientFileRepository.findById(idClient)
                    .orElseThrow(() -> new IllegalArgumentException("Cliente no encontrado"));

            for (MultipartFile file : files){
                Archivo archivoEntity = new Archivo();
                archivoEntity.setNombre(file.getOriginalFilename());
                archivoEntity.setContenido(file.getBytes());
                archivoEntity.setClient(cliente);
                clientFileRepository.save(cliente);
                archivoRepository.save(archivoEntity);
            }

            //fileServiceApi.save(files);
            return ResponseEntity.status(HttpStatus.OK).body("los archivos fueron cargados correctamente");
        }catch (Exception e ){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("ocurrio un error al subir un archivo");
        }
    }
    @GetMapping("/archivos/{archivoId}")
    public ResponseEntity<byte[]> descargarArchivo(@PathVariable Long archivoId) {
        Archivo archivo = archivoRepository.findById(archivoId)
                .orElseThrow(() -> new IllegalArgumentException(
                        "Archivo no encontrado"));

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDisposition(ContentDisposition.attachment().filename(archivo.getNombre()).build());

        return new ResponseEntity<>(archivo.getContenido(), headers, HttpStatus.OK);
    }
}
