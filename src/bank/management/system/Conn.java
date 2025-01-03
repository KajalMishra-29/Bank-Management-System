package bank.management.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.io.InputStream;
import java.io.IOException;

public class Conn {
    Connection connection;
    Statement statement;
    Conn() throws IOException, SQLException {
        Properties properties = new Properties();
        try(InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties")){
            if(input == null){
                System.out.println("Sorry, unable to find config.properties");
                return;
            }
            // Load the properties file
            properties.load(input);

            // get values
            String dbUrl = properties.getProperty("db.url");
            String dbUsername = properties.getProperty("db.username");
            String dbPassword = properties.getProperty("db.password");

            // forming connection
            connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
            statement = connection.createStatement();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}