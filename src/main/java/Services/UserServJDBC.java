package Services;

import Enums.PersonRole;
import Modeles.Admin;
import Modeles.Manager;
import Modeles.Person;
import Modeles.Worker;
import Repository.UserRepository;
import Services.interfaces.IUserService;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserServJDBC extends DAOFactory implements IUserService {

    private static final String SELECT_ALL = "SELECT * FROM person";
    private static final String SELECT_ROLE = "SELECT * FROM person WHERE role=?";
    private static final String SELECT_ID = "SELECT * FROM person WHERE id=?";
    private static final String SELECT_ROLE_BY_ID = "SELECT id FROM person WHERE role=?";
    private static final String INSERT = "INSERT INTO person(id,name,role) VALUES (?,?,?)";


    public void addInDB(Person person) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = getConnection();
            statement = connection.prepareStatement(INSERT);

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
    }

    @Override
    public List<Person> findAllUsers() {
        List<Person> list = new ArrayList<>();

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet result = null;

        try {
            connection = getConnection();
            statement = connection.prepareStatement(SELECT_ALL);
            result = statement.executeQuery();

            while (result.next()){
                Person person = new Worker(PersonRole.ADMIN);
                person.setId(result.getInt("id"));
                person.setName(result.getString("name"));
                person.setRole(PersonRole.valueOf(result.getString("role")));
                list.add(person);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
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
            connection = getConnection();
            statement = connection.prepareStatement(SELECT_ROLE);
            statement.setString(1, String.valueOf(role));
            result = statement.executeQuery();

            while (result.next()){

                if(role == PersonRole.ADMIN){
                    Person admin = new Admin();
                    admin.setId(result.getInt("id"));
                    admin.setName(result.getString("name"));
                    admin.setRole(PersonRole.ADMIN);
                    list.add(admin);
                }

                if(role == PersonRole.WORKER){
                    Person worker = new Worker();
                    worker.setId(result.getInt("id"));
                    worker.setName(result.getString("name"));
                    worker.setRole(PersonRole.WORKER);
                    list.add(worker);
                }

                if(role == PersonRole.MANAGER){
                    Person manager = new Manager();
                    manager.setId(result.getInt("id"));
                    manager.setName(result.getString("name"));
                    manager.setRole(PersonRole.MANAGER);
                    list.add(manager);
                }

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
            connection = getConnection();
            statement = connection.prepareStatement(SELECT_ID);
            statement.setInt(1, id);
            result = statement.executeQuery();

            while (result.next()){

                Person person = new Admin();
                person.setId(result.getInt("id"));
                person.setName(result.getString("name"));
                person.setRole(PersonRole.valueOf(result.getString("role")));
                list.add(person);

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
            connection = getConnection();
            statement = connection.prepareStatement(SELECT_ROLE_BY_ID);
            statement.setString(1, String.valueOf(role));
            result = statement.executeQuery();

            while (result.next()){
                if(role == PersonRole.ADMIN){

                    list.add(result.getInt("id"));
                }

                if(role == PersonRole.WORKER){
                    list.add(result.getInt("id"));
                }

                if(role == PersonRole.MANAGER){
                    list.add(result.getInt("id"));
                }

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
            connection = getConnection();
            statement = connection.prepareStatement(INSERT);

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


}
