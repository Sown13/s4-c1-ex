package com.example.s4c1final.dao;

import com.example.s4c1final.model.Player;
import com.example.s4c1final.utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PlayerDAO {

    // Thêm mới player
    public void addPlayer(Player p) throws Exception {
        String sql = "INSERT INTO player(name, full_name, age, index_id) VALUES(?,?,?,?)";
        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, p.getName());
            ps.setString(2, p.getFullName());
            ps.setInt(3, p.getAge());
            ps.setInt(4, p.getIndexId());
            ps.executeUpdate();
        }
    }

    // Lấy danh sách tất cả player
    public List<Player> getAllPlayers() {
        List<Player> list = new ArrayList<>();
        String sql = "SELECT * FROM player";
        try (Connection con = DBUtil.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Player p = new Player();
                p.setPlayerId(rs.getInt("player_id"));
                p.setName(rs.getString("name"));
                p.setFullName(rs.getString("full_name"));
                p.setAge(rs.getInt("age"));
                p.setIndexId(rs.getInt("index_id"));
                list.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    // Lấy player theo ID
    public Player getPlayerById(int id) throws Exception {
        String sql = "SELECT * FROM player WHERE player_id=?";
        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Player p = new Player();
                    p.setPlayerId(rs.getInt("player_id"));
                    p.setName(rs.getString("name"));
                    p.setFullName(rs.getString("full_name"));
                    p.setAge(rs.getInt("age"));
                    p.setIndexId(rs.getInt("index_id"));
                    return p;
                }
            }
        }
        return null;
    }

    // Cập nhật thông tin player
    public void updatePlayer(Player p) throws Exception {
        String sql = "UPDATE player SET name=?, full_name=?, age=?, index_id=? WHERE player_id=?";
        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, p.getName());
            ps.setString(2, p.getFullName());
            ps.setInt(3, p.getAge());
            ps.setInt(4, p.getIndexId());
            ps.setInt(5, p.getPlayerId());
            ps.executeUpdate();
        }
    }

    // Xóa player
    public void deletePlayer(int id) throws Exception {
        String sql = "DELETE FROM player WHERE player_id=?";
        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
}
