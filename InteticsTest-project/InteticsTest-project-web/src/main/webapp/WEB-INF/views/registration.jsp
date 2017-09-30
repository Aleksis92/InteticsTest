<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
    <div id="registration-div" class="authorization-registration">
        <spring:form id="registration-form" action="registration.html" method="POST" modelAttribute="UserFromJspRegistration">
            <label id="registration-label">Регистрация</label> <br />
            <c:if test="${param.denided_user != null}">
                <h3>
                    Email is already use;
                </h3>
            </c:if>
            <c:if test="${param.denided_validation != null}">
                <h3>
                    Wrong format;
                </h3>
            </c:if>
            <spring:input path="username" name="registration-username" id="registration-username" placeholder="Username"/> <br />
            <spring:input path="email" name="registration-email" id="registration-email" placeholder="Email Address"/> <br />
            <spring:input path="password" name="registration-password" id="registration-password" placeholder="Password"/> <br />
            <spring:input path="retypePassword" name="registration-retypePassword" id="registration-retypePassword" placeholder="Retype password"/> <br />
            <input type="submit" value="Sign me up"/>
        </spring:form>
    </div>
</body>
</html>
