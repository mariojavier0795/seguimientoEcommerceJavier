package com.javier.seguimientoEcommerce.vista;

import com.javier.seguimientoEcommerce.controlador.PedidoControlador;
import com.javier.seguimientoEcommerce.controlador.impl.PedidoControladorImpl;
import com.javier.seguimientoEcommerce.modelo.entidades.Pedido;
import com.javier.seguimientoEcommerce.controlador.DespachoControlador;
import com.javier.seguimientoEcommerce.controlador.impl.DespachoControladorImpl;
import com.javier.seguimientoEcommerce.modelo.entidades.Despacho;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "despachoVista")
@ViewScoped
public class DespachoVista implements Serializable {

    public PedidoControlador pedidoControlador;
    public DespachoControlador despachoControlador;
    private Despacho despachoBean = new Despacho();
    private List<SelectItem> lstPedido;
    private List<Despacho> lstDespacho;

    public Despacho getDespachoBean() {
        return despachoBean;
    }

    public void setDespachoBean(Despacho despachoBean) {
        this.despachoBean = despachoBean;
    }

    public List<SelectItem> getLstPedido() {
        return lstPedido;
    }

    public void setLstPedido(List<SelectItem> lstPedido) {
        this.lstPedido = lstPedido;
    }

    public List<Despacho> getLstDespacho() {
        return lstDespacho;
    }

    public void setLstDespacho(List<Despacho> lstDespacho) {
        this.lstDespacho = lstDespacho;
    }

    @PostConstruct
    public void init() {
        pedidoControlador = new PedidoControladorImpl();
        despachoControlador = new DespachoControladorImpl();
        lstPedido = new ArrayList<SelectItem>();
        lstDespacho = new ArrayList<Despacho>();
        Pedido pedido = new Pedido();
        despachoBean.setFkPedidoDespacho(pedido);
        this.listarPedidos();
        this.listarDespachos();
    }

    public void insertarDespacho() {

        try {
            if (despachoBean.getIdDespacho() != 0) {
                despachoControlador.actualizarDespacho(despachoBean);
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Despacho Actualizado Correctamente"));
                limpiarCamposIngresos();
                this.listarPedidos();
                this.listarDespachos();
                return;
            }
            despachoControlador.insertarDespacho(despachoBean);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Despacho Registrado Correctamente"));
            limpiarCamposIngresos();
            this.listarPedidos();
            this.listarDespachos();


        } catch (Exception e){

            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Despacho No Registrado"));

        }

    }

    public void cancelarIngresoDespacho() {
        limpiarCamposIngresos();
    }

    public void editarDespacho(Integer idDespacho) {
        despachoBean = despachoControlador.buscarDespachoById(idDespacho);
    }

    public void eliminarDespacho(Integer idDespacho){
        try {
            Despacho despacho = new Despacho();
            despacho.setIdDespacho(idDespacho);
            despachoControlador.eliminarDespacho(despacho);
            this.listarPedidos();
        }catch (Exception e){

            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Pedido No Eliminado"));

        }

    }

    private void listarDespachos() {
        lstDespacho.clear();
        lstDespacho = despachoControlador.listarDespachos();
    }

    private void listarPedidos() {
        lstPedido.clear();
        List<Pedido> lstPedidoTemp = pedidoControlador.listarPedidos();
        for(Pedido pedido: lstPedidoTemp) {
            lstPedido.add(new SelectItem(pedido.getIdPedido(), pedido.getNumeroFacturaPedido()));
        }
    }

    private void limpiarCamposIngresos() {
        despachoBean.setFechaDespacho(null);
        despachoBean.setFormaTransporteDespacho("");
        despachoBean.setFechaRecepcionDespacho(null);
        despachoBean.setNombreRecibeDespacho("");
        despachoBean.setTelefonoRecibeDespacho("");
        despachoBean.setConcretadoDespacho("");
        despachoBean.setCostoDespacho("");
        despachoBean.setObservacionesDespacho("");
        despachoBean.setFormaPagoDespacho("");
        despachoBean.getFkPedidoDespacho().setIdPedido(0);
        despachoBean.setIdDespacho(0);
    }
}
