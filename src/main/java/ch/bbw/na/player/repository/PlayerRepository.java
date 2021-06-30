package ch.bbw.na.player.repository;

import ch.bbw.na.player.model.Entity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class PlayerRepository {
    EntityManagerFactory emfactory;
    EntityManager entityManager;

    public void setup(){
        emfactory = Persistence.createEntityManagerFactory("MyPersistanceUnit");
        entityManager = emfactory.createEntityManager();
    }

    public void closeup() {
        if ((entityManager != null) && entityManager.isOpen()) {
            entityManager.close();
        }
        if ((emfactory != null) && emfactory.isOpen()) {
            emfactory.close();
        }
    }

    @SuppressWarnings("unchecked")
    public List<Entity> getAllPlayers() {
        List<Entity> listEntities = null;
        try {
            entityManager.getTransaction().begin();
            listEntities = entityManager.createQuery("SELECT e FROM Entity e").getResultList();
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
        return listEntities;
    }

    public void createPlayer(Entity entity) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(entity);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public Entity readPlayer(int id) {
        Entity dbEntity = null;
        try {
            entityManager.getTransaction().begin();
            dbEntity =entityManager.find( Entity.class, id);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
        return dbEntity;
    }

    public void updatePlayer(Entity entity) {
        try {
            entityManager.getTransaction().begin();
            Entity dbEntity =entityManager.find( Entity.class, entity.getId());
            if (dbEntity != null) {
                entityManager.merge(entity);
            }
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void deletePlayer(int id) {
        try {
            entityManager.getTransaction().begin();
            Entity dbEntity = entityManager.find( Entity.class, id);
            if (dbEntity != null) {
                entityManager.remove(dbEntity);
            }
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
}
