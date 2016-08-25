<%-- 
    Document   : index
    Created on : Aug 25, 2016, 10:56:35 AM
    Author     : salaikumar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- User Sign up page-->
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome!</title>
         <script>
             function validate_input(){
                 // Check if email id is valid;
                 var mail = document.getElementById("mail").value;
                 var c_mail = document.getElementById("c_mail").value;
                 if ( mail !==c_mail) {
                     alert("Emails don't match");
                     return false;
                 }
                 
                 
             }
         </script>
    </head>
    <body>
        <!--Sign up information for users goes to this div-->
        <div id="signupinfo" name = "signupinfo">
            <p> Welcome aboard! Please provide your details</p>
        </div>
        
        <!--Error Messages div -->
        <div id="signuperror" name="signuperror">
            <p id = "errormessage">
                <% if(request.getAttribute("errormessage") != null){ %>
                    <%=request.getAttribute("errormessage") %>
                 <% }%>
            </p>
        </div>
        
        <div id="signupform" name="signup">
            <form id="signup" action="signup" method="POST" onsubmit="return validate_input();">
                First name: 
                <input type="text" name="first_name" value="" maxlength="30" align="right" />
                <br />
                Last name: 
                <input type="text" name="last_name" value="" maxlength="30" align="left"/>
                <br />
                Email: 
                <input id="mail" type="email" name="email" value="" maxlength="30" align="left"/>
                <br />
                Confirm email: 
                <input id= "c_mail" type="email" name="c_email" value="" maxlength="30" align="left"/>
                <br />
                Password: 
                <input id= "password" type="password" name="password" value="" maxlength="30" align="left"/>
                <br />
                Confirm password: 
                <input id= "cpassword" type="password" name="cpassword" value="" maxlength="30" align="left"/>
                <br />
                <input type="submit" value="Sign Up" name="signup" />
            </form>
        </div>
    </body>
</html>
