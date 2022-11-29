<%-- 
    Document   : client_reg
    Created on : Oct 23, 2022, 8:56:04 AM
    Author     : Dimakatso Sebatane
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Client Registration Page</title>
        <link rel="stylesheet" href="css/style.css">
        <script src='js/script.js'></script>
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
            <form id='form' method="POST" action='client'  >
                <h3>Client Details</h3>
                <div>
                    <label>Firstname</label>
                    <input type='text' placeholder="Enter your firstname" name='firstname'>
                </div><br>
                <div>
                    <label>Lastname</label>
                    <input type='text' placeholder="Enter your lastname" name='lastname'>
                </div><br>
                <div>
                    <label>Identity Number</label>
                    <input type='text' placeholder="Enter your identity number" name='identityNum' minlength="13" maxlength="13">
                </div><br>
                <div>
                    <label>Home Address</label>
                    <input type='text' placeholder="Enter your home address" name='homeAddress'>
                </div><br>
                <div>
                    <label>Home Telephone</label>
                    <input type='tel' name='homeTel' placeholder="Enter your home telephole number" minlength="10" maxlength="10">
                </div><br>
                <div>
                    <label>Work Telephone</label>
                    <input type='tel' name='workTel' placeholder="Enter your work telephone number" minlength="10" maxlength="10">
                </div><br>
                <div>
                    <label>Mobile Telephone</label>
                    <input  type='tel' name='mobileTel' placeholder="Enter your firstname" minlength="10" maxlength="10">
                </div><br>
                <div>
                    <input type='submit' name='registerClient' value='Register Client'>
                    <input type='button' name='registerClient' value='Registered Client' onclick="registeredClient()">
                </div>

            </form>
        </div>
    </body>
</html>
