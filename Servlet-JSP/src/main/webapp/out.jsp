<%--
  Created by IntelliJ IDEA.
  User: 七画一只妖
  Date: 2021/9/30
  Time: 8:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" buffer="0kb" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>JSP隐式对象</h1>
<%--隐式对象在整个jsp页面结束时，才从缓冲区读取--%>
<%--可以限制缓冲区大小解决--%>
<%--buffer="0kb"--%>
<%
    out.print("这是第一行<br/>");
    response.getWriter().print("这是第二行<br/>");
%>
<br />
</body>
</html>
