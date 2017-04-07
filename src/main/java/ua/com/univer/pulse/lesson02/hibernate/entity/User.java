package ua.com.univer.pulse.lesson02.hibernate.entity;

import javax.persistence.*;

/**
 * Created by IShklyar on 07.04.2017.
 */
@Entity // Можно и здесь указать имя таблицы, к которой мы привязываем сущность
@Table(name = "myusers")
public class User {

    @Id
    // Сквозная нумерация для всех таблиц. Например, вставляем в первуб таблицу - будет 1.
    // Вставляем запись в другую таблицу - значение будет не 1, а 2.
    @GeneratedValue
    Long id;

    @Column(name = "firstname")
    String name;

    @Column(name = "lastname")
    String lastName;

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
