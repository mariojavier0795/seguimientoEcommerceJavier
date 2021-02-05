package com.javier.seguimientoEcommerce.modelo.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Plataforma implements Serializable {

    public Plataforma() {}

    public Plataforma(String nombrePlataforma, String observacionPlataforma) {
        this.nombrePlataforma = nombrePlataforma;
        this.observacionPlataforma = observacionPlataforma;
    }

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPlataforma;

    @Column(name = "nombre_plataforma", length = 200)
    private String nombrePlataforma;

    @Column(name = "observacion_plataforma", length = 200)
    private String observacionPlataforma;

    // RELACION plataforma con publicacion
    @OneToMany (mappedBy ="fkPlataforma", cascade =CascadeType.REFRESH)
    private List<Publicacion> lstPublicaciones = new ArrayList<Publicacion>();

    public int getIdPlataforma() {
        return idPlataforma;
    }

    public void setIdPlataforma(int idPlataforma) {
        this.idPlataforma = idPlataforma;
    }

    public String getNombrePlataforma() {
        return nombrePlataforma;
    }

    public void setNombrePlataforma(String nombrePlataforma) {
        this.nombrePlataforma = nombrePlataforma;
    }

    public String getObservacionPlataforma() {
        return observacionPlataforma;
    }

    public void setObservacionPlataforma(String observacionPlataforma) {
        this.observacionPlataforma = observacionPlataforma;
    }

    public List<Publicacion> getLstPublicaciones() {
        return lstPublicaciones;
    }

    public void setLstPublicaciones(List<Publicacion> lstPublicaciones) {
        this.lstPublicaciones = lstPublicaciones;
    }

    @Override
    public String toString() {
        return "Plataforma{" +
                "idPlataforma=" + idPlataforma +
                ", nombrePlataforma='" + nombrePlataforma + '\'' +
                ", observacionPlataforma='" + observacionPlataforma + '\'' +
                '}';
    }
}

