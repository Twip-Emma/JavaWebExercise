<%--
  Created by IntelliJ IDEA.
  User: 七画一只妖
  Date: 2021/10/1
  Time: 20:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body style="text-align: center">
<form action="<%=request.getContextPath()%>/CharacterServlet" method="post">
  <table border="1" width="600px" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td height="30" align="center">用户名：</td>
      <th>&nbsp;<input type="text" name="name" /></th>
    </tr>
    <tr>
      <td height="30" align="center">密&nbsp;码：</td>
      <th>&nbsp;<input type="text" name="password" /></th>
    </tr>
    <tr>
      <td height="30" colspan="2" align="center">
        <input type="submit" value="登录" />
        &nbsp;&nbsp;&nbsp;&nbsp;
        <input type="reset" value="重置">
      </td>
    </tr>
  </table>
</form>
</body>
</html>
