package com.javier.seguimientoEcommerce.controlador;

import com.javier.seguimientoEcommerce.modelo.entidades.Cliente;

import java.util.List;

public interface ClienteControlador {
    public void insertarCliente(Cliente cliente);
    public void actualizarCliente(Cliente cliente);
    public void eliminarCliente(Cliente cliente);
    public List<Cliente> listarClientes();
    public Cliente buscarClienteById(Integer idCliente);
}
