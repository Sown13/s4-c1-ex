<%@ page import="com.example.s4c1final.dao.PlayerDAO" %>
<%@ page import="com.example.s4c1final.model.Player" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.s4c1final.dao.IndexerDAO" %>
<%@ page import="com.example.s4c1final.model.Indexer" %><%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 8/21/2025
  Time: 6:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%
    IndexerDAO indexerDAO = new IndexerDAO();
    List<Indexer> indexers = indexerDAO.getAllIndexers();
%>
<html>
<head>
    <title>Add Player</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"/>
</head>
<body class="p-4">
<div class="container">
    <h2>Add New Player</h2>
    <form action="addPlayer" method="post" class="mt-3">
        <div class="mb-3">
            <label>Name:</label>
            <input type="text" name="name" class="form-control" required/>
        </div>
        <div class="mb-3">
            <label>Full Name:</label>
            <input type="text" name="fullName" class="form-control" required/>
        </div>
        <div class="mb-3">
            <label>Age:</label>
            <input type="text" name="age" class="form-control" required/>
        </div>
        <div class="mb-3">
            <label>Index ID:</label>
            <select name="indexId" class="form-select" required>
                <option value="" disabled selected>Select Index</option>
                <%
                    for (Indexer idx : indexers) {
                %>
                <option value="<%=idx.getIndexId()%>"><%=idx.getName()%>
                </option>
                <%
                    }
                %>
            </select>
        </div>
        <button type="submit" class="btn btn-success">Save</button>
        <a href="index.jsp" class="btn btn-secondary">Cancel</a>
    </form>
</div>
</body>
</html>
