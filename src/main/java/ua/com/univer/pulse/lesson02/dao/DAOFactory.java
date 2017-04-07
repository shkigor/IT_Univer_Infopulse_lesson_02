package ua.com.univer.pulse.lesson02.dao;

/**
 * DAO это сочетание фабрики и синглтона.
 * Обычно UserDAO - это синглтоны.
 */
public class DAOFactory {
    private static DAOFactory instance;

    UserDAO userDAO = new UserDAOImpl();

    private DAOFactory() {
    }

    public synchronized static DAOFactory getInstance() {
        if (instance == null) {
            instance = new DAOFactory();
        }
        return instance;
    }

    public UserDAO getUserDAO() {
        return userDAO;
    }
}
