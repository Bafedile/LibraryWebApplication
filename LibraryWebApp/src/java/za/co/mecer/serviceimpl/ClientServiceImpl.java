package za.co.mecer.serviceimpl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;
import za.co.mecer.dao.impl.ClientDAOImpl;
import za.co.mecer.modelImpl.Client;
import za.co.mecer.services.ClientService;

/**
 *
 * @author Dimakatso Sebatane
 */
public class ClientServiceImpl implements ClientService {

    Scanner input = new Scanner(System.in);
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    ClientDAOImpl clientImpl;

    /**
     *
     * @param conn
     */
    public ClientServiceImpl() {
        this.clientImpl = new ClientDAOImpl();
    }

    @Override
    public Client getClient(String identityNum) {
        return clientImpl.searchClient(identityNum);
    }

    @Override
    public void addClient(Client client) {
        clientImpl.addClient(client);
    }

    @Override
    public List<Client> getClients() {
        return clientImpl.getClients();
    }

}
