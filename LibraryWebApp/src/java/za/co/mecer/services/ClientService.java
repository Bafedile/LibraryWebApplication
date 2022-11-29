package za.co.mecer.services;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import za.co.mecer.exceptions.ClientException;
import za.co.mecer.modelImpl.Client;

/**
 *
 * @author Dimakatso Sebatane
 */
public interface ClientService {

    public Client getClient(String identityNum);

    public void addClient(Client client);

    public List<Client> getClients();
}
