package ua.com.univer.pulse.lesson02.dao;

/**
 * Created by IShklyar on 06.04.2017.
 */
public class UserDTO {
    Long id;
    String name;

    public UserDTO() {
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
}
