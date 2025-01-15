package dao;

import model.Tour;
import utils.DBContext;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TourDAO {
    public List<Tour> searchByPrice(float maxPrice) {
        List<Tour> tours = new ArrayList<>();
        try {
            String sql = "SELECT * FROM tblTours WHERE price <= ?";
            Connection conn = DBContext.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setFloat(1, maxPrice);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Tour tour = new Tour();
                tour.setId(rs.getString("id"));
                tour.setName(rs.getString("name"));
                tour.setDestination(rs.getString("destination"));
                tour.setPrice(rs.getFloat("price"));
                tour.setDuration(rs.getInt("duration"));
                tour.setSeats(rs.getInt("seats"));
                tours.add(tour);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tours;
    }
    
    public boolean updateTour(Tour tour) {
        try {
            String sql = "UPDATE tblTours SET name=?, destination=?, price=?, duration=?, seats=? WHERE id=?";
            Connection conn = DBContext.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, tour.getName());
            ps.setString(2, tour.getDestination());
            ps.setFloat(3, tour.getPrice());
            ps.setInt(4, tour.getDuration());
            ps.setInt(5, tour.getSeats());
            ps.setString(6, tour.getId());
            
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}