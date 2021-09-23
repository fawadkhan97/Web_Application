package com.example.webapplication;

import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet("/")
public class UserServlet extends HttpServlet {

    private Dboperations dboperations;


    public void init() throws ServletException {
        dboperations = new Dboperations();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String action = request.getServletPath();
        System.out.println("action is "+action);


        try {
            switch (action) {
                case "/delete ":
                    deleteUser(request, response);
                    break;
                case "/insert":
                    insertUser(request,response);
                default:
                    displayUser(request, response);
                    break;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        //  processRequest(request, response);

    }

    private void displayUser(HttpServletRequest request, HttpServletResponse response) throws
            SQLException, IOException, ServletException {

        List<User> userList = new ArrayList<>();
        try {
            userList = dboperations.displayUser();

        } catch (NullPointerException e) {
            System.out.println("no data recieved");
            e.getMessage();
        }

        // Setting the attribute of the request object
        // which will be later fetched by a JSP page
        request.setAttribute("userList", userList);


        // Creating a RequestDispatcher object to dispatch
        // the request to another resource
        RequestDispatcher requestDispatcher =
                request.getRequestDispatcher("user.jsp");

        requestDispatcher.forward(request, response);


    }


    private void insertUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        User newUser = new User();
        newUser.setName(name);
        newUser.setEmail(email);
        dboperations.insertUser(newUser);
        response.sendRedirect("/");
    }



    private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws
            SQLException, IOException, ServletException {

        int id = Integer.parseInt(request.getParameter("id"));
        dboperations.deleteUser(id);
        response.sendRedirect("user-servlet");


    }

    public void destroy() {
    }
}
