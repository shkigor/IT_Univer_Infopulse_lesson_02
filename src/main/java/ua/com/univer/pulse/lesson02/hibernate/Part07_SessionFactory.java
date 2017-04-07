package ua.com.univer.pulse.lesson02.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import ua.com.univer.pulse.lesson02.hibernate.entity.User;

import java.io.File;

/**
 * Java Persistence API (JPA) — спецификация API Java EE, предоставляет возможность сохранять в удобном виде Java-объекты в базе данных.
 * Существует несколько реализаций этого интерфейса, одна из самых популярных использует для этого Hibernate. JPA реализует концепцию ORM.
 * JPA - это набор интерфейсов.
 * Есть два подхода для работы с БД. 1 - это JPA, 2 - хранимые процедуры.
 *
 * В ActiveRecords сущность сама сохраняет себя в БД. ActiveRecords присуща Ruby, Grails.
 * Java ограничена в генерации методов.
 * в ORM такого нет - сущность нужно самим сохранить.
 *
 */
public class Part07_SessionFactory {
    public static void main(String[] args) {

        SessionFactory sessionFactory = null;

        /**
        StandardServiceRegistry - это фабрика.
        StandardServiceRegistry считывает все данные конфига, где описаны все параметры коннекта к БД.
        Сюда мы передаем конфигурацию для hibernate
        В основе hibernate лежит JDBC. Поэтому мы должны передать имя БД, порт, логин, пароль и т.д.
         */
        final StandardServiceRegistry registry =
                new StandardServiceRegistryBuilder()
                        .configure(new File("src/main/resources/hibernate.cfg.xml")) // configures settings from hibernate.cfg.xml
                        .build();

        /**
         * MetadataSources создает пул соединений и в них закладывает несколько соединений
         * sessionFactory запускает все скрипты создания БД, если выставлена опция
         * в hibernate уже есть встроенный пул
         */
        sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();

        /**
         * Из пула достается Connection, который обернут в сессию.
         */
        Session session = sessionFactory.openSession();

        session.beginTransaction();

        User user = new User();
        user.setName("Инна");
        user.setLastName("Шкляр");

        /**
         * Формируется INSERT запрос согласно диалекта БД
         */
        session.save(user);

        session.getTransaction().commit();


        session.close();
        sessionFactory.close();
    }
}
