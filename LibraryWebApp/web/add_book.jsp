<%-- 
    Document   : add_book
    Created on : 24 Oct 2022, 1:35:22 PM
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
            <form id='form' method="POST"   action="books">
                <h3>Adding A Book</h3>

                <div>
                    <label>Book Author</label>
                    <input type='text' placeholder="Enter book author" name='author'>
                </div><br>
                <div>
                    <label>Book Title</label>
                    <input type='text' placeholder="Enter book title" name='title'>
                </div><br>
                <div>
                    <label>Book ISBN Number</label>
                    <input type='text' placeholder="Enter book ISBN number" name='isbn' minlength="13" maxlength="13">
                </div><br>
                
                <div>
                    <label>Book Availability</label>
                    <select>
                        <option name="available" value="true">true</option>
                        <option name="available" value="true">false</option>
                    </select>
                </div><br>
                <div>
                    <label>Book Borrowable</label>
                    <select>
                        <option name="borrowable" value="true">true</option>
                        <option name="borrowable" value="true">false</option>
                    </select>
                </div><br>
                
                
                <div>
                    <input type='submit' name='submit' value='Add book'>
                    <input type='button' name='back' value='Back to library' onclick='goToHome()'>
                </div>
            </form>
        </div>
    </body>
</html>
