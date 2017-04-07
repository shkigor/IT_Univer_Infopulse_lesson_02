package ua.com.univer.pulse.lesson02.dao;

/**
 * Created by IShklyar on 06.04.2017.
 */
public class UserDAOImpl implements UserDAO {

    public UserDTO getUserById(Long id) {
        // Здесь формируются запросы, используя или
        // Statement, PreparedStatement, CallableStatement
        // Из ResultSet создаем экземпляр UserDTO и заполняем его данными
        return new UserDTO();
    }

    /**
     * Может возвращаться не только UserDTO, а и обычные типы
     * @param id
     * @return Имя человека
     */
    public String getName(Long id) {
        // Здесь формируются запросы, используя или
        // Statement, PreparedStatement, CallableStatement
        // Из ResultSet выбираем только одно строковое значение
        return "Petrov";
    }
}
