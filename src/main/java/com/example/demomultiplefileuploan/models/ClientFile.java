package com.example.demomultiplefileuploan.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;


@Entity
public class ClientFile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native",strategy = "native")
    private long id;
    private String nombre;

    @OneToMany(mappedBy = "client",fetch = FetchType.EAGER)
    private Set<Archivo> archivo;

    public ClientFile() {
    }

    public ClientFile(String nombre) {
        this.nombre = nombre;
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

    public Set<Archivo> getArchivo() {
        return archivo;
    }

    public void setArchivo(Set<Archivo> archivo) {
        this.archivo = archivo;
    }
}
