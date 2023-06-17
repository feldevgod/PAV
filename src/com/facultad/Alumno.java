package com.facultad;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;

public class Alumno extends Persona {
    private Long id;
    private String numeroLegajo;
    private int anioIngreso;
    private List<Materia> materias = new ArrayList<Materia>();

    // Constructores
    public Alumno() {
    }

    public Alumno(String apellido, String nombre, int dni, Date fechaNacimiento, Ciudad ciudad, String numeroLegajo, int anioIngreso) {
        super(apellido, nombre, dni, fechaNacimiento, ciudad);
        this.numeroLegajo = numeroLegajo;
        this.anioIngreso = anioIngreso;
    }

    public List<Materia> getMaterias() {
        return materias;
    }

    public void setMaterias(List<Materia> materias) {
        this.materias = materias;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroLegajo() {
        return numeroLegajo;
    }

    public void setNumeroLegajo(String numeroLegajo) {
        this.numeroLegajo = numeroLegajo;
    }

    public int getAnioIngreso() {
        return anioIngreso;
    }

    public void setAnioIngreso(int anioIngreso) {
        this.anioIngreso = anioIngreso;
    }

    public String getnumeroLegajo(){
        return numeroLegajo;
    }
    
    public void setnumeroLegajo(String numeroLegajo){
        this.numeroLegajo = numeroLegajo;
    }
    
    public int getanioIngreso(){
        return anioIngreso;
    }
    
    public void setanioIngreso(int anioIngreso){
        this.anioIngreso = anioIngreso;
    }
    
    @Override
    public String toString() {
        return "Alumno{" +
                "numeroLegajo='" + numeroLegajo + '\'' +
                ", anioIngreso=" + anioIngreso +
                "} " + super.toString();
    }
}
