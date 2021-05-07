package Services;

import Services.interfaces.PropertyInf;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAOFactory {

    private static DAOFactory daoFactory;

    private DAOFactory() {

    }

    public static DAOFactory getDaoFactory(){
        if(daoFactory == null) {
            daoFactory = new DAOFactory();
        }
        return daoFactory;
    }

    public Connection getConnection() {
        Connection connection = null;
        PropertyInf inf = new PropertyInf();
        try {
            String URL = inf.getConnectData().getProperty("URL");
            String LOGIN = inf.getConnectData().getProperty("LOGIN");
            String PASSWORD = inf.getConnectData().getProperty("PASSWORD");
            connection = DriverManager.getConnection(URL,LOGIN,PASSWORD);

            if (connection == null) System.err.println("null error");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.err.println("Connection error");
        }

        return connection;
    }
}
