package com.javier.seguimientoEcommerce.controlador.impl;

import com.javier.seguimientoEcommerce.modelo.entidades.CRMPedido;
import com.javier.seguimientoEcommerce.controlador.CRMPedidoControlador;
import com.javier.seguimientoEcommerce.modelo.dao.CRMPedidoDao;
import com.javier.seguimientoEcommerce.modelo.dao.impl.CRMPedidoDaoImpl;

import java.util.List;

public class CRMPedidoControladorImpl implements CRMPedidoControlador {

    private CRMPedidoDao crmPedidoDao;

    @Override
    public void insertarCRMPedido(CRMPedido crmPedido) {
        crmPedidoDao = new CRMPedidoDaoImpl();
        crmPedidoDao.insertarCRMPedido(crmPedido);
    }

    @Override
    public void actualizarCRMPedido(CRMPedido crmPedido) {
        crmPedidoDao = new CRMPedidoDaoImpl();
        crmPedidoDao.actualizarCRMPedido(crmPedido);
    }

    @Override
    public void eliminarCRMPedido(CRMPedido crmPedido) {
        crmPedidoDao = new CRMPedidoDaoImpl();
        crmPedidoDao.eliminarCRMPedido(crmPedido);
    }

    @Override
    public List<CRMPedido> listarCRMPedidos() {
        return null;
    }
}
