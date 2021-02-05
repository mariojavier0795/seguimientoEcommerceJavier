package com.javier.seguimientoEcommerce.vista;

import com.javier.seguimientoEcommerce.controlador.Producto_2Controlador;
import com.javier.seguimientoEcommerce.controlador.impl.Producto_2ControladorImpl;
import com.javier.seguimientoEcommerce.modelo.entidades.Producto_2;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "productoVista")
@ViewScoped
public class ProductoVista  implements Serializable{

    public Producto_2Controlador producto2Controlador;
    private Producto_2 producto2Bean = new Producto_2();
    private List<Producto_2> lstProductos;

    public Producto_2 getProducto2Bean() {
        return producto2Bean;
    }

    public void setProducto2Bean(Producto_2 producto2Bean) {
        this.producto2Bean = producto2Bean;
    }

    public List<Producto_2> getLstProductos() {
        return lstProductos;
    }

    public void setLstProductos(List<Producto_2> lstProductos) {
        this.lstProductos = lstProductos;
    }

    @PostConstruct
    public void init() {

        producto2Controlador = new Producto_2ControladorImpl();
        lstProductos= new ArrayList<Producto_2>();
        this.listarProductos();
    }

    public void insertarProducto() {

        try {
            if (producto2Bean.getIdProducto() != 0) {
                producto2Controlador.actualizarProducto_2(producto2Bean);
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Producto Actualizado Correctamente"));
                limpiarCamposIngresos();
                this.listarProductos();
                return;
            }
            producto2Controlador.insertarProducto_2(producto2Bean);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Producto Registrado Correctamente"));
            limpiarCamposIngresos();
            this.listarProductos();


        } catch (Exception e){

            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Producto No Registrado"));

        }

    }

    public void cancelarIngresoProducto() {
        limpiarCamposIngresos();
    }

    public void editarProducto(Integer idProducto) {
        producto2Bean = producto2Controlador.buscarProductoById(idProducto);
    }

    public void eliminarProducto(Integer idProducto){
        try {
            Producto_2 producto2 = new Producto_2();
            producto2.setIdProducto(idProducto);
            producto2Controlador.eliminarProducto_2Dao(producto2);
            this.listarProductos();
        }catch (Exception e){

            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Plataforma No Eliminada"));

        }

    }

    private void listarProductos(){
        lstProductos = producto2Controlador.listarProductos_2Dao();
    }

    public void limpiarCamposIngresos(){
        producto2Bean.setCaducidadProducto("");
        producto2Bean.setCostoProducto("");
        producto2Bean.setPvpProducto("");
        producto2Bean.setDetalleProducto("");
        producto2Bean.setStockProducto("");
        producto2Bean.setIdProducto(0);
    }

}
