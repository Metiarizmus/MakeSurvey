
import Enums.PersonRole;
import Logger.Log;
import Modeles.*;

import Report.Copy;
import Repository.UserRepository;
import Services.UserServJDBC;
import Services.interfaces.PropertyInf;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws IOException, SQLException {

        Log log = new Log();

        UserRepository userRepository = new UserRepository();

        UserServJDBC userServJDBC = new UserServJDBC();
        //log.addLog("add Users");
        userRepository.saveUser(new Admin("Nastya"),"19.03.2015 13:15:43");
        userRepository.saveUser(new Admin("Nastya3"));
        userRepository.saveUser(new Manager("Reinhart"));
        userRepository.saveUser(new Worker("Nikolas"));
        userRepository.saveUser(new Worker("Alex"));
        userRepository.saveUser(new Manager("Polina"));
        userRepository.saveUser(new Admin("Max"),"01.01.2019 23:59:48");
        userRepository.saveUser(new Worker("Soda"));

        //log.addLog("get list Users");

        for (int i = 1; i < userRepository.findUsers().size(); i++) {
            userServJDBC.addInDB(userRepository.findUsers().get(i));
        }





    }
}

