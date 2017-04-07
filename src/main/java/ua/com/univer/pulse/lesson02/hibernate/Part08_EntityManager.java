package ua.com.univer.pulse.lesson02.hibernate;

import org.hibernate.SessionFactory;
import ua.com.univer.pulse.lesson02.hibernate.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 * 2-й способ работы с hibernate - это EntityManager (работать с ним проще чем SessionFactory)
 * EntityManager появился позже
 *
 * SessionFactory - это 1-й (старый) способ работы с hibernate
 *
 * Одно из преимуществ - нет описания классов (у нас это User) в persistence.xml, как это было сделано в hibernate.cfg.xml
 */
public class Part08_EntityManager {

    public static void main(String[] args) {

        /**
         * Конфигурационный файл persistence.xml обязательно должен находится в папке \src\main\resources\META-INF\
         * аргумент persistenceUnitName в методе createEntityManagerFactory должен совпадать с persistence-unit name в файле persistence.xml
         */
        SessionFactory sessionFactory =
                (SessionFactory) Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");

        EntityManager entityManager = sessionFactory.createEntityManager();

        // Begin transaction
        entityManager.getTransaction().begin();

        User user = new User();
        user.setName("petya");
        user.setLastName("pupkin");

        entityManager.persist(user);

        // Commit transaction
        entityManager.getTransaction().commit();

        entityManager.close();
        sessionFactory.close();
    }
}
