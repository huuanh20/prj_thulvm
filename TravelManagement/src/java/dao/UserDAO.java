package dao;

import model.User;
import utils.DBContext;
import java.sql.*;

public class UserDAO {
    public User checkLogin(String email, String password) {
        try {
            String sql = "SELECT * FROM tblUsers WHERE email = ? AND password = ?";
            Connection conn = DBContext.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                User user = new User();
                user.setId(rs.getString("id"));
                user.setFullName(rs.getString("fullName"));
                user.setEmail(rs.getString("email"));
                return user;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}