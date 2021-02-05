package com.javier.seguimientoEcommerce.modelo.dao.impl;

import com.javier.seguimientoEcommerce.modelo.dao.PublicacionDao;
import com.javier.seguimientoEcommerce.modelo.entidades.Publicacion;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class PublicacionDaoImpl implements PublicacionDao {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Ecommerce");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    @Override
    public void insertarPublicacion(Publicacion publicacion) {
        try	{
            entityManager.getTransaction().begin();
            entityManager.persist(publicacion);
            entityManager.getTransaction().commit();
        }catch (Exception e) {}
        finally {
            entityManager.close();
        }
    }

    @Override
    public void actualizarPublicacion(Publicacion publicacion) {
        try {
            Publicacion publicacionEncontrado = entityManager.find(Publicacion.class, publicacion.getIdPublicacion());
            entityManager.getTransaction().begin();
            publicacionEncontrado.setFechaPublicacion(publicacion.getFechaPublicacion());
            publicacionEncontrado.setFechaVencimientoPublicacion(publicacion.getFechaVencimientoPublicacion());
            publicacionEncontrado.setCantidadPublicacion(publicacion.getCantidadPublicacion());
            publicacionEncontrado.setVendedorPublicacion(publicacion.getVendedorPublicacion());
            entityManager.getTransaction().commit();
        }catch (Exception e) {}
        finally {
            entityManager.close();
        }
    }

    @Override
    public void eliminarPublicacion(Publicacion publicacion) {
        try	{
            entityManager.getTransaction().begin();
            Query query = entityManager.createQuery("delete from Publicacion where idPublicacion = :id");
            query.setParameter("id", publicacion.getIdPublicacion());
            int deletedRows = query.executeUpdate();
            if (deletedRows != 0)
                entityManager.getTransaction().commit();
        }catch (Exception e) {}
        finally {
            entityManager.close();
        }
    }

    @Override
    public List<Publicacion> listarPublicaciones() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Publicacion> CriteriaQuery = criteriaBuilder.createQuery(Publicacion.class);
        Root<Publicacion> publicacionFormaRoot= CriteriaQuery.from(Publicacion.class);
        CriteriaQuery.select(publicacionFormaRoot);
        return entityManager.createQuery(CriteriaQuery).getResultList();
    }

    @Override
    public Publicacion buscarPublicacionById(Integer idPublicacion) {
        Query query = entityManager.createQuery("Select pb From Publicacion pb where pb.idPublicacion= :id");
        query.setParameter("id", idPublicacion);
        Publicacion publicacion = (Publicacion) query.getSingleResult();
        return publicacion;
    }
}
