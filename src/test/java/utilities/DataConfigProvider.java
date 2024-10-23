package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class DataConfigProvider {

    Properties properties;


    public DataConfigProvider() {
        String fileName = System.getProperty("user.dir") + "/Configurations/configuration.properties";

        try {
            File src = new File(fileName);
            properties = new Properties();
            FileInputStream fis = new FileInputStream(src);
            properties.load(fis);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
        public String getBrowser(){
            return properties.getProperty("browser");

        }

        public String getURL(){
            return properties.getProperty("url");
        }



}
