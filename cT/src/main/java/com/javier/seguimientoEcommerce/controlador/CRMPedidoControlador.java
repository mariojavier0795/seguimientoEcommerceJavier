package com.javier.seguimientoEcommerce.controlador;

import com.javier.seguimientoEcommerce.modelo.entidades.CRMPedido;

import java.util.List;

public interface CRMPedidoControlador {
    public void insertarCRMPedido(CRMPedido crmPedido);
    public void actualizarCRMPedido(CRMPedido crmPedido);
    public void eliminarCRMPedido(CRMPedido crmPedido);
    public List<CRMPedido> listarCRMPedidos();
}
