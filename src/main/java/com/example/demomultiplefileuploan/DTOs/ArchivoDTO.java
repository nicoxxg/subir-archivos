package com.example.demomultiplefileuploan.DTOs;

import com.example.demomultiplefileuploan.models.Archivo;

public class ArchivoDTO {
    private String nombreArchivo;

    private byte[] contenido;

    public ArchivoDTO(Archivo archivo) {
        this.nombreArchivo = archivo.getNombre();
        this.contenido = archivo.getContenido();
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public byte[] getContenido() {
        return contenido;
    }
}
