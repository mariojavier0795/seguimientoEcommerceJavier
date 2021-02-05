package com.javier.seguimientoEcommerce.vista;

import com.javier.seguimientoEcommerce.controlador.ClienteControlador;
import com.javier.seguimientoEcommerce.controlador.impl.ClienteControladorImpl;
import com.javier.seguimientoEcommerce.modelo.entidades.Cliente;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "clienteVista")
@ViewScoped
public class ClienteVista implements Serializable {

    public ClienteControlador clienteControlador;
    private Cliente clienteBean = new Cliente();
    private List<Cliente> lstClientes;

    public Cliente getClienteBean() {
        return clienteBean;
    }

    public void setClienteBean(Cliente clienteBean) {
        this.clienteBean = clienteBean;
    }

    public List<Cliente> getLstClientes() {
        return lstClientes;
    }

    public void setLstClientes(List<Cliente> lstClientes) {
        this.lstClientes = lstClientes;
    }

    @PostConstruct
    public void init() {
        clienteControlador = new ClienteControladorImpl();
        lstClientes= new ArrayList<Cliente>();
        this.listarClientes();
    }

    public void insertarCliente() {

        try {
            if (clienteBean.getIdCliente() != 0) {
                clienteControlador.actualizarCliente(clienteBean);
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Cliente Actualizado Correctamente"));
                limpiarCamposIngresos();
                this.listarClientes();
                return;
            }
            clienteControlador.insertarCliente(clienteBean);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Cliente Registrado Correctamente"));
            limpiarCamposIngresos();
            this.listarClientes();


        } catch (Exception e){

            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Cliente No Registrado"));

        }

    }

    public void cancelarIngresoCliente() {
        limpiarCamposIngresos();
    }

    public void editarCliente(Integer idCliente) {
        clienteBean = clienteControlador.buscarClienteById(idCliente);
    }

    public void eliminarCliente(Integer idCliente){
        try {
            Cliente cliente = new Cliente();
            cliente.setIdCliente(idCliente);
            clienteControlador.eliminarCliente(cliente);
            this.listarClientes();
        }catch (Exception e){

            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Plataforma No Eliminada"));

        }

    }

    private void listarClientes() {
        lstClientes = clienteControlador.listarClientes();
    }

    private void limpiarCamposIngresos() {
        clienteBean.setApellidoCliente("");
        clienteBean.setCedulaCliente("");
        clienteBean.setCelularCliente("");
        clienteBean.setCiudadCliente("");
        clienteBean.setCorreoCliente("");
        clienteBean.setNombreCliente("");
        clienteBean.setProvinciaCliente("");
        clienteBean.setDireccionCliente("");
        clienteBean.setTelefonoCliente("");
        clienteBean.setIdCliente(0);
    }
}
