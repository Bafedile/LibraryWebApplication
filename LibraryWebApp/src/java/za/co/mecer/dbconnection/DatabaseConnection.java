package za.co.mecer.dbconnection;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author Dimakatso Sebatane
 */
public class DatabaseConnection {

    private static DatabaseConnection dbConn = null;
    private static PreparedStatement preparedStatement = null;
    private static Connection conn = null;
    private static String database = "library_system_db";

    private DatabaseConnection() throws SQLException {
        connect();
    }

    static {
        try {
            dbConn = new DatabaseConnection();
        } catch (SQLException ex) {
            System.out.printf("Error: %s%n", ex.getMessage());
        }
    }

    public static DatabaseConnection getInstance() {
        return dbConn;
    }

    private static void connect() {
        String user, url, pass;
        try (InputStream stream = new FileInputStream("G:\\JavaSkillTrainingProjects\\Java Ant Projects\\Java_Enterprise_Project\\LibraryWebApp\\database.properties")) {
            Properties properties = new Properties();
            properties.load(stream);
            url = properties.getProperty("url");
            user = properties.getProperty("username");
            pass = properties.getProperty("password");

            conn = DriverManager.getConnection(url, user, pass);
            createDatabase(conn);

        } catch (IOException | SQLException iox) {
            System.out.printf("Error: %s%n", iox.getMessage());
        }
    }

    private static void createDatabase(Connection conn) throws SQLException {

        if (conn != null) {
            conn.prepareStatement("CREATE DATABASE  IF NOT EXISTS library_system_db;").executeUpdate();
            conn.prepareStatement("USE " + database).executeUpdate();
            conn.prepareStatement("CREATE TABLE  IF NOT EXISTS client (client_id INT AUTO_INCREMENT PRIMARY KEY, firstname VARCHAR(30) NOT NULL,\n"
                    + "lastname VARCHAR(30) NOT NULL, identityNum VARCHAR(13), address VARCHAR(255), homeTel VARCHAR(10) NOT NULL, workTel VARCHAR(10),\n"
                    + "mobileTel VARCHAR(10));").executeUpdate();

            conn.prepareStatement("CREATE TABLE IF NOT EXISTS book (book_id INT AUTO_INCREMENT  UNIQUE, isbn VARCHAR(13) NOT NULL, title VARCHAR(45), \n"
                    + "available BOOLEAN , borrowable BOOLEAN,PRIMARY KEY(isbn,title) );").executeUpdate();

            conn.prepareStatement("CREATE  TABLE IF NOT EXISTS loan (loan_id INT AUTO_INCREMENT UNIQUE, client_id INT NOT NULL,book_id INT, borrowedDate DATE NOT NULL,\n"
                    + "returnDate DATE NOT NULL, fine DECIMAL(5,2),PRIMARY KEY(client_id,book_id), FOREIGN KEY (client_id) REFERENCES client(client_id),FOREIGN KEY(book_id) REFERENCES \n"
                    + "book (book_id));").executeUpdate();

            conn.prepareStatement("CREATE TABLE IF NOT EXISTS payment (payment_id INT AUTO_INCREMENT PRIMARY KEY, loan_id INT NOT NULL, amount DECIMAL(5,2) DEFAULT 0.0,\n"
                    + "FOREIGN KEY (loan_id) REFERENCES loan(loan_id));").executeUpdate();
            conn.prepareStatement("CREATE TABLE IF NOT EXISTS author(author_id INT AUTO_INCREMENT PRIMARY KEY , name VARCHAR(30) NOT NULL);").executeUpdate();
            conn.prepareStatement("CREATE TABLE IF NOT EXISTS author_book(author_id INT NOT NULL, book_id INT NOT NULL, \n"
                    + "FOREIGN KEY(book_id) REFERENCES book(book_id), FOREIGN KEY(author_id) REFERENCES author(author_id), PRIMARY KEY(author_id,book_id));").executeUpdate();
            //conn.prepareStatement("USE " + database).executeUpdate();
        }

    }

    public Connection getConnection() {
        connect();
        return conn;
    }

}
