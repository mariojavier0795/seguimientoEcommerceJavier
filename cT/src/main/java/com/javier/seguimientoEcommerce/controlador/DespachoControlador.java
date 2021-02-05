package com.javier.seguimientoEcommerce.controlador;

import com.javier.seguimientoEcommerce.modelo.entidades.Despacho;

import java.util.List;

public interface DespachoControlador {
    public void insertarDespacho(Despacho despacho);
    public void actualizarDespacho(Despacho despacho);
    public void eliminarDespacho(Despacho despacho);
    public List<Despacho> listarDespachos();
    public Despacho buscarDespachoById(Integer idDespacho);
}
