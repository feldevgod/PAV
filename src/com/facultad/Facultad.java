package com.facultad;

import javax.persistence.*;
import java.util.List;

public class Facultad {

    private Long id;
    private String nombre;
    //@ManyToOne
    private Ciudad ciudad;
    //@OneToMany(mappedBy = "facultad")
    private List<Carrera> carreras;

    public void setId(Long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    public List<Carrera> getCarreras() {
        return carreras;
    }

    public void setCarreras(List<Carrera> carreras) {
        this.carreras = carreras;
    }

    // Constructores
    public Facultad() {
    }

    public Facultad(String nombre, Ciudad ciudad) {
        this.nombre = nombre;
        this.ciudad = ciudad;
    }

    public Long getid(){
        return id;
    }
    
    public void setid(Long id){
        this.id = id;
    }
    
    public String getnombre(){
        return nombre;
    }
    
    public void setid(String nombre){
        this.nombre = nombre;
    }
    
    @Override
    public String toString() {
        return "Facultad{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", ciudad=" + ciudad +
                ", carreras=" + carreras +
                '}';
    }
}
