/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.GuiaAlterElect.model;

public class Monitor {
      private int codigo;
    private String nombre,apellido,email,dir;
    private int dni,telf;

    @Override
    public String toString() {
        return "Monitor{" + "codigo=" + codigo + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.codigo;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Monitor other = (Monitor) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        return true;
    }
    

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public int getTelf() {
        return telf;
    }

    public void setTelf(int telf) {
        this.telf = telf;
    }
    


    
}
