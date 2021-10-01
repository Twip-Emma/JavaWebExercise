<%--
  Created by IntelliJ IDEA.
  User: 七画一只妖
  Date: 2021/9/30
  Time: 9:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>pageContext</h1>
<%
    HttpServletRequest req = (HttpServletRequest) pageContext.getRequest();
    pageContext.setAttribute("str","Java",pageContext.PAGE_SCOPE);
    req.setAttribute("str","JavaWeb");
    String str = (String) pageContext.getAttribute("str",pageContext.PAGE_SCOPE);
    String str1 = (String) pageContext.getAttribute("str",pageContext.REQUEST_SCOPE);
%>
<%="page范围："+str%><br />
<%="request范围："+str1%>
</body>
</html>
