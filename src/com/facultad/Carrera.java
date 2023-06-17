package com.facultad;

import java.util.ArrayList;
import javax.persistence.*;
import java.util.List;

public class Carrera {

    private Long id;
    private String nombre;

    //@ManyToOne
    private Facultad facultad;

    //@OneToMany(mappedBy = "carrera")
    private List<Materia> materias = new ArrayList<>();

    public Carrera() {
    }

    public Carrera(String nombre, Facultad facultad) {
        this.nombre = nombre;
        this.facultad = facultad;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Facultad getFacultad() {
        return facultad;
    }

    public void setFacultad(Facultad facultad) {
        this.facultad = facultad;
    }

    public List<Materia> getMaterias() {
        return materias;
    }

    public void setMaterias(List<Materia> materias) {
        this.materias = materias;
    }
    

    
    @Override
    public String toString() {
        return "Carrera{" + "id=" + id + ", nombre='" + nombre + '\'' + ", facultad=" + facultad + ", materias=" + materias + '}';
    }
}
