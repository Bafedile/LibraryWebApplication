<%-- 
    Document   : testing
    Created on : Oct 27, 2022, 4:39:41 PM
    Author     : Dimakatso Sebatane
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Test Page</title>
        <script src='js/script.js'></script>
        <link rel="stylesheet" href="css/style.css">
    </head>
    <body>
        <header>
            <nav class="top_nav">
                <ul>
                    <li><a href='slideshow' class="active">Home</a><li>
                    <li><a href='signUp' >SignUp</a><li>
                    <li><a href='signIn'>SignIn</a><li>
                    <li><a href='books'>Book Library</a><li>
                </ul>
            </nav>
            
            <h1  align='center'>DM LIBRARY</h1>

        </header>
        <div class="slidershow middle">
            <div class='slides '>
                <input type='radio' name='r' id='r2' checked>
                <input type='radio' name='r' id='r3'>
                <input type='radio' name='r' id='r4'>
                <input type='radio' name='r' id='r5'>
                <input type='radio' name='r' id='r6'>

                <div class="slide s1">
                    <a  href="books"><img src='assets/images/book9.jpg' alt='book'></a>
                </div>
                <div class="slide">
                    <a  href="books"> <img src='assets/images/book10.jpg' alt='book'></a>
                </div>
                <div class="slide">
                    <a  href="books"> <img src='assets/images/book4.jpg' alt='book'></a>
                </div>
                <div class="slide">
                    <a  href="books"> <img src='assets/images/book5.jpg' alt='book'></a>
                </div>
                <div class="slide">
                    <a  href="books"><img src='assets/images/book6.jpg' alt='book'></a>
                </div>


            </div>

            <div class="navigation">
                <label for='r2' class='bar'></label>
                <label for='r3' class='bar'></label>
                <label for='r4' class='bar'></label>
                <label for='r5' class='bar'></label>
                <label for='r6' class='bar'></label>
            </div>
        </div>
    </body>
</html>
