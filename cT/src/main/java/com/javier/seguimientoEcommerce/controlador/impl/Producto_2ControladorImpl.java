package com.javier.seguimientoEcommerce.controlador.impl;

import com.javier.seguimientoEcommerce.controlador.Producto_2Controlador;
import com.javier.seguimientoEcommerce.modelo.dao.Producto_2Dao;
import com.javier.seguimientoEcommerce.modelo.dao.impl.Producto_2DaoImpl;
import com.javier.seguimientoEcommerce.modelo.entidades.Producto_2;

import java.util.List;

public class Producto_2ControladorImpl implements Producto_2Controlador {

    private Producto_2Dao productoDao;

    @Override
    public void insertarProducto_2(Producto_2 producto) {
        productoDao = new Producto_2DaoImpl();
        productoDao.insertarProducto_2(producto);
    }

    @Override
    public void actualizarProducto_2(Producto_2 producto) {
        productoDao = new Producto_2DaoImpl();
        productoDao.actualizarProducto_2(producto);
    }

    @Override
    public void eliminarProducto_2Dao(Producto_2 producto) {
        productoDao = new Producto_2DaoImpl();
        productoDao.eliminarProducto_2Dao(producto);
    }

    @Override
    public List<Producto_2> listarProductos_2Dao() {
        productoDao = new Producto_2DaoImpl();
        return productoDao.listarProductos_2Dao();
    }

    @Override
    public Producto_2 buscarProductoById(Integer idProducto) {
        productoDao = new Producto_2DaoImpl();
        return productoDao.buscarProductoById(idProducto);
    }
}
