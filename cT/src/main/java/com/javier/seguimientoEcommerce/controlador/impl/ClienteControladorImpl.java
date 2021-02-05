package com.javier.seguimientoEcommerce.controlador.impl;

import com.javier.seguimientoEcommerce.modelo.dao.ClienteDao;
import com.javier.seguimientoEcommerce.modelo.dao.impl.ClienteDaoImpl;
import com.javier.seguimientoEcommerce.controlador.ClienteControlador;
import com.javier.seguimientoEcommerce.modelo.entidades.Cliente;

import java.util.List;

public class ClienteControladorImpl implements ClienteControlador {

    private ClienteDao clienteDao;

    @Override
    public void insertarCliente(Cliente cliente) {
        clienteDao = new ClienteDaoImpl();
        clienteDao.insertarCliente(cliente);
    }

    @Override
    public void actualizarCliente(Cliente cliente) {
        clienteDao = new ClienteDaoImpl();
        clienteDao.actualizarCliente(cliente);
    }

    @Override
    public void eliminarCliente(Cliente cliente) {
        clienteDao = new ClienteDaoImpl();
        clienteDao.eliminarCliente(cliente);
    }

    @Override
    public List<Cliente> listarClientes() {
        clienteDao = new ClienteDaoImpl();
        return clienteDao.listarClientes();
    }

    @Override
    public Cliente buscarClienteById(Integer idCliente) {
        clienteDao = new ClienteDaoImpl();
        return clienteDao.buscarClienteById(idCliente);
    }
}
