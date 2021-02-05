package com.javier.seguimientoEcommerce.controlador.impl;

import com.javier.seguimientoEcommerce.modelo.entidades.Pedido;
import com.javier.seguimientoEcommerce.controlador.PedidoControlador;
import com.javier.seguimientoEcommerce.modelo.dao.PedidoDao;
import com.javier.seguimientoEcommerce.modelo.dao.impl.PedidoDaoImpl;

import java.util.List;

public class PedidoControladorImpl implements PedidoControlador {

    private PedidoDao pedidoDao;

    @Override
    public void insertarPedido(Pedido pedido) {
        pedidoDao = new PedidoDaoImpl();
        pedidoDao.insertarPedido(pedido);
    }

    @Override
    public void actualizarPedido(Pedido pedido) {
        pedidoDao = new PedidoDaoImpl();
        pedidoDao.actualizarPedido(pedido);
    }

    @Override
    public void eliminarPedido(Pedido pedido) {
        pedidoDao = new PedidoDaoImpl();
        pedidoDao.eliminarPedido(pedido);
    }

    @Override
    public List<Pedido> listarPedidos() {
        pedidoDao = new PedidoDaoImpl();
        return pedidoDao.listarPedidos();
    }

    @Override
    public Pedido buscarPedidoById(Integer idPedido) {
        pedidoDao = new PedidoDaoImpl();
        return pedidoDao.buscarPedidoById(idPedido);
    }
}
