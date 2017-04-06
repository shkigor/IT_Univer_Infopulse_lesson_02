package ua.com.univer.pulse.lesson02.dao;

/**
 * Created by IShklyar on 06.04.2017.
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
