package com.javier.seguimientoEcommerce.controlador.impl;

import com.javier.seguimientoEcommerce.controlador.DespachoControlador;
import com.javier.seguimientoEcommerce.modelo.dao.DespachoDao;
import com.javier.seguimientoEcommerce.modelo.dao.impl.DespachoDaoImpl;
import com.javier.seguimientoEcommerce.modelo.entidades.Despacho;

import java.util.List;

public class DespachoControladorImpl implements DespachoControlador {

    private DespachoDao despachoDao;

    @Override
    public void insertarDespacho(Despacho despacho) {
        despachoDao = new DespachoDaoImpl();
        despachoDao.insertarDespacho(despacho);
    }

    @Override
    public void actualizarDespacho(Despacho despacho) {
        despachoDao = new DespachoDaoImpl();
        despachoDao.actualizarDespacho(despacho);
    }

    @Override
    public void eliminarDespacho(Despacho despacho) {
        despachoDao = new DespachoDaoImpl();
        despachoDao.eliminarDespacho(despacho);
    }

    @Override
    public List<Despacho> listarDespachos() {
        despachoDao = new DespachoDaoImpl();
        return despachoDao.listarDespachos();
    }

    @Override
    public Despacho buscarDespachoById(Integer idDespacho) {
        despachoDao = new DespachoDaoImpl();
        return despachoDao.buscarDespachoById(idDespacho);
    }
}
