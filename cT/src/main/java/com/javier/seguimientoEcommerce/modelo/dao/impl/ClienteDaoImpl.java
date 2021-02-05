package com.javier.seguimientoEcommerce.modelo.dao.impl;

import com.javier.seguimientoEcommerce.modelo.dao.ClienteDao;
import com.javier.seguimientoEcommerce.modelo.entidades.Cliente;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class ClienteDaoImpl implements ClienteDao {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Ecommerce");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    @Override
    public void insertarCliente(Cliente cliente) {

        try	{
            entityManager.getTransaction().begin();
            entityManager.persist(cliente);
            entityManager.getTransaction().commit();
        }catch (Exception e) {}
        finally {
            entityManager.close();
        }

    }

    @Override
    public void actualizarCliente(Cliente cliente) {
        try {
            Cliente clienteEncontrado = entityManager.find(Cliente.class, cliente.getIdCliente());
            entityManager.getTransaction().begin();
            clienteEncontrado.setNombreCliente(cliente.getNombreCliente());
            clienteEncontrado.setCedulaCliente(cliente.getCedulaCliente());
            clienteEncontrado.setApellidoCliente(cliente.getApellidoCliente());
            clienteEncontrado.setTelefonoCliente(cliente.getTelefonoCliente());
            clienteEncontrado.setCelularCliente(cliente.getCelularCliente());
            clienteEncontrado.setCorreoCliente(cliente.getCorreoCliente());
            clienteEncontrado.setCiudadCliente(cliente.getCiudadCliente());
            clienteEncontrado.setProvinciaCliente(cliente.getProvinciaCliente());
            clienteEncontrado.setDireccionCliente(cliente.getDireccionCliente());
            entityManager.getTransaction().commit();
        }catch (Exception e) {}
        finally {
            entityManager.close();
        }
    }

    @Override
    public void eliminarCliente(Cliente cliente) {
        try	{
            entityManager.getTransaction().begin();
            Query query = entityManager.createQuery("delete from Cliente where idCliente = :id");
            query.setParameter("id", cliente.getIdCliente());
            int deletedRows = query.executeUpdate();
            if (deletedRows != 0)
                entityManager.getTransaction().commit();
        }catch (Exception e) {}
        finally {
            entityManager.close();
        }
    }

    @Override
    public List<Cliente> listarClientes() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Cliente> CriteriaQuery = criteriaBuilder.createQuery(Cliente.class);
        Root<Cliente> clienteFormaRoot= CriteriaQuery.from(Cliente.class);
        CriteriaQuery.select(clienteFormaRoot);
        return entityManager.createQuery(CriteriaQuery).getResultList();
    }

    @Override
    public Cliente buscarClienteById(Integer idCliente) {
        Query query = entityManager.createQuery("Select cl From Cliente cl where cl.idCliente= :id");
        query.setParameter("id", idCliente);
        Cliente cliente = (Cliente) query.getSingleResult();
        return cliente;
    }
}
