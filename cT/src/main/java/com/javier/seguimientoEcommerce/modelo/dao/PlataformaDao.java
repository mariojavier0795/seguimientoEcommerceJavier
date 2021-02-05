package com.javier.seguimientoEcommerce.modelo.dao;


import com.javier.seguimientoEcommerce.modelo.entidades.Plataforma;

import java.util.List;

public interface PlataformaDao {

    public void insertarPlataforma(Plataforma plataforma);
    public void actualizarPlataforma(Plataforma plataforma);
    public void eliminarPlataforma(Plataforma plataforma);
    public List<Plataforma> listarPlataformas();
    public Plataforma buscarPlataformaById(Integer idPlataforma);

}
