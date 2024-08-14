package com.example.practica_activity_listview;

import java.io.Serializable;

public class Estudiante implements Serializable {
   private String nombre,apellido,edad,sexo,carrera;

    public Estudiante(String nombre, String apellido, String edad, String sexo, String carrera) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.sexo = sexo;
        this.carrera = carrera;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getEdad() {
        return edad;
    }

    public String getSexo() {
        return sexo;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String toString(){
        return ("Nombre:"+nombre+"\nApellido:"+apellido+"\nEdad:"+edad+"\nSexo:"+sexo+"\nCarrera:"+carrera);
    }
}
