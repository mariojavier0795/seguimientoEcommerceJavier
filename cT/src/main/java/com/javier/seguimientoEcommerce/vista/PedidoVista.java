package com.javier.seguimientoEcommerce.vista;


import com.javier.seguimientoEcommerce.controlador.ClienteControlador;
import com.javier.seguimientoEcommerce.controlador.PedidoControlador;
import com.javier.seguimientoEcommerce.controlador.PublicacionControlador;
import com.javier.seguimientoEcommerce.controlador.impl.ClienteControladorImpl;
import com.javier.seguimientoEcommerce.controlador.impl.PedidoControladorImpl;
import com.javier.seguimientoEcommerce.controlador.impl.PublicacionControladorImpl;
import com.javier.seguimientoEcommerce.modelo.entidades.Cliente;
import com.javier.seguimientoEcommerce.modelo.entidades.Pedido;
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

@ManagedBean(name = "pedidoVista")
@ViewScoped
public class PedidoVista implements Serializable {

    public PedidoControlador pedidoControlador;
    public ClienteControlador clienteControlador;
    public PublicacionControlador publicacionControlador;
    private Pedido pedidoBean = new Pedido();
    Cliente clienteBean = new Cliente();
    Publicacion publicacionBean = new Publicacion();
    private List<SelectItem> lstCliente;
    private List<SelectItem> lstPublicaciones;
    private List<Pedido> lstPedido;

    public Pedido getPedidoBean() {
        return pedidoBean;
    }

    public void setPedidoBean(Pedido pedidoBean) {
        this.pedidoBean = pedidoBean;
    }

    public List<Pedido> getLstPedido() {
        return lstPedido;
    }

    public void setLstPedido(List<Pedido> lstPedido) {
        this.lstPedido = lstPedido;
    }

    public List<SelectItem> getLstCliente() {
        return lstCliente;
    }

    public void setLstCliente(List<SelectItem> lstCliente) {
        this.lstCliente = lstCliente;
    }

    public List<SelectItem> getLstPublicaciones() {
        return lstPublicaciones;
    }

    public void setLstPublicaciones(List<SelectItem> lstPublicaciones) {
        this.lstPublicaciones = lstPublicaciones;
    }

    @PostConstruct
    public void init() {
        pedidoControlador = new PedidoControladorImpl();
        clienteControlador = new ClienteControladorImpl();
        publicacionControlador = new PublicacionControladorImpl();
        lstPedido= new ArrayList<Pedido>();
        lstCliente = new ArrayList<SelectItem>();
        lstPublicaciones = new ArrayList<SelectItem>();
        pedidoBean.setFkCliente(clienteBean);
        pedidoBean.setFkPublicacion(publicacionBean);
        this.listarPedidos();
        this.listarClientes();
        this.listarPublicaciones();
    }

    public void insertarPedido() {

        try {
            if (pedidoBean.getIdPedido() != 0) {
                pedidoControlador.actualizarPedido(this.getPedidoBean());
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Pedido Actualizado Correctamente"));
                limpiarCamposIngresos();
                this.listarPedidos();
                this.listarClientes();
                this.listarPublicaciones();
                return;
            }
            pedidoControlador.insertarPedido(pedidoBean);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Pedido Registrado Correctamente"));
            limpiarCamposIngresos();
            this.listarPedidos();
            this.listarClientes();
            this.listarPublicaciones();


        } catch (Exception e){

            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Pedido No Registrado"));

        }

    }

    public void cancelarIngresoPedido() {
        limpiarCamposIngresos();
    }

    public void editarPedido(Integer idPedido) {
        pedidoBean = pedidoControlador.buscarPedidoById(idPedido);
    }

    public void eliminarPedido(Integer idPedido){
        try {
            Pedido pedido = new Pedido();
            pedido.setIdPedido(idPedido);
            pedidoControlador.eliminarPedido(pedido);
            this.listarPedidos();
        }catch (Exception e){

            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Pedido No Eliminado"));

        }

    }

    private void listarPedidos() {
        lstPedido.clear();
        lstPedido = pedidoControlador.listarPedidos();
    }

    private void listarClientes() {
        lstCliente.clear();
        List<Cliente> lstClienteTemp = clienteControlador.listarClientes();
        for(Cliente cliente: lstClienteTemp) {
            lstCliente.add(new SelectItem(cliente.getIdCliente(), cliente.getNombreCliente() + " " + cliente.getApellidoCliente()));
        }
    }

    private void listarPublicaciones() {
        lstPublicaciones.clear();
        List<Publicacion> lstPublicacionTemp = publicacionControlador.listarPublicaciones();
        for(Publicacion publicacion: lstPublicacionTemp) {
            lstPublicaciones.add(new SelectItem(publicacion.getIdPublicacion(), publicacion.getVendedorPublicacion()));
        }
    }

    private void limpiarCamposIngresos() {
        pedidoBean.setAnuladoPedido("");
        pedidoBean.setFechaPedido(null);
        pedidoBean.setPvpPedido("");
        pedidoBean.setCantidadUnidadesPedido("");
        pedidoBean.setNumeroFacturaPedido("");
        pedidoBean.getFkCliente().setIdCliente(0);
        pedidoBean.setIdPedido(0);
        pedidoBean.getFkPublicacion().setIdPublicacion(0);
    }
}
