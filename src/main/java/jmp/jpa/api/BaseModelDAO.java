package jmp.jpa.api;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * Created by Nona_Sarokina on 11/8/2016.
 */
public abstract class BaseModelDAO<T> implements IBaseModelDAO<T>, IClosable {
    protected EntityManager entityManager;
    protected final String UNIT_NAME = "jpaModule";

    public BaseModelDAO() {
        this.entityManager = Persistence.createEntityManagerFactory(UNIT_NAME).createEntityManager();
    }

    public void create(T object) {

        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            entityManager.persist(object);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }

    }


    public T find(String id) {

        EntityTransaction transaction = entityManager.getTransaction();

        T object = null;
        try {
            transaction.begin();

            object = entityManager.find(getTypeClass(), id);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            return object;
        }

    }

    public void delete(String id) {
        T object = entityManager.find(getTypeClass(), id);

        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.remove(object);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
    }

    public T update(String id, T object) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            return object;
        }

    }

    protected abstract Class<T> getTypeClass();

    public void close() {
        if (entityManager.isOpen()) {
            entityManager.close();
        }
    }
}
