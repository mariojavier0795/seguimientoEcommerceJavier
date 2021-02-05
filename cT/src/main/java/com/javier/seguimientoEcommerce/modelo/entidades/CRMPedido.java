package com.javier.seguimientoEcommerce.modelo.entidades;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
public class CRMPedido implements Serializable {

    public CRMPedido() {}

    public CRMPedido(Date fechaCRM, String observacionCRM, Date fechaSeguimientoCRM) {
        this.fechaCRM = fechaCRM;
        this.observacionCRM = observacionCRM;
        this.fechaSeguimientoCRM = fechaSeguimientoCRM;
    }

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCRMPedido;

    @Column(name = "fecha_crm")
    private Date fechaCRM;

    @Column(name = "observacion_crm", length = 200)
    private String observacionCRM;

    @Column(name = "fecha_seguimiento_crm")
    private Date fechaSeguimientoCRM;

    @ManyToOne(cascade =CascadeType.REFRESH, fetch=FetchType.LAZY)
    @JoinColumn(name="fkPedido")
    private Pedido fkPedido;

    public int getIdCRMPedido() {
        return idCRMPedido;
    }

    public void setIdCRMPedido(int idCRMPedido) {
        this.idCRMPedido = idCRMPedido;
    }

    public Date getFechaCRM() {
        return fechaCRM;
    }

    public void setFechaCRM(Date fechaCRM) {
        this.fechaCRM = fechaCRM;
    }

    public String getObservacionCRM() {
        return observacionCRM;
    }

    public void setObservacionCRM(String observacionCRM) {
        this.observacionCRM = observacionCRM;
    }

    public Date getFechaSeguimientoCRM() {
        return fechaSeguimientoCRM;
    }

    public void setFechaSeguimientoCRM(Date fechaSeguimientoCRM) {
        this.fechaSeguimientoCRM = fechaSeguimientoCRM;
    }

    public Pedido getFkPedido() {
        return fkPedido;
    }

    public void setFkPedido(Pedido fkPedido) {
        this.fkPedido = fkPedido;
    }

    @Override
    public String toString() {
        return "CRMPedido{" +
                "idCRMPedido=" + idCRMPedido +
                ", fechaCRM=" + fechaCRM +
                ", observacionCRM='" + observacionCRM + '\'' +
                ", fechaSeguimientoCRM=" + fechaSeguimientoCRM +
                '}';
    }
}
