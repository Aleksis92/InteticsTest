<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">

    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
     <title>signIn</title>
    <link href="../../webContent/CSS/index.css" rel="stylesheet" type="text/css"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous"
</head>
<body>
    <div id="registration-div" class="authorization-registration">
        <spring:form id="registration-form" action="registration.html" method="POST" modelAttribute="UserFromJspRegistration">
            <label id="registration-label">Регистрация</label> <br />
            <c:if test="${param.denided_user != null}">
                <h3>Email is already use;</h3>
            </c:if>
            <c:if test="${param.denided_validation != null}">
                <h3>Wrong format</h3>
            </c:if>
            <spring:input path="username" name="registration-username" id="registration-username" placeholder="Username"/> <br />
            <spring:input path="email" name="registration-email" class="authorization-registration-input" id="registration-email" placeholder="Email Address"/> <br />
            <spring:input path="password" name="registration-password" class="authorization-registration-input" id="registration-password" placeholder="Password"/> <br />
            <spring:input path="retypePassword" name="registration-retypePassword" class="authorization-registration-input" id="registration-retypePassword" placeholder="Retype password"/> <br />
            <input type="submit" value="Sign me up"/>
        </spring:form>
    </div>
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>
    <script type="text/javascript" src="../../webContent/JS/index.js"></script>
</body>
</html>
