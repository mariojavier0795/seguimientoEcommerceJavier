package com.javier.seguimientoEcommerce.controlador.impl;

import com.javier.seguimientoEcommerce.controlador.PlataformaControlador;
import com.javier.seguimientoEcommerce.modelo.dao.PlataformaDao;
import com.javier.seguimientoEcommerce.modelo.dao.impl.PlataformaDaoImpl;
import com.javier.seguimientoEcommerce.modelo.entidades.Plataforma;

import java.util.List;

public class PlataformaControladorImpl implements PlataformaControlador {

    private PlataformaDao plataformaDao;

    @Override
    public void insertarPlataforma(Plataforma plataforma) {
        plataformaDao = new PlataformaDaoImpl();
        plataformaDao.insertarPlataforma(plataforma);
    }

    @Override
    public void actualizarPlataforma(Plataforma plataforma) {
        plataformaDao = new PlataformaDaoImpl();
        plataformaDao.actualizarPlataforma(plataforma);
    }

    @Override
    public void eliminarPlataforma(Plataforma plataforma) {
        plataformaDao = new PlataformaDaoImpl();
        plataformaDao.eliminarPlataforma(plataforma);
    }

    @Override
    public List<Plataforma> listarPlataformas() {
        plataformaDao = new PlataformaDaoImpl();
        return plataformaDao.listarPlataformas();
    }

    @Override
    public Plataforma buscarPlataformaById(Integer idPlataforma) {
        plataformaDao = new PlataformaDaoImpl();
        return plataformaDao.buscarPlataformaById(idPlataforma);
    }
}
