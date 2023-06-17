package com.facultad;

import java.util.ArrayList;
import java.util.HashSet;
import javax.persistence.*;
import java.util.List;
import java.util.Set;

public class Materia {

    private Long id;
    private String nombre;
    private String nivel;
    
    private Profesor profesor;

    //@OneToMany(mappedBy = "materia")
    private Set<Alumno> alumnos = new HashSet<Alumno>();

    public Materia() {
    }

    public Materia(Long id, String nombre, String nivel, Profesor profesor, Set<Alumno> alumnos) {
        this.id = id;
        this.nombre = nombre;
        this.nivel = nivel;
        this.profesor = profesor;
        this.alumnos = alumnos;
    }

    public Set<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(Set<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
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

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }
    


    @Override
    public String toString() {
        return "Materia{" + "id=" + id + ", nombre='" + nombre + '\'' + ", nivel='" + nivel + '\'' + ", profesor=" + profesor + ", alumnos=" + alumnos + '}';
    }
}
