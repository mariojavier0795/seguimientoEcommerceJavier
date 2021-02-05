package com.javier.seguimientoEcommerce.modelo.dao.impl;

import com.javier.seguimientoEcommerce.modelo.dao.Producto_2Dao;
import com.javier.seguimientoEcommerce.modelo.entidades.Producto_2;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class Producto_2DaoImpl implements Producto_2Dao {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Ecommerce");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    @Override
    public void insertarProducto_2(Producto_2 producto) {
        try	{
            entityManager.getTransaction().begin();
            entityManager.persist(producto);
            entityManager.getTransaction().commit();
        }catch (Exception e) {}
        finally {
            entityManager.close();
        }
    }

    @Override
    public void actualizarProducto_2(Producto_2 producto) {
        try {
            Producto_2 productoEncontrada = entityManager.find(Producto_2.class, producto.getIdProducto());
            entityManager.getTransaction().begin();
            productoEncontrada.setDetalleProducto(producto.getDetalleProducto());
            productoEncontrada.setPvpProducto(producto.getPvpProducto());
            productoEncontrada.setStockProducto(producto.getStockProducto());
            productoEncontrada.setCostoProducto(producto.getCostoProducto());
            productoEncontrada.setCaducidadProducto(producto.getCaducidadProducto());
            entityManager.getTransaction().commit();
        }catch (Exception e) {}
        finally {
            entityManager.close();
        }
    }

    @Override
    public void eliminarProducto_2Dao(Producto_2 producto) {
        try	{
            entityManager.getTransaction().begin();
            Query query = entityManager.createQuery("delete from Producto_2 where idProducto = :id");
            query.setParameter("id", producto.getIdProducto());
            int deletedRows = query.executeUpdate();
            if (deletedRows != 0)
                entityManager.getTransaction().commit();
        }catch (Exception e) {}
        finally {
            entityManager.close();
        }
    }

    @Override
    public List<Producto_2> listarProductos_2Dao() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Producto_2> CriteriaQuery = criteriaBuilder.createQuery(Producto_2.class);
        Root<Producto_2> productoFormaRoot= CriteriaQuery.from(Producto_2.class);
        CriteriaQuery.select(productoFormaRoot);
        return entityManager.createQuery(CriteriaQuery).getResultList();
    }

    @Override
    public Producto_2 buscarProductoById(Integer idProducto) {
        Query query = entityManager.createQuery("Select pr From Producto_2 pr where pr.idProducto= :id");
        query.setParameter("id", idProducto);
        Producto_2 producto2 = (Producto_2) query.getSingleResult();
        return producto2;
    }
}
