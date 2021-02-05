package com.javier.seguimientoEcommerce.vista;

import com.javier.seguimientoEcommerce.controlador.PublicacionControlador;
import com.javier.seguimientoEcommerce.controlador.impl.PublicacionControladorImpl;
import com.javier.seguimientoEcommerce.controlador.PlataformaControlador;
import com.javier.seguimientoEcommerce.controlador.impl.PlataformaControladorImpl;
import com.javier.seguimientoEcommerce.modelo.entidades.Plataforma;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "plataformaVista")
@ViewScoped
public class PlataformaVista implements Serializable {

    public PlataformaControlador plataformaControlador;
    public PublicacionControlador publicacionControlador;
    private Plataforma plataformaBean = new Plataforma();
    private List<Plataforma> lstPlataformas;

    @PostConstruct
    public void init() {
        plataformaControlador = new PlataformaControladorImpl();
        publicacionControlador = new PublicacionControladorImpl();
        lstPlataformas= new ArrayList<Plataforma>();
        listarPlataforma();
    }

    public Plataforma getPlataformaBean() {
        return plataformaBean;
    }

    public void setPlataformaBean(Plataforma plataformaBean) {
        this.plataformaBean = plataformaBean;
    }

    public List<Plataforma> getLstPlataformas() {
        return lstPlataformas;
    }

    public void setLstPlataformas(List<Plataforma> lstPlataformas) {
        this.lstPlataformas = lstPlataformas;
    }

    public void insertarPlataforma() {

        try {
            if (plataformaBean.getIdPlataforma() != 0) {
                plataformaControlador.actualizarPlataforma(plataformaBean);
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Plataforma Actualizada Correctamente"));
                limpiarCamposIngresos();
                listarPlataforma();
                return;
            }
            plataformaControlador.insertarPlataforma(this.getPlataformaBean());
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Plataforma Registrada Correctamente"));
            limpiarCamposIngresos();
            listarPlataforma();


        } catch (Exception e){

            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Plataforma No Registrada"));

        }

    }

    public void cancelarIngresoPlataforma() {
        limpiarCamposIngresos();
    }

    public void editarPlataforma(Integer idPlataforma) {
        plataformaBean = plataformaControlador.buscarPlataformaById(idPlataforma);
    }

    public void eliminarPlataforma(Integer idPlataforma){
        try {
            Plataforma plataforma = new Plataforma();
            plataforma.setIdPlataforma(idPlataforma);
            plataformaControlador.eliminarPlataforma(plataforma);
            listarPlataforma();
        }catch (Exception e){

            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Plataforma No Eliminada"));

        }
    }

    public void listarPlataforma(){
        lstPlataformas = plataformaControlador.listarPlataformas();
    }

    public void limpiarCamposIngresos(){
        plataformaBean.setIdPlataforma(0);
        plataformaBean.setNombrePlataforma("");
        plataformaBean.setObservacionPlataforma("");
    }
}
