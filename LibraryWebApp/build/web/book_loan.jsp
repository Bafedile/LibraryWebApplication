<%-- 
    Document   : book_loan
    Created on : Oct 23, 2022, 10:51:23 AM
    Author     : Dimakatso Sebatane
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Book Loan Page</title>
        <script src='js/script.js'></script>
        <link rel="stylesheet" href="css/style.css">
    </head>
    <body>
        <%
            String clientIdentityNum = (String) request.getAttribute("identityNum");
            request.setAttribute("clientIdentityNum", clientIdentityNum);
        %>
        <header>
            <nav class="top_nav">
                <ul>
                    <li><a href='slideshow' >Home</a><li>
                    <li><a href='books'>Book Library</a><li>
                </ul>
            </nav>
            <h1 align='center'>DM LIBRARY</h1>
        </header>
        <div  align='center'>
            <form id='form' method="POST" action='loan'  >
                <h3>Book Loan</h3>

                <div>
                    <label>Book Author</label>
                    <input type='text' placeholder="Enter book author" name='author'>
                </div><br>
                <div>
                    <label>Book Title</label>
                    <input type='text' placeholder="Enter book title" name='bookTitle'>
                </div><br>
                <div>
                    <label>Book ISBN Number</label>
                    <input type='text' placeholder="Enter book ISBN number" name='isbn' minlength="13" maxlength="13">
                </div><br>
                <div>
                    <input type='submit' name='submit' value='Loan book'>
                    <input type='button' name='back' value='Back to library' onclick="goToHome()">
                </div>
            </form>
        </div>
    </body>
</html>
