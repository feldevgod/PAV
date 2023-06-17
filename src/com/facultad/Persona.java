package com.facultad;

import javax.persistence.*;
import java.util.Date;

public class Persona {

    private Long id;
    private String apellido;
    private String nombre;
    private int dni;
    private Date fechaNacimiento;   
    private Ciudad ciudad;

    public Persona() {
    }

    public Persona(String apellido, String nombre, int dni, Date fechaNacimiento, Ciudad ciudad) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.dni = dni;
        this.fechaNacimiento = fechaNacimiento;
        this.ciudad = ciudad;
    }

     public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    public Ciudad getCiudad() {
        return ciudad;
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    public void setDni(int dni){
        this.dni = dni;
    }
    
    public int getDni(){
        return dni;
    }
    
    @Override
    public String toString() {
        return "Persona{" + "id=" + id + ", apellido='" + apellido + '\'' + ", nombre='" + nombre + '\'' + ", dni=" + dni + ", fechaNacimiento=" + fechaNacimiento + ", ciudad=" + ciudad + '}';
    }
}