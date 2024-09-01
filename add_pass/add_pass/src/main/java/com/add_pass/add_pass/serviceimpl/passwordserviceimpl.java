package com.add_pass.add_pass.serviceimpl;

import com.add_pass.add_pass.Model.password_list;
import com.add_pass.add_pass.db_util.db_util;
import com.add_pass.add_pass.service.passwordService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
@Service
@RestController
public class passwordserviceimpl implements passwordService {
    @Override
    public void postPasswordList(password_list passwordList) throws Exception {
        Connection connection = db_util.getConnection();
        String sql1 = "INSERT INTO password_list (Id, username, website, password) VALUES (?, ?, ?, ?)";

        try {
            PreparedStatement statement = connection.prepareStatement(sql1);
            statement.setInt(1, passwordList.getId());
            statement.setString(2, passwordList.getUsername());
            statement.setString(3, passwordList.getWebsite());
            statement.setString(4, passwordList.getPassword());

            statement.executeUpdate();
        } catch (SQLException e) {
            throw new Exception("Error posting password list to database: " + e.getMessage());
        }
    }
}
