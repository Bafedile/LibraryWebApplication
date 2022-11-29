<%-- 
    Document   : clients_list
    Created on : Oct 27, 2022, 8:12:16 PM
    Author     : Dimakatso Sebatane
--%>

<%@page import="za.co.mecer.modelImpl.Client"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Clients List Page</title>
        <link rel="stylesheet" href="css/style.css">
    </head>
    <body>
        <h1 align='center' id='books_table'>Clients </h1>
        <table>
            <tr>
                <th>Client ID</th>
                <th>Firstname</th>
                <th>Lastname</th>
                <th>Identity Number</th>
                <th>Home Address</th>
                <th>Home Tel</th>
                <th>Work Tel</th>
                <th>Mobile Tel</th>
            </tr>
            <%
//                List<Client> clients = (List<Client>) request.getAttribute("clients");
                String cli = request.getParameter("clients");
                out.println(cli);
                String[] clients = cli.split(",");
                if (clients != null) {
                    for (String client : clients) {
                        String[] c = client.split(";");
                        out.println(String.format("<tr>"));

                        for (int i = 0; i < c.length; i++) {
                            out.println(String.format("<td>%S</td>",c[i]));
                        }
                        out.println("</tr>");
                    }
//                    for (Client client : clients) {
//                        out.println(String.format("<tr>"
//                                + "<td>%S<td>"
//                                + "<td>%S<td>"
//                                + "<td>%s<td>"
//                                + "<td>%S<td>"
//                                + "<td>%S<td>"
//                                + "<td>%S<td>"
//                                + "<td>%S<td>"
//                                + "</tr>", client.getFirstName(), client.getLastName(), client.getIdentityNum(), client.getAddress(),
//                                 client.getHomeTel(), client.getWorkTel(), client.getMobileTel()));
//                    }
                }
            %>
        </table>
    </body>
</html>
