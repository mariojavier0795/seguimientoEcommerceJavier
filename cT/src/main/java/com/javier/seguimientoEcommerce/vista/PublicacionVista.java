package com.javier.seguimientoEcommerce.vista;

import com.javier.seguimientoEcommerce.controlador.PlataformaControlador;
import com.javier.seguimientoEcommerce.controlador.Producto_2Controlador;
import com.javier.seguimientoEcommerce.controlador.PublicacionControlador;
import com.javier.seguimientoEcommerce.controlador.impl.PlataformaControladorImpl;
import com.javier.seguimientoEcommerce.controlador.impl.Producto_2ControladorImpl;
import com.javier.seguimientoEcommerce.controlador.impl.PublicacionControladorImpl;
import com.javier.seguimientoEcommerce.modelo.entidades.Plataforma;
import com.javier.seguimientoEcommerce.modelo.entidades.Producto_2;
import com.javier.seguimientoEcommerce.modelo.entidades.Publicacion;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "publicacionVista")
@ViewScoped
public class PublicacionVista implements Serializable {

    public PlataformaControlador plataformaControlador;
    public Producto_2Controlador producto2Controlador;
    public PublicacionControlador publicacionControlador;
    private Publicacion publicacionBean = new Publicacion();
    private List<Publicacion> lstPublicacion;
    private List<SelectItem> lstProductos;
    private List<SelectItem> lstPlataformas;

    public Publicacion getPublicacionBean() {
        return publicacionBean;
    }

    public void setPublicacionBean(Publicacion publicacionBean) {
        this.publicacionBean = publicacionBean;
    }

    public List<Publicacion> getLstPublicacion() {
        return lstPublicacion;
    }

    public void setLstPublicacion(List<Publicacion> lstPublicacion) {
        this.lstPublicacion = lstPublicacion;
    }

    public List<SelectItem> getLstProductos() {
        return lstProductos;
    }

    public void setLstProductos(List<SelectItem> lstProductos) {
        this.lstProductos = lstProductos;
    }

    public List<SelectItem> getLstPlataformas() {
        return lstPlataformas;
    }

    public void setLstPlataformas(List<SelectItem> lstPlataformas) {
        this.lstPlataformas = lstPlataformas;
    }

    @PostConstruct
    public void init() {
        plataformaControlador = new PlataformaControladorImpl();
        producto2Controlador = new Producto_2ControladorImpl();
        publicacionControlador = new PublicacionControladorImpl();
        lstProductos = new ArrayList<SelectItem>();
        lstPlataformas = new ArrayList<SelectItem>();
        lstPublicacion = new ArrayList<Publicacion>();
        Plataforma plataforma = new Plataforma();
        Producto_2 producto2 = new Producto_2();
        publicacionBean.setFkPlataforma(plataforma);
        publicacionBean.setFkProducto_2(producto2);
        this.listarPublicaciones();
        this.listarProductos();
        this.listarPlataformas();
    }

    private void listarPublicaciones() {
        lstPublicacion.clear();
        lstPublicacion = publicacionControlador.listarPublicaciones();
    }

    private void listarPlataformas() {
        lstPlataformas.clear();
        List<Plataforma> lstPlataformaTemp = plataformaControlador.listarPlataformas();
        for(Plataforma plataforma: lstPlataformaTemp) {
            lstPlataformas.add(new SelectItem(plataforma.getIdPlataforma(), plataforma.getNombrePlataforma()));
        }
    }

    private void listarProductos() {
        lstProductos.clear();
        List<Producto_2> lstProductosTemp = producto2Controlador.listarProductos_2Dao();
        for(Producto_2 producto: lstProductosTemp) {
            lstProductos.add(new SelectItem(producto.getIdProducto(), producto.getDetalleProducto()));
        }
    }

    public void insertarPublicacion() {

        try {
            if (publicacionBean.getIdPublicacion() != 0) {
                publicacionControlador.actualizarPublicacion(publicacionBean);
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Publicación Actualizada Correctamente"));
                limpiarCamposIngresos();
                this.listarPublicaciones();
                this.listarPlataformas();
                this.listarProductos();
                return;
            }
            publicacionControlador.insertarPublicacion(publicacionBean);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Publicación Registrada Correctamente"));
            limpiarCamposIngresos();
            this.listarPublicaciones();
            this.listarPlataformas();
            this.listarProductos();


        } catch (Exception e){

            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Cliente No Registrado"));

        }
    }

    public void cancelarIngresoPublicacion() {
        limpiarCamposIngresos();
    }

    public void editarPublicacion(Integer idPublicacion) {
        publicacionBean = publicacionControlador.buscarPublicacionById(idPublicacion);
    }

    public void eliminarPublicacion(Integer idPublicacion){
        try {
            Publicacion publicacion = new Publicacion();
            publicacion.setIdPublicacion(idPublicacion);
            publicacionControlador.eliminarPublicacion(publicacion);
            this.listarPublicaciones();
            this.listarPlataformas();
            this.listarProductos();
        }catch (Exception e){

            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Publicación No Eliminada"));

        }

    }

    private void limpiarCamposIngresos() {
        publicacionBean.setIdPublicacion(0);
        publicacionBean.setFechaPublicacion(null);
        publicacionBean.setFechaVencimientoPublicacion(null);
        publicacionBean.setCantidadPublicacion(null);
        publicacionBean.setVendedorPublicacion(null);
        publicacionBean.getFkPlataforma().setIdPlataforma(0);
        publicacionBean.getFkProducto_2().setIdProducto(0);
    }
}
