<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 8/21/2025
  Time: 6:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.s4c1final.dao.PlayerDAO" %>
<%@ page import="com.example.s4c1final.model.Player" %>
<%@ page import="com.example.s4c1final.dao.IndexerDAO" %>
<%@ page import="com.example.s4c1final.model.Indexer" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<%
    IndexerDAO indexerDAO = new IndexerDAO();
    List<Indexer> indexers = indexerDAO.getAllIndexers();

    Map<Integer, String> indexMap = new HashMap<>();
    for(Indexer idx : indexers){
        indexMap.put(idx.getIndexId(), idx.getName());
    }
%>

<html>
<head>
    <title>Player Management</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"/>
</head>
<body class="p-4">
<div class="container">
    <h2 class="mb-3">Player List</h2>
    <a href="add-player.jsp" class="btn btn-primary mb-3">+ Add Player</a>
    <table class="table table-bordered table-striped">
        <thead class="table-dark">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Full Name</th>
            <th>Age</th>
            <th>Index</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <%
            PlayerDAO dao = new PlayerDAO();
            List<Player> players = dao.getAllPlayers();
            for (Player p : players) {
        %>
        <tr>
            <td><%=p.getPlayerId()%>
            </td>
            <td><%=p.getName()%>
            </td>
            <td><%=p.getFullName()%>
            </td>
            <td><%=p.getAge()%>
            </td>
            <td><%= indexMap.get(p.getIndexId()) %></td>
            </td>
            <td>
                <a href="edit-player.jsp?id=<%=p.getPlayerId()%>" class="btn btn-sm btn-warning">Edit</a>
                <form action="deletePlayer" method="post" style="display:inline;">
                    <input type="hidden" name="id" value="<%=p.getPlayerId()%>"/>
                    <button type="submit" class="btn btn-sm btn-danger"
                            onclick="return confirm('Are you sure to delete this player?')">
                        Delete
                    </button>
                </form>
            </td>
        </tr>
        <%
            }
        %>
        </tbody>
    </table>
</div>
</body>
</html>
