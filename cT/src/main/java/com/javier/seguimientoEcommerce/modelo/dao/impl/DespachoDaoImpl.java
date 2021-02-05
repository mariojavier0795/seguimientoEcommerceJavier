package com.javier.seguimientoEcommerce.modelo.dao.impl;

import com.javier.seguimientoEcommerce.modelo.entidades.Despacho;
import com.javier.seguimientoEcommerce.modelo.dao.DespachoDao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class DespachoDaoImpl implements DespachoDao {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Ecommerce");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    @Override
    public void insertarDespacho(Despacho despacho) {
        try	{
            entityManager.getTransaction().begin();
            entityManager.persist(despacho);
            entityManager.getTransaction().commit();
        }catch (Exception e) {}
        finally {
            entityManager.close();
        }
    }

    @Override
    public void actualizarDespacho(Despacho despacho) {
        try {
            Despacho despachoEncontrado = entityManager.find(Despacho.class, despacho.getIdDespacho());
            entityManager.getTransaction().begin();
            despachoEncontrado.setFechaDespacho(despacho.getFechaDespacho());
            despachoEncontrado.setFormaTransporteDespacho(despacho.getFormaTransporteDespacho());
            despachoEncontrado.setFechaRecepcionDespacho(despacho.getFechaRecepcionDespacho());
            despachoEncontrado.setNombreRecibeDespacho(despacho.getNombreRecibeDespacho());
            despachoEncontrado.setTelefonoRecibeDespacho(despacho.getTelefonoRecibeDespacho());
            despachoEncontrado.setConcretadoDespacho(despacho.getConcretadoDespacho());
            despachoEncontrado.setCostoDespacho(despacho.getCostoDespacho());
            despachoEncontrado.setObservacionesDespacho(despacho.getObservacionesDespacho());
            despachoEncontrado.setFormaPagoDespacho(despacho.getFormaPagoDespacho());
            entityManager.getTransaction().commit();
        }catch (Exception e) {}
        finally {
            entityManager.close();
        }
    }

    @Override
    public void eliminarDespacho(Despacho despacho) {
        try	{
            entityManager.getTransaction().begin();
            Query query = entityManager.createQuery("delete from Despacho where idDespacho = :id");
            query.setParameter("id", despacho.getIdDespacho());
            int deletedRows = query.executeUpdate();
            if (deletedRows != 0)
                entityManager.getTransaction().commit();
        }catch (Exception e) {}
        finally {
            entityManager.close();
        }
    }

    @Override
    public List<Despacho> listarDespachos() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Despacho> CriteriaQuery = criteriaBuilder.createQuery(Despacho.class);
        Root<Despacho> despachoFormaRoot= CriteriaQuery.from(Despacho.class);
        CriteriaQuery.select(despachoFormaRoot);
        return entityManager.createQuery(CriteriaQuery).getResultList();
    }

    @Override
    public Despacho buscarDespachoById(Integer idDespacho){
        Query query = entityManager.createQuery("Select dp From Despacho dp where dp.idDespacho= :id");
        query.setParameter("id", idDespacho);
        Despacho despacho = (Despacho) query.getSingleResult();
        return despacho;
    }
}
