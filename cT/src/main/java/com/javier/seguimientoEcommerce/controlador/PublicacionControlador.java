package com.javier.seguimientoEcommerce.controlador;

import com.javier.seguimientoEcommerce.modelo.entidades.Publicacion;

import java.util.List;

public interface PublicacionControlador {
    public void insertarPublicacion(Publicacion publicacion);
    public void actualizarPublicacion(Publicacion publicacion);
    public void eliminarPublicacion(Publicacion publicacion);
    public List<Publicacion> listarPublicaciones();
    public Publicacion buscarPublicacionById(Integer idPublicacion);
}
