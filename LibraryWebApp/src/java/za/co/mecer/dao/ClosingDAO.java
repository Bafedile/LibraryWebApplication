package za.co.mecer.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Dimakatso Sebatane
 */
public interface ClosingDAO {

    /**
     *
     * @param preparedStatement
     * @param result
     */
    public default void close(PreparedStatement preparedStatement, ResultSet result) {
        if (preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (SQLException ex) {
                System.err.println("Error " + ex.getMessage());
            }
        }
        if (result != null) {
            try {
                result.close();
            } catch (SQLException ex) {
                System.err.println("Error " + ex.getMessage());
            }
        }
    }
}
