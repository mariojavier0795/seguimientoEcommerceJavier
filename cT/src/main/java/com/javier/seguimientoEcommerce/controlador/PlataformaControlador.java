package com.javier.seguimientoEcommerce.controlador;

import com.javier.seguimientoEcommerce.modelo.entidades.Plataforma;

import java.util.List;

public interface PlataformaControlador {
    public void insertarPlataforma(Plataforma plataforma);
    public void actualizarPlataforma(Plataforma plataforma);
    public void eliminarPlataforma(Plataforma plataforma);
    public List<Plataforma> listarPlataformas();
    public Plataforma buscarPlataformaById(Integer idPlataforma);
}
