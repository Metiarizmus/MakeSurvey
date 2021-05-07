package Services.interfaces;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyInf {

    public Properties getConnectData() {
        FileInputStream fis;
        Properties property = new Properties();
        try {
            fis = new FileInputStream("src/main/resources/config.properties");
            property.load(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return property;
    }

    public Properties getSqlQuery() {
        FileInputStream fis;
        Properties property = new Properties();
        try {
            fis = new FileInputStream("C:\\Users\\Николай\\IdeaProjects\\Survey\\src\\main\\resources\\sql.properties");
            property.load(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return property;
    }
}
