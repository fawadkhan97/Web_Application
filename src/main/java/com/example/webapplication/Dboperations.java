package com.example.webapplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Dboperations {

    private static final String INSERT_USERS_SQL = "INSERT INTO users" + "  (name, email) VALUES " +
            " (?, ?);";
    private static final String SELECT_USER_BY_ID = "select id,name,email from users where id =?";
    private static final String SELECT_ALL_USERS = "select * from users";
    private static final String DELETE_USERS_SQL = "delete from users where id = ?;";
    private static final String UPDATE_USERS_SQL = "update users set name = ?,email= ? where id = ?;";

    public void insertUser(User user) throws SQLException {
        System.out.println(INSERT_USERS_SQL);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = H2DBConnection.getConnection();
             PreparedStatement insertqueryStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            insertqueryStatement.setString(1, user.getName());
            insertqueryStatement.setString(2, user.getEmail());
            System.out.println(insertqueryStatement);
            insertqueryStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public User selectUser(int id) {
        User user = null;
        // Step 1: Establishing a Connection
        try (Connection connection = H2DBConnection.getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement getUserByIdStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {
            getUserByIdStatement.setInt(1, id);
            System.out.println(getUserByIdStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = getUserByIdStatement.executeQuery();

            System.out.println("before rs = "+id);
            // Step 4: Process the ResultSet object.



            while (rs.next()) {

                String name = rs.getString("name");
                String email = rs.getString("email");

                user =new User();

                user.setId(id);
                user.setName(name);
                user.setEmail(email);

                System.out.println("id is "+user.getId());
            }
        } catch (SQLException e) {

        }
        return user;
    }

    public List<User> displayUser() throws SQLException {

        // using try-with-resources to avoid closing resources
        List<User> userList = new ArrayList<>();
        // Step 1: Establishing a Connection
        Connection connection = H2DBConnection.getConnection();

        // Step 2:Create a statement using connection object
        PreparedStatement getallusersStatement = connection.prepareStatement(SELECT_ALL_USERS);
        System.out.println(getallusersStatement);
        // Step 3: Execute the query or update query
        ResultSet rs = getallusersStatement.executeQuery();

        // Step 4: Process the ResultSet object.
        while (rs.next()) {
            User user = new User();
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String email = rs.getString("email");

            // set user data
            user.setId(id);
            user.setName(name);
            user.setEmail(email);

            // add user to list
            userList.add(user);
            System.out.println(id + " " + name + " " + email);
        }

        return userList;
    }


    public boolean deleteUser(int id) throws SQLException {
        boolean rowDeleted;
        System.out.println("here");
        Connection connection = H2DBConnection.getConnection();
        PreparedStatement deleteUserstatement = connection.prepareStatement(DELETE_USERS_SQL);
        deleteUserstatement.setInt(1, id);
        rowDeleted = deleteUserstatement.executeUpdate() > 0;

        return rowDeleted;
    }

    public boolean updateUser(User user) throws SQLException {
        System.out.println("in db operations");
        boolean rowUpdated;
        try (Connection connection = H2DBConnection.getConnection();
             PreparedStatement updateUserstatement = connection.prepareStatement(UPDATE_USERS_SQL);) {
            updateUserstatement.setString(1, user.getName());
            updateUserstatement.setString(2, user.getEmail());
            updateUserstatement.setInt(3, user.getId());
            rowUpdated = updateUserstatement.executeUpdate() > 0;

            System.out.println(updateUserstatement);
        }
        return rowUpdated;
    }


}



