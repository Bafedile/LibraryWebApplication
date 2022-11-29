package za.co.mecer.process;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import za.co.mecer.exceptions.ClientException;
import za.co.mecer.modelImpl.Client;
import za.co.mecer.serviceimpl.ClientServiceImpl;
import za.co.mecer.services.ClientService;

/**
 *
 * @author Dimakatso Sebatane
 */
public class ClientsLibraryProcess {

    public void processClient(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        checkExistingClient(request, response);
    }

    public void checkExistingClient(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName, lastName, identityNum, mobileTel, workTel, homeTel, address;
        ClientService clientService = new ClientServiceImpl();
        Client client;
        RequestDispatcher dispatcher = request.getRequestDispatcher("loan");
        if (request.getParameter("registerClient").equalsIgnoreCase("loan book")) {
            client = clientService.getClient(request.getParameter("identityNum"));
            if (client != null) {
                request.setAttribute("client", client);
                request.setAttribute("identityNum", request.getParameter("identityNum"));
                dispatcher.forward(request, response);
            } else {
                dispatcher = request.getRequestDispatcher("registerClient");
                request.setAttribute("error", "Client does not exist, register client");
                dispatcher.forward(request, response);
            }
        } else if (request.getParameter("registerClient").equalsIgnoreCase("register client")) {
            firstName = request.getParameter("firstname");
            lastName = request.getParameter("lastname");
            identityNum = request.getParameter("identityNum");
            address = request.getParameter("homeAddress");
            homeTel = request.getParameter("homeTel");
            workTel = request.getParameter("workTel");
            mobileTel = request.getParameter("mobileTel");
            if ((firstName == null || firstName.isEmpty()) && (lastName == null || lastName.isEmpty())
                    && (identityNum == null || identityNum.isEmpty()) && (homeTel == null || homeTel.isEmpty())) {
                request.setAttribute("error", "firstname,lastname,identity and home tel can not be null");
                dispatcher.forward(request, response);
            } else {
                try {
                    client = new Client(firstName, lastName, identityNum, address, homeTel, workTel, mobileTel);
                    clientService.addClient(client);
                    response.sendRedirect("registeredClient");
                } catch (ClientException ex) {

                }
            }
        }
    }
}
