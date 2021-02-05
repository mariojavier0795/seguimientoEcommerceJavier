package com.javier.seguimientoEcommerce.modelo.dao;


import com.javier.seguimientoEcommerce.modelo.entidades.Despacho;

import java.util.List;

public interface DespachoDao {

    public void insertarDespacho(Despacho despacho);
    public void actualizarDespacho(Despacho despacho);
    public void eliminarDespacho(Despacho despacho);
    public List<Despacho> listarDespachos();
    public Despacho buscarDespachoById(Integer idDespacho);

}
