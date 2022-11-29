
import za.co.mecer.dbconnection.DatabaseConnection;

/**
 *
 * @author Dimakatso Sebatane
 */
public class Main {

    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        DatabaseConnection dbCon = DatabaseConnection.getInstance();
    }
}
