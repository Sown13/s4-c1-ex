package com.example.s4c1final.controller;


import com.example.s4c1final.dao.PlayerDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/deletePlayer")
public class DeletePlayerServlet extends HttpServlet {
    private PlayerDAO dao;

    @Override
    public void init() {
        dao = new PlayerDAO();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            String idStr = req.getParameter("id");
            if (idStr == null) {
                resp.getWriter().println("Missing player id!");
                return;
            }

            int id = Integer.parseInt(idStr);

            // gọi DAO với try-catch bên trong
            try {
                dao.deletePlayer(id);
                resp.sendRedirect("players"); // redirect về danh sách
            } catch (Exception e) {
                e.printStackTrace();
                resp.getWriter().println("Error deleting player: " + e.getMessage());
            }

        } catch (NumberFormatException e) {
            resp.getWriter().println("Invalid player id: " + e.getMessage());
        }
    }
}