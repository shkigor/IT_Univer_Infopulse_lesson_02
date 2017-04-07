package ua.com.univer.pulse.lesson02.dao;

/**
 * DAO это сочетание фабрики и синглтона.
 * Обычно UserDAO - это синглтоны.
 */
public class Part06_DAOFactory {
    private static Part06_DAOFactory instance;

    UserDAO userDAO = new UserDAOImpl();

    private Part06_DAOFactory() {
    }

    public synchronized static Part06_DAOFactory getInstance() {
        if (instance == null) {
            instance = new Part06_DAOFactory();
        }
        return instance;
    }

    public UserDAO getUserDAO() {
        return userDAO;
    }
}
