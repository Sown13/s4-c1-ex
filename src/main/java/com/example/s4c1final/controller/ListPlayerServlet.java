package com.example.s4c1final.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.List;

import com.example.s4c1final.dao.PlayerDAO;
import com.example.s4c1final.model.Player;

@WebServlet(name = "listPlayerServlet", value = "/players")
public class ListPlayerServlet extends HttpServlet {

    private PlayerDAO dao;

    @Override
    public void init() {
        dao = new PlayerDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Player> players = dao.getAllPlayers();

        // Gắn danh sách vào request attribute
        request.setAttribute("players", players);

        // Forward sang JSP
        RequestDispatcher dispatcher = request.getRequestDispatcher("players.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    public void destroy() {
        // Cleanup nếu cần
    }
}
