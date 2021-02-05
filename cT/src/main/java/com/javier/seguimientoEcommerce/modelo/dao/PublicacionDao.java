package com.javier.seguimientoEcommerce.modelo.dao;


import com.javier.seguimientoEcommerce.modelo.entidades.Publicacion;

import java.util.List;

public interface PublicacionDao {

    public void insertarPublicacion(Publicacion publicacion);
    public void actualizarPublicacion(Publicacion publicacion);
    public void eliminarPublicacion(Publicacion publicacion);
    public List<Publicacion> listarPublicaciones();
    public Publicacion buscarPublicacionById(Integer idPublicacion);

}
