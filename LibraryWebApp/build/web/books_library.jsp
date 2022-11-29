<%-- 
    Document   : books_library
    Created on : Oct 22, 2022, 10:03:52 PM
    Author     : Dimakatso Sebatane
--%>

<%@page import="za.co.mecer.modelImpl.AuthorBook"%>
<%@page import="za.co.mecer.modelImpl.Author"%>
<%@page import="java.util.List"%>
<%@page import="za.co.mecer.modelImpl.Book"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Books Page</title>
        <link rel="stylesheet" href='css/style.css'>
        <script src='js/script.js'></script>
    </head>

    <body>
        <header>
            <nav class="top_nav">
                <ul>
                    <li><a href='slideshow' >Home</a><li>
                    <li><a href='signUp' >SignUp</a><li>
                    <li><a href='signIn'>SignIn</a><li>
                    <li><a href='books' class="active">Book Library</a><li>
                </ul>
            </nav>
            <h1 align='center'>DM LIBRARY</h1>
        </header>
        <h1 align='center'>Available Books</h1>
        <div>
            <table align='center' id='books_table'>
                <tr>
                    <td><strong>Author</strong></td>
                    <td><strong>Book Title</strong></td>
                </tr>
                <%
                    List<AuthorBook> bookList = (List<AuthorBook>) request.getAttribute("books");
                    for (AuthorBook book : bookList) {
                        out.println(String.format("<tr><td>%s</td><td>%s</td></tr>", book.getAuthor().getName(), book.getBook().getTitle()));
                    }
                %>
            </table>
        </div>
        <div id="btn" align='right'>
            <input align='left' type='button' onclick='loanBook()'  value='Loan a book'>
            <input align='center' type='button' onclick='manageBooks()'  value='Manage books' id='btnManage' >
            <input align='right' type='button' onclick='manageClients()'  value='Manage clients' id='btnManage' >
        </div>
    </body>
</html>
