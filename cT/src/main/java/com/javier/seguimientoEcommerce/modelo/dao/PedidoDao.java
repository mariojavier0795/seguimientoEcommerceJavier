package com.javier.seguimientoEcommerce.modelo.dao;

import com.javier.seguimientoEcommerce.modelo.entidades.Pedido;

import java.util.List;

public interface PedidoDao {

    public void insertarPedido(Pedido pedido);
    public void actualizarPedido(Pedido pedido);
    public void eliminarPedido(Pedido pedido);
    public List<Pedido> listarPedidos();
    public Pedido buscarPedidoById(Integer idPedido);
}
