package com.javier.seguimientoEcommerce.modelo.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
public class Pedido implements Serializable {

    public Pedido() {}

    public Pedido(String cantidadUnidadesPedido, Date fechaPedido, String pvpPedido, String anuladoPedido, String numeroFacturaPedido) {
        this.cantidadUnidadesPedido = cantidadUnidadesPedido;
        this.fechaPedido = fechaPedido;
        this.pvpPedido = pvpPedido;
        this.anuladoPedido = anuladoPedido;
        this.numeroFacturaPedido = numeroFacturaPedido;
    }

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPedido;

    @Column(name = "cantidad_unidades_pedido", length = 200)
    private String cantidadUnidadesPedido;

    @Column(name = "fecha_pedido")
    private Date fechaPedido;

    @Column(name = "pvp_pedido", length = 200)
    private String pvpPedido;

    @Column(name = "anulado_pedido", length = 1)
    private String anuladoPedido;

    @Column(name = "numero_factura_pedido", length = 200)
    private String numeroFacturaPedido;

    // RELACION pedido con crmpedido
    @OneToMany (mappedBy ="fkPedido", cascade =CascadeType.REFRESH)
    private List<CRMPedido> lstCRMPedidos = new ArrayList<CRMPedido>();

    // RELACION pedido con despacho
    @OneToMany (mappedBy ="fkPedidoDespacho", cascade =CascadeType.REFRESH)
    private List<Despacho> lstDespachos = new ArrayList<Despacho>();

    @ManyToOne(cascade =CascadeType.REFRESH, fetch=FetchType.LAZY)
    @JoinColumn(name="fkCliente")
    private Cliente fkCliente;

    @ManyToOne(cascade =CascadeType.REFRESH, fetch=FetchType.LAZY)
    @JoinColumn(name="fkPublicacion")
    private Publicacion fkPublicacion;

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public String getCantidadUnidadesPedido() {
        return cantidadUnidadesPedido;
    }

    public void setCantidadUnidadesPedido(String cantidadUnidadesPedido) {
        this.cantidadUnidadesPedido = cantidadUnidadesPedido;
    }

    public Date getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(Date fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public String getPvpPedido() {
        return pvpPedido;
    }

    public void setPvpPedido(String pvpPedido) {
        this.pvpPedido = pvpPedido;
    }

    public String getAnuladoPedido() {
        return anuladoPedido;
    }

    public void setAnuladoPedido(String anuladoPedido) {
        this.anuladoPedido = anuladoPedido;
    }

    public String getNumeroFacturaPedido() {
        return numeroFacturaPedido;
    }

    public void setNumeroFacturaPedido(String numeroFacturaPedido) {
        this.numeroFacturaPedido = numeroFacturaPedido;
    }

    public List<CRMPedido> getLstCRMPedidos() {
        return lstCRMPedidos;
    }

    public void setLstCRMPedidos(List<CRMPedido> lstCRMPedidos) {
        this.lstCRMPedidos = lstCRMPedidos;
    }

    public List<Despacho> getLstDespachos() {
        return lstDespachos;
    }

    public void setLstDespachos(List<Despacho> lstDespachos) {
        this.lstDespachos = lstDespachos;
    }

    public Cliente getFkCliente() {
        return fkCliente;
    }

    public void setFkCliente(Cliente fkCliente) {
        this.fkCliente = fkCliente;
    }

    public Publicacion getFkPublicacion() {
        return fkPublicacion;
    }

    public void setFkPublicacion(Publicacion fkPublicacion) {
        this.fkPublicacion = fkPublicacion;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "idPedido=" + idPedido +
                ", cantidadUnidadesPedido='" + cantidadUnidadesPedido + '\'' +
                ", fechaPedido=" + fechaPedido +
                ", pvpPedido='" + pvpPedido + '\'' +
                ", anuladoPedido='" + anuladoPedido + '\'' +
                ", numeroFacturaPedido='" + numeroFacturaPedido + '\'' +
                '}';
    }
}

