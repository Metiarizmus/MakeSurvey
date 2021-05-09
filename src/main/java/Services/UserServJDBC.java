package Services;

import Enums.PersonRole;
import Modeles.*;
import Services.interfaces.IUserService;
import Services.interfaces.PropertyInf;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserServJDBC  implements IUserService {

    private PropertyInf propertyInf = new PropertyInf();

    Connection daoFactory = DAOFactory.getInstance().getConnection();

    public UserServJDBC() throws SQLException {
    }

    public void addInDB(Person person) {

        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = daoFactory;
            statement = connection.prepareStatement(propertyInf.getSqlQuery().getProperty("INSERT_TEST"));

           String[] s = new String[]{null,String.valueOf(person.getId()),person.getName(), String.valueOf(person.getRole())};

            for (int i = 1; i <=s.length-1; i++) {
                statement.setString(i, String.valueOf(s[i]));
            }



            statement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }

    @Override
    public List<Person> findAllUsers() {
        List<Person> list = new ArrayList<>();

        Connection connection;
        PreparedStatement statement;
        ResultSet result;

        try {
            connection =  daoFactory;
            statement = connection.prepareStatement(propertyInf.getSqlQuery().getProperty("SELECT_ALL"));
            result = statement.executeQuery();

            while (result.next()){
                list.add(getInfByPerson(result));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        if (list.isEmpty()){
            System.err.println("list is null");
        }

        return list;
    }

    @Override
    public List<Person> findUsersByRole(PersonRole role) {
        List<Person> list = new ArrayList<>();

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet result = null;

        try {
            connection =  daoFactory;
            statement = connection.prepareStatement(propertyInf.getSqlQuery().getProperty("SELECT_ROLE"));
            statement.setString(1, String.valueOf(role));
            result = statement.executeQuery();

            while (result.next()){
                list.add(getInfByPerson(result));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            if(result != null){
                try {
                    result.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if(statement!= null) {
                try {
                    statement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if(connection != null){
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        return list;
    }

    @Override
    public List<Person> findUserById(int id) {
        List<Person> list = new ArrayList<>();

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet result = null;

        try {
            connection =  daoFactory;
            statement = connection.prepareStatement(propertyInf.getSqlQuery().getProperty("SELECT_ID"));
            statement.setInt(1, id);
            result = statement.executeQuery();

            while (result.next()){
                list.add(getInfByPerson(result));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            if(result != null){
                try {
                    result.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if(statement!= null) {
                try {
                    statement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if(connection != null){
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        return list;
    }

    @Override
    public List<Integer> findIdsByRole(PersonRole role) {
        List<Integer> list = new ArrayList<>();

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet result = null;

        try {
            connection =  daoFactory;
            statement = connection.prepareStatement(propertyInf.getSqlQuery().getProperty("SELECT_ROLE_BY_ID"));
            statement.setString(1, String.valueOf(role));
            result = statement.executeQuery();

            while (result.next()){
                list.add(result.getInt("id"));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            if(result != null){
                try {
                    result.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if(statement!= null) {
                try {
                    statement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if(connection != null){
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        return list;
    }

    @Override
    public boolean saveUser(Person person) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection =  daoFactory;
            statement = connection.prepareStatement(propertyInf.getSqlQuery().getProperty("INSERT"));

            statement.setInt(1, person.getId());
            statement.setString(2, person.getName());
            statement.setString(3, String.valueOf(person.getRole()));

            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }

        return false;
    }

    @Override
    public boolean removeUser(Person role) {
        return false;
    }

    @Override
    public boolean removeUser(int id) {
        return false;
    }

    private Person getInfByPerson(ResultSet result) throws SQLException {
        Person person = new Worker(PersonRole.MANAGER);
        person.setId(result.getInt("id"));
        person.setName(result.getString("name"));
        person.setRole(PersonRole.valueOf(result.getString("role")));
        return person;
    }
}
