<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>****</title>
</head>
<body>
    <div id="authorization-div" class="authorization-registration">
        <form id="authorization-form" action="login" method="POST">
            <label id="authorization-label">Авторизация</label> <br />
            <input name="email" id="authorization-email" placeholder="Email Address"/> <br />
            <input name="password" id="authorization-password" placeholder="Password"/> <br />
            <input type="submit" value="Login"/> <br />
            <h3>Don't have an account? </h3> <a href="/registrationPage.html">Signup</a>
        </form>
    </div>
</body>
</html>
