package com.javier.seguimientoEcommerce.modelo.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
public class Despacho implements Serializable {

    public Despacho(){}

    public Despacho(Date fechaDespacho, String formaTransporteDespacho, Date fechaRecepcionDespacho, String nombreRecibeDespacho, String telefonoRecibeDespacho, String concretadoDespacho, String costoDespacho, String observacionesDespacho, String formaPagoDespacho) {
        this.fechaDespacho = fechaDespacho;
        this.formaTransporteDespacho = formaTransporteDespacho;
        this.fechaRecepcionDespacho = fechaRecepcionDespacho;
        this.nombreRecibeDespacho = nombreRecibeDespacho;
        this.telefonoRecibeDespacho = telefonoRecibeDespacho;
        this.concretadoDespacho = concretadoDespacho;
        this.costoDespacho = costoDespacho;
        this.observacionesDespacho = observacionesDespacho;
        this.formaPagoDespacho = formaPagoDespacho;
    }

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDespacho;

    @Column(name = "fecha_despacho")
    private Date fechaDespacho;

    @Column(name = "forma_transporte_despacho", length = 200)
    private String formaTransporteDespacho;

    @Column(name = "fecha_recepcion_despacho")
    private Date fechaRecepcionDespacho;

    @Column(name = "nombre_recibe_despacho", length = 200)
    private String nombreRecibeDespacho;

    @Column(name = "telefono_recibe_despacho", length = 200)
    private String telefonoRecibeDespacho;

    @Column(name = "concretado_despacho", length = 200)
    private String concretadoDespacho;

    @Column(name = "costo_despacho", length = 200)
    private String costoDespacho;

    @Column(name = "observaciones_despacho", length = 200)
    private String observacionesDespacho;

    @Column(name = "forma_pago_despacho", length = 200)
    private String formaPagoDespacho;

    @ManyToOne(cascade =CascadeType.REFRESH, fetch=FetchType.LAZY)
    @JoinColumn(name="fkPedidoDespacho")
    private Pedido fkPedidoDespacho;

    public int getIdDespacho() {
        return idDespacho;
    }

    public void setIdDespacho(int idDespacho) {
        this.idDespacho = idDespacho;
    }

    public Date getFechaDespacho() {
        return fechaDespacho;
    }

    public void setFechaDespacho(Date fechaDespacho) {
        this.fechaDespacho = fechaDespacho;
    }

    public String getFormaTransporteDespacho() {
        return formaTransporteDespacho;
    }

    public void setFormaTransporteDespacho(String formaTransporteDespacho) {
        this.formaTransporteDespacho = formaTransporteDespacho;
    }

    public Date getFechaRecepcionDespacho() {
        return fechaRecepcionDespacho;
    }

    public void setFechaRecepcionDespacho(Date fechaRecepcionDespacho) {
        this.fechaRecepcionDespacho = fechaRecepcionDespacho;
    }

    public String getNombreRecibeDespacho() {
        return nombreRecibeDespacho;
    }

    public void setNombreRecibeDespacho(String nombreRecibeDespacho) {
        this.nombreRecibeDespacho = nombreRecibeDespacho;
    }

    public String getTelefonoRecibeDespacho() {
        return telefonoRecibeDespacho;
    }

    public void setTelefonoRecibeDespacho(String telefonoRecibeDespacho) {
        this.telefonoRecibeDespacho = telefonoRecibeDespacho;
    }

    public String getConcretadoDespacho() {
        return concretadoDespacho;
    }

    public void setConcretadoDespacho(String concretadoDespacho) {
        this.concretadoDespacho = concretadoDespacho;
    }

    public String getCostoDespacho() {
        return costoDespacho;
    }

    public void setCostoDespacho(String costoDespacho) {
        this.costoDespacho = costoDespacho;
    }

    public String getObservacionesDespacho() {
        return observacionesDespacho;
    }

    public void setObservacionesDespacho(String observacionesDespacho) {
        this.observacionesDespacho = observacionesDespacho;
    }

    public String getFormaPagoDespacho() {
        return formaPagoDespacho;
    }

    public void setFormaPagoDespacho(String formaPagoDespacho) {
        this.formaPagoDespacho = formaPagoDespacho;
    }

    public Pedido getFkPedidoDespacho() {
        return fkPedidoDespacho;
    }

    public void setFkPedidoDespacho(Pedido fkPedidoDespacho) {
        this.fkPedidoDespacho = fkPedidoDespacho;
    }

    @Override
    public String toString() {
        return "Despacho{" +
                "idDespacho=" + idDespacho +
                ", fechaDespacho=" + fechaDespacho +
                ", formaTransporteDespacho='" + formaTransporteDespacho + '\'' +
                ", fechaRecepcionDespacho=" + fechaRecepcionDespacho +
                ", nombreRecibeDespacho='" + nombreRecibeDespacho + '\'' +
                ", telefonoRecibeDespacho='" + telefonoRecibeDespacho + '\'' +
                ", concretadoDespacho='" + concretadoDespacho + '\'' +
                ", costoDespacho='" + costoDespacho + '\'' +
                ", observacionesDespacho='" + observacionesDespacho + '\'' +
                ", formaPagoDespacho='" + formaPagoDespacho + '\'' +
                '}';
    }
}

