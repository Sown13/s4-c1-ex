package com.example.s4c1final.controller;

import com.example.s4c1final.dao.PlayerDAO;
import com.example.s4c1final.model.Player;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "addPlayerServlet", value = "/addPlayer")
public class AddPlayerServlet extends HttpServlet {
    private PlayerDAO dao = new PlayerDAO();

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            Player p = new Player();
            p.setName(req.getParameter("name"));
            p.setFullName(req.getParameter("fullName"));
            p.setAge(Integer.parseInt(req.getParameter("age")));
            p.setIndexId(Integer.parseInt(req.getParameter("indexId")));

            dao.addPlayer(p);
            resp.sendRedirect("players.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            resp.getWriter().println("Error: " + e.getMessage());
        }
    }
}
