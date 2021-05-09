package Services;

import Services.interfaces.PropertyInf;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAOFactory {

    private static DAOFactory instance;
    private  Connection connection;

    private PropertyInf inf = new PropertyInf();
    private String URL = inf.getConnectData().getProperty("URL");
    private String LOGIN = inf.getConnectData().getProperty("LOGIN");
    private String PASSWORD = inf.getConnectData().getProperty("PASSWORD");

    private DAOFactory(){
        try {
            this.connection = DriverManager.getConnection(URL,LOGIN,PASSWORD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.err.println("Connection error");
        }
    }


    public Connection getConnection() {
        return connection;
    }

    public static DAOFactory getInstance() throws SQLException {
        if (instance == null) {
            instance = new DAOFactory();
        }else {
            if (instance.getConnection().isClosed()){
                instance = new DAOFactory();
            }
        }
        return instance;
    }
}
