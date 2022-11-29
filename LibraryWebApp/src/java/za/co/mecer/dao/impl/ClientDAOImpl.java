package za.co.mecer.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import za.co.mecer.exceptions.ClientException;
import za.co.mecer.dao.ClientDAO;
import za.co.mecer.dao.ClosingDAO;
import za.co.mecer.dbconnection.DatabaseConnection;
import za.co.mecer.modelImpl.Client;

/**
 *
 * @author Dimakatso Sebatane
 */
public class ClientDAOImpl implements ClientDAO, ClosingDAO {

    private PreparedStatement preparedStatement = null;
    private Connection conn = null;
    private ResultSet result = null;
    private List<Client> clients = new ArrayList<>();

    /**
     *
     * @param conn
     */
    public ClientDAOImpl() {
        this.conn = DatabaseConnection.getInstance().getConnection();
    }

    /**
     *
     * @param client
     */
    @Override
    public void addClient(Client client) {
        /**
         * <<Client Fields>> firstname, lastname, identity, address, hometel, worktel,mobiletel
         */
        try {
            if (conn != null) {
                preparedStatement = conn.prepareStatement("INSERT INTO client (firstname,lastname,identitynum,address,"
                        + " hometel, worktel, mobiletel) VALUES"
                        + "(?,?,?,?,?,?,?)");
                preparedStatement.setString(1, client.getFirstName());
                preparedStatement.setString(2, client.getLastName());
                preparedStatement.setString(3, client.getIdentityNum());
                preparedStatement.setString(4, client.getAddress());
                preparedStatement.setString(5, client.getHomeTel());
                preparedStatement.setString(6, client.getWorkTel());
                preparedStatement.setString(7, client.getMobileTel());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException se) {
            System.err.println("Error " + se.getMessage());
        } finally {
            close(preparedStatement, result);

        }
    }

    /**
     *
     * @param identityNum
     */
    @Override
    public void removeClient(String identityNum) {
        try {
            if (conn != null) {
                preparedStatement = conn.prepareStatement("DELETE FROM client WHERE identitynum = ?");
                preparedStatement.setString(1, identityNum);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException se) {
            System.err.println("Error " + se.getMessage());
        } finally {
            close(preparedStatement, result);

        }
    }

    /**
     *
     * @param identityNum
     * @param newAddress
     */
    @Override
    public void changeClientAddress(String identityNum, String newAddress) {
        try {
            if (conn != null) {
                preparedStatement = conn.prepareStatement("UPDATE client SET address=?  WHERE identitynum = ?");
                preparedStatement.setString(1, newAddress);
                preparedStatement.setString(2, identityNum);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException se) {
            System.err.println("Error " + se.getMessage());
        } finally {
            close(preparedStatement, result);

        }
    }

    /**
     *
     * @param identityNum
     * @param newHomeTel
     */
    @Override
    public void changeClientHomeTel(String identityNum, String newHomeTel) {
        try {
            if (conn != null) {

                preparedStatement = conn.prepareStatement("UPDATE client SET hometel=?  WHERE identitynum = ?");
                preparedStatement.setString(1, newHomeTel);
                preparedStatement.setString(2, identityNum);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException se) {
            System.err.println("Error " + se.getMessage());
        } finally {
            close(preparedStatement, result);

        }
    }

    /**
     *
     * @param identityNum
     * @param newWorkTel
     */
    @Override
    public void changeClientWorkTel(String identityNum, String newWorkTel) {
        try {
            if (conn != null) {
                preparedStatement = conn.prepareStatement("UPDATE client SET workTel=?  WHERE identitynum = ?");
                preparedStatement.setString(1, newWorkTel);
                preparedStatement.setString(2, identityNum);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException se) {
            System.err.println("Error " + se.getMessage());
        } finally {
            close(preparedStatement, result);
        }
    }

    /**
     *
     * @param identityNum
     * @param newMobileTel
     */
    @Override
    public void changeClientMobileTel(String identityNum, String newMobileTel) {
        try {
            if (conn != null) {
                preparedStatement = conn.prepareStatement("UPDATE client SET mobiletel=?  WHERE identitynum = ?");
                preparedStatement.setString(1, newMobileTel);
                preparedStatement.setString(2, identityNum);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException se) {
            System.err.println("Error " + se.getMessage());
        } finally {
            close(preparedStatement, result);
        }
    }

    /**
     *
     * @param identityNum
     * @return
     */
    @Override
    public Client searchClient(String identityNum
    ) {
        Client client = null;
        clients.clear();
        try {
            if (conn != null) {
                preparedStatement = conn.prepareStatement("SELECT * FROM client WHERE identitynum =?");
                preparedStatement.setString(1, identityNum);
                result = preparedStatement.executeQuery();
                while (result.next()) {
                    client = new Client(result.getInt("client_id"), result.getString("firstname"), result.getString("lastname"),
                            result.getString("identityNum"), result.getString("address"), result.getString("hometel"), result.getString("worktel"),
                            result.getString("mobiletel"));
                    clients.add(client);
                }
            }
        } catch (SQLException | ClientException se) {
            System.err.println("Error " + se.getMessage());
        } finally {
            close(preparedStatement, result);
        }
        return client;
    }

    /**
     * Gets all the clients in the database
     */
    @Override
    public void getAllClients() {
        Client client;
        clients.clear();
        try {
            if (conn != null) {
                preparedStatement = conn.prepareStatement("SELECT * FROM client ");
                result = preparedStatement.executeQuery();

                while (result.next()) {
                    client = new Client(result.getInt("client_id"), result.getString("firstname"), result.getString("lastname"),
                            result.getString("identityNum"), result.getString("address"), result.getString("hometel"), result.getString("worktel"),
                            result.getString("mobiletel"));
                    clients.add(client);
                }
            }
        } catch (SQLException | ClientException se) {
            System.err.println("Error " + se.getMessage());
        } finally {
            close(preparedStatement, result);
        }
    }

    @Override
    public List<Client> getClients() {
        getAllClients();
        return clients;
    }

    /**
     * Displays all the clients
     *
     */
    @Override
    public void displayClients() {
        clients.forEach((client) -> System.out.println(client));
    }

}
