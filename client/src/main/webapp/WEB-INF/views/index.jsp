<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Yayheniy_Lepkovich
  Date: 4/5/2017
  Time: 4:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" session="true" %>
<html>
<head>
    <title>index</title>
    <script type="text/javascript" src="/resources/js/jquery-3.2.0.min.js"></script>
</head>
<body>
    <div>
        <a href="/?locale=en">EN</a><label> | </label><a href="/?locale=ru">RU</a>
    </div>
    <div>
        <h1>SavedUser:</h1>
        <label><spring:message code="user_name"/> ${sessionScope.savedUser.name}</label><br/>
        <label><spring:message code="user_surname"/> ${sessionScope.savedUser.surname}</label><br/>
        <label><spring:message code="user_age"/> ${sessionScope.savedUser.age}</label><br/>
        <br/><br/><br/>
    </div>
    <div>
        <h1>GetUserById:</h1>
        <label><spring:message code="type_id"/> </label><input id="userIdInput" />
        <input type="button" onclick="getUserById()" value="<spring:message code="click"/>"/>
        <br/>
        <div id="userInfo"></div>
        <br/><br/><br/>
    </div>
    <div>
        <h1>GetUserByIdAsync:</h1>
        <label><spring:message code="type_id"/> </label><input id="asyncUserIdInput" />
        <input type="button" onclick="getUserByIdAsync()" value="<spring:message code="click"/>"/>
        <br/>
        <div id="asyncUserInfo"></div>
        <br/><br/><br/>
    </div>
    <div>
        <h1>GetUserByIdMatrix:</h1>
        <label><spring:message code="type_id"/> </label><input id="userIdInputMatrix" />
        <input type="button" onclick="getUserByIdMatrix()" value="<spring:message code="click"/>"/>
        <br/>
        <div id="userInfoMatrix"></div>
        <br/><br/><br/>
    </div>
    <div>
        <h1>SaveUserInSession:</h1>
        <label><spring:message code="type_id"/> </label><input id="saveUserIdInput" />
        <input type="button" onclick="saveUserInSession()" value="<spring:message code="click"/>"/>
        <br/>
        <br/><br/><br/>
    </div>
    <div>
        <h1>addUserByAjax</h1>
        <label><spring:message code="user_name"/> </label><input id="ajaxUserName"/><br/>
        <label><spring:message code="user_surname"/> </label><input id="ajaxUserSurname"/><br/>
        <label><spring:message code="user_age"/> </label><input id="ajaxUserAge"/><br/>
        <input type="button" onclick="addUserByAjax()" value="<spring:message code="click"/>"/>
        <br/>
        <br/><br/><br/>
    </div>
    <div>
        <h1>addUserByForm</h1>
        <form:form action="/addUserByForm" modelAttribute="user" method="POST">
            <div>
                <form:label path="name"><spring:message code="user_name"/></form:label>
                <form:input path="name"/><br/>
            </div>
            <div>
                <form:label path="surname"><spring:message code="user_surname"/></form:label>
                <form:input path="surname"/><br/>
            </div>
            <div>
                <form:label path="age"><spring:message code="user_age"/></form:label>
                <form:input path="age"/><br/>
            </div>
            <input type="submit" value="submit"/>
        </form:form>
    </div>
</body>
</html>

<script>

    function getUserById(){
        var id = $("#userIdInput").val();
        var url = "/getUser/" + id;
        $.ajax({
            type: "GET",
            url: url,
            dataType: "json",
            headers: {
                'Content-type': "application/json; charset=utf-8",
                'Accept': 'application/json'
            },
            success: function(data){
                $("#userInfo")
                    .append($("<span>")
                        .text("<spring:message code="user_name"/> " + data.name + "; ")
                    ).append($("<span>")
                        .text("<spring:message code="user_surname"/> " + data.surname + "; ")
                    ).append($("<span>")
                        .text("<spring:message code="user_age"/> " + data.age + ";")
                    ).append($("<br>"));
            },
            error: function(data){
                alert('error: ' + data.statusText);
            }
        });
    }

    function getUserByIdAsync(){
        var id = $("#asyncUserIdInput").val();
        var url = "/getUserAsync/" + id;
        $.ajax({
            type: "GET",
            url: url,
            dataType: "json",
            headers: {
                'Content-type': "application/json; charset=utf-8",
                'Accept': 'application/json'
            },
            success: function (data) {
                $("#asyncUserInfo")
                        .append($("<span>")
                                .text("<spring:message code="user_name"/> " + data.name + "; ")
                        ).append($("<span>")
                        .text("<spring:message code="user_surname"/> " + data.surname + "; ")
                ).append($("<span>")
                        .text("<spring:message code="user_age"/> " + data.age + ";")
                ).append($("<br>"));
            },
            error: function(data){
                alert('error: ' + data.statusText);
            }
        });
    }

    function getUserByIdMatrix(){
        var id = $("#userIdInputMatrix").val();
        var url = "/getUserByIdMatrix/id=" + id;
        $.ajax({
            type: "GET",
            url: url,
            dataType: "json",
            headers: {
                'Content-type': "application/json; charset=utf-8",
                'Accept': 'application/json'
            },
            success: function(data){
                $("#userInfoMatrix")
                        .append($("<span>")
                                .text("<spring:message code="user_name"/> " + data.name + "; ")
                        ).append($("<span>")
                        .text("<spring:message code="user_surname"/> " + data.surname + "; ")
                ).append($("<span>")
                        .text("<spring:message code="user_age"/> " + data.age + ";")
                ).append($("<br>"));
            },
            error: function(data){
                alert('error: ' + data.statusText);
            }
        });
    }

    function saveUserInSession(){
        var id = $("#saveUserIdInput").val();
        var url = "/saveUserInSession/" + id;
        $.ajax({
            type: "POST",
            url: url,
            dataType: "json",
            headers: {
                'Content-type': "application/json; charset=utf-8",
                'Accept': 'application/json'
            }
        });
    }

    function addUserByAjax(){
        var url = "/addUserByAjax/";
        $.ajax({
            type: "POST",
            url: url,
            dataType: "json",
            data: JSON.stringify({
                "name":$("#ajaxUserName").val(),
                "surname":$("#ajaxUserSurname").val(),
                "age":$("#ajaxUserAge").val()
            }),
            headers: {
                'Content-type': "application/json; charset=utf-8",
                'Accept': 'application/json'
            }
        });
    }
</script>
