package com.password.pass_data.serviceimpl;

import com.password.pass_data.db_util.db_util;
import com.password.pass_data.model.password_list;
import com.password.pass_data.service.passwordService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8085")
@Service
@RestController
public class passwordserviceimpl implements passwordService {
    @Override
    public List<password_list> getPasswordListById(int id) throws Exception {
        List<password_list> passwordList = new ArrayList<>();
        Connection connection = db_util.getConnection();
        String sql = "SELECT * FROM password_list where id="+id;

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                password_list password = new password_list();
                password.setUsername(rs.getString(1));
                password.setWebsite(rs.getString(2)); // Assuming hashed password is stored
                password.setPassword(rs.getString(3));
                password.setId(rs.getInt(4));
                passwordList.add(password);
            }
        } catch (SQLException e) {
            throw new Exception("Error posting password list to database: ");
        }

        return passwordList;
    }


    public void deletePasswordListById(int id) throws Exception {
        Connection connection = db_util.getConnection();
        String sql2 = "DELETE FROM password_list WHERE Id = ?";

        try {
            PreparedStatement statement = connection.prepareStatement(sql2);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new Exception("Error deleting password list with ID " + id + ": " + e.getMessage());
        }
    }


    public void deletePasswordListByNameWebsitePassword(password_list passwordList) throws Exception {
        Connection connection = db_util.getConnection();
        String sql = "DELETE FROM password_list WHERE Id = ? AND Username = ? AND Website = ? AND Password = ?";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, passwordList.getId());
            statement.setString(2, passwordList.getUsername());
            statement.setString(3, passwordList.getWebsite());
            statement.setString(4, passwordList.getPassword());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new Exception("Error deleting password list with id, name, website, and password: " + e.getMessage());
        }
    }
}
