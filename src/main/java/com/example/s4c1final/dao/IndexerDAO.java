package com.example.s4c1final.dao;

import com.example.s4c1final.model.Indexer;
import com.example.s4c1final.utils.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class IndexerDAO {

    public List<Indexer> getAllIndexers() throws Exception {
        List<Indexer> list = new ArrayList<>();
        String sql = "SELECT * FROM indexer";
        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Indexer idx = new Indexer(
                        rs.getInt("index_id"),
                        rs.getString("name"),
                        rs.getFloat("valueMin"),
                        rs.getFloat("valueMax")
                );
                list.add(idx);
            }
        }
        return list;
    }

    public Indexer getIndexerById(int id) throws Exception {
        String sql = "SELECT * FROM indexer WHERE index_id=?";
        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Indexer(
                            rs.getInt("index_id"),
                            rs.getString("name"),
                            rs.getFloat("valueMin"),
                            rs.getFloat("valueMax")
                    );
                }
            }
        }
        return null;
    }
}
