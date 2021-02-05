package com.javier.seguimientoEcommerce.controlador.impl;

import com.javier.seguimientoEcommerce.modelo.entidades.Publicacion;
import com.javier.seguimientoEcommerce.controlador.PublicacionControlador;
import com.javier.seguimientoEcommerce.modelo.dao.PublicacionDao;
import com.javier.seguimientoEcommerce.modelo.dao.impl.PublicacionDaoImpl;

import java.util.List;

public class PublicacionControladorImpl implements PublicacionControlador {

    private PublicacionDao publicacionDao;

    @Override
    public void insertarPublicacion(Publicacion publicacion) {
        publicacionDao = new PublicacionDaoImpl();
        publicacionDao.insertarPublicacion(publicacion);
    }

    @Override
    public void actualizarPublicacion(Publicacion publicacion) {
        publicacionDao = new PublicacionDaoImpl();
        publicacionDao.actualizarPublicacion(publicacion);
    }

    @Override
    public void eliminarPublicacion(Publicacion publicacion) {
        publicacionDao = new PublicacionDaoImpl();
        publicacionDao.eliminarPublicacion(publicacion);
    }

    @Override
    public List<Publicacion> listarPublicaciones() {
        publicacionDao = new PublicacionDaoImpl();
        return publicacionDao.listarPublicaciones();
    }

    @Override
    public Publicacion buscarPublicacionById(Integer idPublicacion) {
        publicacionDao = new PublicacionDaoImpl();
        return publicacionDao.buscarPublicacionById(idPublicacion);
    }
}
