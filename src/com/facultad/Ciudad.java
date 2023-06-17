package com.facultad;

import javax.persistence.*;

public class Ciudad {

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    private String nombre;

    public Ciudad() {
    }

    public Ciudad(String nombre) {
        this.nombre = nombre;
    }
    
    public Long getid(){
        return id;
    }
    
    public void setid(Long id){
        this.id = id;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    @Override
    public String toString() {
        return "Ciudad{" + "id=" + id + ", nombre='" + nombre + '\'' + '}';
    }
}
