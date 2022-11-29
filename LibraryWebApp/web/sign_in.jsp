<%-- 
    Document   : sign_in
    Created on : Oct 22, 2022, 9:57:59 PM
    Author     : Dimakatso Sebatane
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sign In Page</title>
        <link rel="stylesheet" href='css/style.css'>
    </head>
    <header>
            <h1 align='center'>DM LIBRARY</h1>
        </header>

        <div align='center'>
            <form  id='form' method="POST" action="books">
                <h3>Sign In</h3>
                <div>
                    <label>Username</label>
                    <input type="text" name="username">
                </div><br>
                <div>
                    <label>Password</label>
                    <input type="password" name="password">
                </div><br>
                <div>
                    <input type="submit" name="sign_in" value="SignIn"><br>
                    <a href="signUp">Don't have an account? Sign up</a>
                </div>


            </form>
        </div>
</html>
