<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>signIn</title>
    <c:url var="css_url" value="/webContent/CSS/style.css" />

    <link href="${css_url}" rel="stylesheet" type="text/css"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous"/>
</head>
</head>
<body>
<div  class="container-fluid container-background">
    <div class="row justify-content-center align-items-center full-screen-row">
        <div class="col-xs-8 col-sm-6 col-md-5 col-lg-4 col-xl-3 border form-background" >
            <div class="row">
                <spring:form class="form col-12" action="/registration.html" method="POST" modelAttribute="UserFromJspRegistration">
                    <div class="form-group col-12">
                        <h3 id="authorization-label" class="text-center">SIGN UP</h3>
                    </div>
                    <c:if test="${param.denided_user != null}">
                        <h3>Email is already use;</h3>
                    </c:if>
                    <c:if test="${param.denided_validation != null}">
                        <h3>Wrong format</h3>
                    </c:if>
                    <div class="form-group col-10 ml-auto mr-auto">
                        <spring:input path="username" class="form-control login-content" placeholder="Username"/>
                    </div>
                    <div class="form-group col-10 ml-auto mr-auto">
                        <spring:input path="email" class="form-control login-content" placeholder="E-mail"/>
                    </div>
                    <div class="form-group col-10 ml-auto mr-auto">
                        <spring:input path="password" class="form-control login-content" placeholder="Password"/>
                    </div>
                    <div class="form-group col-10 ml-auto mr-auto">
                        <spring:input path="retypePassword" class="form-control login-content" placeholder="Retype password"/>
                    </div>
                    <div class="form-group col-10 ml-auto mr-auto">
                        <button id="registration-button" type="submit" class="btn btn-success login-content">SIGN ME UP</button>
                    </div>
                </spring:form>
            </div>
        </div>
    </div>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>
</body>
</html>
