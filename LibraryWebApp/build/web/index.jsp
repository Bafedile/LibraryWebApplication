<%-- 
    Document   : index
    Created on : 19 Oct 2022, 11:17:23 AM
    Author     : Dimakatso Sebatane
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Library Page</title>
        <link rel="stylesheet" href='css/style.css'>
        <script src='js/script.js'></script>
        </script>
    </head>
    <body>
        <header>
            <h1 align='center'>DM LIBRARY</h1>
        </header>

        <div align='center'>
            <form  id='form' method="POST" action="signIn">
                <h3>Sign up</h3>
                <div>
                    <label>Username</label>
                    <input type="text" name="username">
                </div><br>
                <div>
                    <label>Email Address</label>
                    <input type="email" name="emai">
                </div><br>
                <div>
                    <label>Password</label>
                    <input type="password" name="password">
                </div><br>
                <div>
                    <input type="submit" name="sign_up" value="Sign up"><br>
                    <a href="signIn">Already have an account? Sign in</a>
                </div>


            </form>
        </div>
    </body>
</html>
