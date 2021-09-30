<%--
  Created by IntelliJ IDEA.
  User: 七画一只妖
  Date: 2021/9/29
  Time: 10:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<%!
int a = 1
        ,
        b = 2;
%>
<%!
    public String print() {
        String str = "itcast";
        return str;
    }
%>
<body>
<h1>JSP声明语句</h1>
    <%
//        System.out.println(a+b);
        out.print(a + b);
    %>
    <%
//        System.out.println(print());
        out.print(print());
    %><br />

    <%--直接计算表达式或者函数--%>
    <%=a+b%><br />
    <%=print()%><br />
</body>
</html>
