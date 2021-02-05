package com.javier.seguimientoEcommerce.modelo.dao.impl;

import com.javier.seguimientoEcommerce.modelo.entidades.Pedido;
import com.javier.seguimientoEcommerce.modelo.dao.PedidoDao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class PedidoDaoImpl implements PedidoDao {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Ecommerce");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    @Override
    public void insertarPedido(Pedido pedido) {
        try	{
            entityManager.getTransaction().begin();
            entityManager.persist(pedido);
            entityManager.getTransaction().commit();
        }catch (Exception e) {}
        finally {
            entityManager.close();
        }
    }

    @Override
    public void actualizarPedido(Pedido pedido) {
        try {
            Pedido pedidoEncontrada = entityManager.find(Pedido.class, pedido.getIdPedido());
            entityManager.getTransaction().begin();
            pedidoEncontrada.setCantidadUnidadesPedido(pedido.getCantidadUnidadesPedido());
            pedidoEncontrada.setFechaPedido(pedido.getFechaPedido());
            pedidoEncontrada.setPvpPedido(pedido.getPvpPedido());
            pedidoEncontrada.setAnuladoPedido(pedido.getAnuladoPedido());
            pedidoEncontrada.setNumeroFacturaPedido(pedido.getNumeroFacturaPedido());
            entityManager.getTransaction().commit();
        }catch (Exception e) {}
        finally {
            entityManager.close();
        }
    }

    @Override
    public void eliminarPedido(Pedido pedido) {
        try	{
            entityManager.getTransaction().begin();
            Query query = entityManager.createQuery("delete from Pedido where idPedido = :id");
            query.setParameter("id", pedido.getIdPedido());
            int deletedRows = query.executeUpdate();
            if (deletedRows != 0)
                entityManager.getTransaction().commit();
        }catch (Exception e) {}
        finally {
            entityManager.close();
        }
    }

    @Override
    public List<Pedido> listarPedidos() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Pedido> CriteriaQuery = criteriaBuilder.createQuery(Pedido.class);
        Root<Pedido> pedidoFormaRoot= CriteriaQuery.from(Pedido.class);
        CriteriaQuery.select(pedidoFormaRoot);
        return entityManager.createQuery(CriteriaQuery).getResultList();
    }

    @Override
    public Pedido buscarPedidoById(Integer idPedido) {
        Query query = entityManager.createQuery("Select pd From Pedido pd where pd.idPedido= :id");
        query.setParameter("id", idPedido);
        Pedido pedido = (Pedido) query.getSingleResult();
        return pedido;
    }
}
