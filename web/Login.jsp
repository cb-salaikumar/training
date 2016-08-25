<%-- 
    Document   : Login
    Created on : Aug 25, 2016, 1:13:40 PM
    Author     : salaikumar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <!--Login Page -->
        <!-- To do: Complete the Login page -->
        <div id="loginContainer" name = "loginContainter">
            <form action="login" name="loginform">
                Email: 
                <input type="text" name="email" value="" maxlength="30" />
                <br />
                Password: 
                <input type="password" name="password" value="" maxlength="30" />
                <br />
                <br />
                <input type="submit" value="Login" name="login" />
            </form>>
        </div>
    </body>
</html>
