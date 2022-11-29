package za.co.mecer.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import za.co.mecer.modelImpl.Client;

/**
 *
 * @author Dimakatso Sebatane
 */
public interface ClientDAO {

    public String CLIENT_ERROR_MSG = "Either Your Connection Or The Payment Is Null!!!";

    public List<Client> getClients();

    void addClient(Client client);

    public void getAllClients();

    void removeClient(String identityNum);

    void changeClientAddress(String identityNum, String newAddress);

    void changeClientHomeTel(String identityNum, String newHomeTel);

    void changeClientWorkTel(String identityNum, String newWorkTel);

    void changeClientMobileTel(String identityNum, String newMobileTel);

    Client searchClient(String identityNum);

    public void displayClients();
}
