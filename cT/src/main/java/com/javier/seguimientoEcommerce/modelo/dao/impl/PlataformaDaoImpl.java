package com.javier.seguimientoEcommerce.modelo.dao.impl;

import com.javier.seguimientoEcommerce.modelo.dao.PlataformaDao;
import com.javier.seguimientoEcommerce.modelo.entidades.Plataforma;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class PlataformaDaoImpl implements PlataformaDao {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Ecommerce");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    @Override
    public void insertarPlataforma(Plataforma plataforma) {
        try	{
            entityManager.getTransaction().begin();
            entityManager.persist(plataforma);
            entityManager.getTransaction().commit();
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        finally {
            entityManager.close();
        }

    }

    @Override
    public void actualizarPlataforma(Plataforma plataforma) {
        try {
            Plataforma plataformaEncontrada = entityManager.find(Plataforma.class, plataforma.getIdPlataforma());
            entityManager.getTransaction().begin();
            plataformaEncontrada.setNombrePlataforma(plataforma.getNombrePlataforma());
            plataformaEncontrada.setObservacionPlataforma(plataforma.getObservacionPlataforma());
            entityManager.getTransaction().commit();
        }catch (Exception e) {}
        finally {
            entityManager.close();
        }
    }

    @Override
    public void eliminarPlataforma(Plataforma plataforma) {
        try	{
            entityManager.getTransaction().begin();
            Query query = entityManager.createQuery("delete from Plataforma where idPlataforma = :id");
            query.setParameter("id", plataforma.getIdPlataforma());
            int deletedRows = query.executeUpdate();
            if (deletedRows != 0)
                entityManager.getTransaction().commit();
        }catch (Exception e) {}
        finally {
            entityManager.close();
        }
    }

    @Override
    public List<Plataforma> listarPlataformas() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Plataforma> CriteriaQuery = criteriaBuilder.createQuery(Plataforma.class);
        Root<Plataforma> plataformaRoot= CriteriaQuery.from(Plataforma.class);
        CriteriaQuery.select(plataformaRoot);
        return entityManager.createQuery(CriteriaQuery).getResultList();
    }

    @Override
    public Plataforma buscarPlataformaById(Integer idPlataforma) {
        Query query = entityManager.createQuery("Select pl From Plataforma pl where pl.idPlataforma= :id");
        query.setParameter("id", idPlataforma);
        Plataforma plataforma = (Plataforma) query.getSingleResult();
        return plataforma;
    }
}
