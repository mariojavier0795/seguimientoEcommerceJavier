package com.javier.seguimientoEcommerce.modelo.entidades;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Producto_2 implements Serializable {

    public Producto_2(){}

    public Producto_2(String detalleProducto, String pvpProducto, String stockProducto, String costoProducto, String caducidadProducto) {
        this.detalleProducto = detalleProducto;
        this.pvpProducto = pvpProducto;
        this.stockProducto = stockProducto;
        this.costoProducto = costoProducto;
        this.caducidadProducto = caducidadProducto;
    }

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProducto;

    @Column(name = "detalle_producto", length = 200)
    private String detalleProducto;

    @Column(name = "pvp_producto", length = 200)
    private String pvpProducto;

    @Column(name = "stock_producto", length = 200)
    private String stockProducto;

    @Column(name = "costo_producto", length = 200)
    private String costoProducto;

    @Column(name = "caducidad_producto", length = 200)
    private String caducidadProducto;

    // RELACION producto con publicacion
    @OneToMany (mappedBy ="fkProducto_2", cascade =CascadeType.REFRESH)
    private List<Publicacion> lstPublicaciones = new ArrayList<Publicacion>();

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getDetalleProducto() {
        return detalleProducto;
    }

    public void setDetalleProducto(String detalleProducto) {
        this.detalleProducto = detalleProducto;
    }

    public String getPvpProducto() {
        return pvpProducto;
    }

    public void setPvpProducto(String pvpProducto) {
        this.pvpProducto = pvpProducto;
    }

    public String getStockProducto() {
        return stockProducto;
    }

    public void setStockProducto(String stockProducto) {
        this.stockProducto = stockProducto;
    }

    public String getCostoProducto() {
        return costoProducto;
    }

    public void setCostoProducto(String costoProducto) {
        this.costoProducto = costoProducto;
    }

    public String getCaducidadProducto() {
        return caducidadProducto;
    }

    public void setCaducidadProducto(String caducidadProducto) {
        this.caducidadProducto = caducidadProducto;
    }

    public List<Publicacion> getLstPublicaciones() {
        return lstPublicaciones;
    }

    public void setLstPublicaciones(List<Publicacion> lstPublicaciones) {
        this.lstPublicaciones = lstPublicaciones;
    }

    @Override
    public String toString() {
        return "Producto_2{" +
                "idProducto=" + idProducto +
                ", detalleProducto='" + detalleProducto + '\'' +
                ", pvpProducto='" + pvpProducto + '\'' +
                ", stockProducto='" + stockProducto + '\'' +
                ", costoProducto='" + costoProducto + '\'' +
                ", caducidadProducto='" + caducidadProducto + '\'' +
                '}';
    }
}
