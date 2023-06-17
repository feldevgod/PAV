package com.facultad;

import java.io.Serializable;
import java.util.Date;

public class Profesor extends Persona implements Serializable {
    private Long id;
    private int antiguedad;

    public Profesor() {
        super();
    }

    public Profesor(String apellido, String nombre, int dni, Date fechaNacimiento, Ciudad ciudad, int antiguedad) {
        super(apellido, nombre, dni, fechaNacimiento, ciudad);
        this.antiguedad = antiguedad;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getantiguedad(){
        return antiguedad;
    }
    
    public void setid(int antiguedad){
        this.antiguedad = antiguedad;
    }

    @Override
    public String toString() {
        return "Profesor{" + "antiguedad=" + antiguedad +  "}";
    }
                
    public int getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }
}