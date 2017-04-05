<%--
  Created by IntelliJ IDEA.
  User: Yayheniy_Lepkovich
  Date: 4/5/2017
  Time: 4:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>index</title>
    <%--<meta name="_csrf" content="${_csrf.token}"/>--%>
    <%--<meta name="_csrf_header" content="${_csrf.headerName}"/>--%>
    <script type="text/javascript" src="/resources/js/jquery-3.2.0.min.js"></script>
</head>
<body>
    <div>
        <h1>GetUserById:</h1>
        <label>type id: </label><input id="userIdInput" />
        <input type="button" onclick="getUserById()" value="click"/>
        <br/>
        <div id="userInfo"></div>
        <br/><br/><br/>
    </div>
</body>
</html>

<script>
//    var token = $("meta[name='_csrf']").attr("content");
//    var header = $("meta[name='_csrf_header']").attr("content");

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
//            beforeSend: function(xhr){
//                xhr.setRequestHeader(header, token)
//            },
            success: function(data){
                $("#userInfo")
                    .append($("<span>")
                        .text("Name: " + data.name + "; ")
                    ).append($("<span>")
                        .text("Surname: " + data.surname + "; ")
                    ).append($("<span>")
                        .text("Age: " + data.age + ";")
                    ).append($("<br>"));
            },
            error: function(data){
                alert('error: ' + data.statusText);
            }
        });
    }
</script>
