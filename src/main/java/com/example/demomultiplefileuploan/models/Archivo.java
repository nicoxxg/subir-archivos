package com.example.demomultiplefileuploan.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class Archivo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native",strategy = "native")
    private long id;
    private String nombre;
    @Lob
    private byte[] contenido;

    @ManyToOne(fetch = FetchType.EAGER)
    private ClientFile client;

    public Archivo() {
    }

    public Archivo(String nombre, byte[] contenido, ClientFile client) {
        this.nombre = nombre;
        this.contenido = contenido;
        this.client = client;
    }

    public ClientFile getClient() {
        return client;
    }

    public void setClient(ClientFile client) {
        this.client = client;
    }

    public long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public byte[] getContenido() {
        return contenido;
    }

    public void setContenido(byte[] contenido) {
        this.contenido = contenido;
    }
}
