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
public class Cliente implements Serializable {

    public Cliente(){}

    public Cliente(String nombreCliente, String cedulaCliente, String apellidoCliente, String telefonoCliente, String celularCliente, String correoCliente, String ciudadCliente, String provinciaCliente, String direccionCliente) {
        this.nombreCliente = nombreCliente;
        this.cedulaCliente = cedulaCliente;
        this.apellidoCliente = apellidoCliente;
        this.telefonoCliente = telefonoCliente;
        this.celularCliente = celularCliente;
        this.correoCliente = correoCliente;
        this.ciudadCliente = ciudadCliente;
        this.provinciaCliente = provinciaCliente;
        this.direccionCliente = direccionCliente;
    }

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCliente;

    @Column(name = "nombre_cliente", length = 200)
    private String nombreCliente;

    @Column(name = "cedula_cliente", length = 20)
    private String cedulaCliente;

    @Column(name = "apellido_cliente", length = 200)
    private String apellidoCliente;

    @Column(name = "telefono_cliente", length = 200)
    private String telefonoCliente;

    @Column(name = "celular_cliente", length = 200)
    private String celularCliente;

    @Column(name = "correo_cliente", length = 200)
    private String correoCliente;

    @Column(name = "ciudad_cliente", length = 200)
    private String ciudadCliente;

    @Column(name = "provincia_cliente", length = 200)
    private String provinciaCliente;

    @Column(name = "direccion_cliente", length = 200)
    private String direccionCliente;

    // RELACION cliente con pedido
    @OneToMany (mappedBy ="fkCliente", cascade =CascadeType.REFRESH)
    private List<Pedido> lstPedidos = new ArrayList<Pedido>();


    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getCedulaCliente() {
        return cedulaCliente;
    }

    public void setCedulaCliente(String cedulaCliente) {
        this.cedulaCliente = cedulaCliente;
    }

    public String getApellidoCliente() {
        return apellidoCliente;
    }

    public void setApellidoCliente(String apellidoCliente) {
        this.apellidoCliente = apellidoCliente;
    }

    public String getTelefonoCliente() {
        return telefonoCliente;
    }

    public void setTelefonoCliente(String telefonoCliente) {
        this.telefonoCliente = telefonoCliente;
    }

    public String getCelularCliente() {
        return celularCliente;
    }

    public void setCelularCliente(String celularCliente) {
        this.celularCliente = celularCliente;
    }

    public String getCorreoCliente() {
        return correoCliente;
    }

    public void setCorreoCliente(String correoCliente) {
        this.correoCliente = correoCliente;
    }

    public String getCiudadCliente() {
        return ciudadCliente;
    }

    public void setCiudadCliente(String ciudadCliente) {
        this.ciudadCliente = ciudadCliente;
    }

    public String getProvinciaCliente() {
        return provinciaCliente;
    }

    public void setProvinciaCliente(String provinciaCliente) {
        this.provinciaCliente = provinciaCliente;
    }

    public String getDireccionCliente() {
        return direccionCliente;
    }

    public void setDireccionCliente(String direccionCliente) {
        this.direccionCliente = direccionCliente;
    }

    public List<Pedido> getLstPedidos() {
        return lstPedidos;
    }

    public void setLstPedidos(List<Pedido> lstPedidos) {
        this.lstPedidos = lstPedidos;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "idCliente=" + idCliente +
                ", nombreCliente='" + nombreCliente + '\'' +
                ", cedulaCliente='" + cedulaCliente + '\'' +
                ", apellidoCliente='" + apellidoCliente + '\'' +
                ", telefonoCliente='" + telefonoCliente + '\'' +
                ", celularCliente='" + celularCliente + '\'' +
                ", correoCliente='" + correoCliente + '\'' +
                ", ciudadCliente='" + ciudadCliente + '\'' +
                ", provinciaCliente='" + provinciaCliente + '\'' +
                ", direccionCliente='" + direccionCliente + '\'' +
                '}';
    }
}

