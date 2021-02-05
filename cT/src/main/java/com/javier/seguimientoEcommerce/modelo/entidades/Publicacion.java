package com.javier.seguimientoEcommerce.modelo.entidades;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
public class Publicacion implements Serializable {

    public Publicacion(){}

    public Publicacion(Date fechaPublicacion, Date fechaVencimientoPublicacion, String cantidadPublicacion, String vendedorPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
        this.fechaVencimientoPublicacion = fechaVencimientoPublicacion;
        this.cantidadPublicacion = cantidadPublicacion;
        this.vendedorPublicacion = vendedorPublicacion;
    }

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPublicacion;

    @Column(name = "fecha_publicacion")
    private Date fechaPublicacion;

    @Column(name = "fecha_vencimiento_publicacion")
    private Date fechaVencimientoPublicacion;

    @Column(name = "cantidad_publicacion", length = 200)
    private String cantidadPublicacion;

    @Column(name = "vendedor_publicacion", length = 200)
    private String vendedorPublicacion;

    // RELACION publicacion con pedido
    @OneToMany (mappedBy ="fkPublicacion", cascade =CascadeType.REFRESH)
    private List<Pedido> lstPedidos = new ArrayList<Pedido>();

    @ManyToOne(cascade =CascadeType.REFRESH, fetch=FetchType.LAZY)
    @JoinColumn(name="fkPlataforma")
    private Plataforma fkPlataforma;

    @ManyToOne(cascade =CascadeType.REFRESH, fetch=FetchType.LAZY)
    @JoinColumn(name="fkProducto_2")
    private Producto_2 fkProducto_2;

    public int getIdPublicacion() {
        return idPublicacion;
    }

    public void setIdPublicacion(int idPublicacion) {
        this.idPublicacion = idPublicacion;
    }

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public Date getFechaVencimientoPublicacion() {
        return fechaVencimientoPublicacion;
    }

    public void setFechaVencimientoPublicacion(Date fechaVencimientoPublicacion) {
        this.fechaVencimientoPublicacion = fechaVencimientoPublicacion;
    }

    public String getCantidadPublicacion() {
        return cantidadPublicacion;
    }

    public void setCantidadPublicacion(String cantidadPublicacion) {
        this.cantidadPublicacion = cantidadPublicacion;
    }

    public String getVendedorPublicacion() {
        return vendedorPublicacion;
    }

    public void setVendedorPublicacion(String vendedorPublicacion) {
        this.vendedorPublicacion = vendedorPublicacion;
    }

    public List<Pedido> getLstPedidos() {
        return lstPedidos;
    }

    public void setLstPedidos(List<Pedido> lstPedidos) {
        this.lstPedidos = lstPedidos;
    }

    public Plataforma getFkPlataforma() {
        return fkPlataforma;
    }

    public void setFkPlataforma(Plataforma fkPlataforma) {
        this.fkPlataforma = fkPlataforma;
    }

    public Producto_2 getFkProducto_2() {
        return fkProducto_2;
    }

    public void setFkProducto_2(Producto_2 fkProducto_2) {
        this.fkProducto_2 = fkProducto_2;
    }

    @Override
    public String toString() {
        return "Publicacion{" +
                "idPublicacion=" + idPublicacion +
                ", fechaPublicacion=" + fechaPublicacion +
                ", fechaVencimientoPublicacion=" + fechaVencimientoPublicacion +
                ", cantidadPublicacion='" + cantidadPublicacion + '\'' +
                ", vendedorPublicacion='" + vendedorPublicacion + '\'' +
                '}';
    }
}
