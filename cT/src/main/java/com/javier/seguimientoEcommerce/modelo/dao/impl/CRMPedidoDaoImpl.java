package com.javier.seguimientoEcommerce.modelo.dao.impl;

import com.javier.seguimientoEcommerce.modelo.entidades.CRMPedido;
import com.javier.seguimientoEcommerce.modelo.dao.CRMPedidoDao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class CRMPedidoDaoImpl implements CRMPedidoDao {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Ecommerce");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    @Override
    public void insertarCRMPedido(CRMPedido crmPedido) {
        try	{
            entityManager.getTransaction().begin();
            entityManager.persist(crmPedido);
            entityManager.getTransaction().commit();
        }catch (Exception e) {}
        finally {
            entityManager.close();
        }
    }

    @Override
    public void actualizarCRMPedido(CRMPedido crmPedido) {
        try {
            CRMPedido crmPedidoEncontrada = entityManager.find(CRMPedido.class, crmPedido.getIdCRMPedido());
            entityManager.getTransaction().begin();
            crmPedidoEncontrada.setFechaCRM(crmPedido.getFechaCRM());
            crmPedidoEncontrada.setObservacionCRM(crmPedido.getObservacionCRM());
            crmPedidoEncontrada.setFechaSeguimientoCRM(crmPedido.getFechaSeguimientoCRM());
            entityManager.getTransaction().commit();
        }catch (Exception e) {}
        finally {
            entityManager.close();
        }
    }

    @Override
    public void eliminarCRMPedido(CRMPedido crmPedido) {
        try	{
            entityManager.getTransaction().begin();
            entityManager.remove(crmPedido);
            entityManager.getTransaction().commit();
        }catch (Exception e) {}
        finally {
            entityManager.close();
        }
    }

    @Override
    public List<CRMPedido> listarCRMPedidos() {
        return null;
    }
}
