<%@ page import="com.example.s4c1final.model.Player" %>
<%@ page import="com.example.s4c1final.dao.PlayerDAO" %><%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 8/21/2025
  Time: 6:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%
  int id = Integer.parseInt(request.getParameter("id"));
  Player player = new PlayerDAO().getPlayerById(id);
%>
<html>
<head>
  <title>Edit Player</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"/>
</head>
<body class="p-4">
<div class="container">
  <h2>Edit Player</h2>
  <form action="updatePlayer" method="post" class="mt-3">
    <input type="hidden" name="id" value="<%=player.getPlayerId()%>"/>
    <div class="mb-3">
      <label>Name:</label>
      <input type="text" name="name" class="form-control" value="<%=player.getName()%>" required/>
    </div>
    <div class="mb-3">
      <label>Full Name:</label>
      <input type="text" name="fullName" class="form-control" value="<%=player.getFullName()%>" required/>
    </div>
    <div class="mb-3">
      <label>Age:</label>
      <input type="text" name="age" class="form-control" value="<%=player.getAge()%>" required/>
    </div>
    <div class="mb-3">
      <label>Index ID:</label>
      <select name="indexId" class="form-select">
        <option value="1" <%=player.getIndexId()==1?"selected":""%>>Speed</option>
        <option value="2" <%=player.getIndexId()==2?"selected":""%>>Strength</option>
        <option value="3" <%=player.getIndexId()==3?"selected":""%>>Accurate</option>
      </select>
    </div>
    <button type="submit" class="btn btn-success">Update</button>
    <a href="index.jsp" class="btn btn-secondary">Cancel</a>
  </form>
</div>
</body>
</html>
