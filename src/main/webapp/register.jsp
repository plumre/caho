<%--
  Created by IntelliJ IDEA.
  User: 任天
  Date: 2019/2/22
  Time: 16:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
</head>
<body>
<h2>注册</h2>
<form action="" method="post">
    <table width="400" border="1">
        <tr>
            <td>用户名</td>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <td>密码</td>
            <td><input type="password" name="password"></td>
        </tr>
        <tr>
            <td>昵称</td>
            <td><input type="text" name="nickname"></td>
        </tr>
        <tr>
            <td>邮箱</td>
            <td><input type="text" name="mail"></td>
        </tr>
    </table>
    <input type="submit" value="提交">
</form>
</body>
</html>
