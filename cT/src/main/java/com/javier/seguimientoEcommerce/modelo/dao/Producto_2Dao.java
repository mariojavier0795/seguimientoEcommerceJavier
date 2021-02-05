package com.javier.seguimientoEcommerce.modelo.dao;

import com.javier.seguimientoEcommerce.modelo.entidades.Producto_2;

import java.util.List;

public interface Producto_2Dao {

    public void insertarProducto_2(Producto_2 producto);
    public void actualizarProducto_2(Producto_2 producto);
    public void eliminarProducto_2Dao(Producto_2 producto);
    public List<Producto_2> listarProductos_2Dao();
    public Producto_2 buscarProductoById(Integer idProducto);

}
