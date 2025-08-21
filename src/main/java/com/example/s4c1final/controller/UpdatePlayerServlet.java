package com.example.s4c1final.controller;

import com.example.s4c1final.dao.PlayerDAO;
import com.example.s4c1final.model.Player;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/updatePlayer")
public class UpdatePlayerServlet extends HttpServlet {

    private PlayerDAO dao;

    @Override
    public void init() {
        dao = new PlayerDAO();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        try {
            int id = Integer.parseInt(req.getParameter("id"));
            String name = req.getParameter("name");
            String fullName = req.getParameter("fullName");
            int age = Integer.parseInt(req.getParameter("age"));
            int indexId = Integer.parseInt(req.getParameter("indexId"));

            Player p = new Player(id, name, fullName, age, indexId);
            dao.updatePlayer(p);

            resp.sendRedirect("players");
        } catch (Exception e) {
            e.printStackTrace();
            resp.getWriter().println("Error updating player: " + e.getMessage());
        }
    }
}