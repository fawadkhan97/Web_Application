package com.example.webapplication;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "Dbservlet", value = "/DB-servlet")
public class Dbservlet extends HttpServlet {
    Connection connection = H2DBConnection.getConnection();
    private String sqlQuery = "select * from user ";
    int id;
    String name;
    String email;


    public void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String cssTag = "<link rel='stylesheet' type='text/css' href='/css/styles.css' ";

        response.setContentType("text/html");

        // Printwriter class object
        PrintWriter printOut = response.getWriter();
        printOut.println("<html> <head><title>Display Data</title>" + cssTag + "</head><body>");


        ArrayList<User> userList = new ArrayList<User>();

        try {
            PreparedStatement getdbdata = connection.prepareStatement(sqlQuery);
            ResultSet rs = getdbdata.executeQuery();

//            printOut.println("<div><table border=5px solid red >");
//            printOut.println("<tr><th>ItemId</th><th>Itemname</th><th>Itemprice</th><th>itemquantity</th></tr>");
//             Step 4: Process the ResultSet object
            while (rs.next()) {
                User user = new User();
                id = rs.getInt("id");
                name = rs.getString("name");
                email = rs.getString("email");

                // set user data
                user.setId(id);
                user.setName(name);
                user.setEmail(email);

                // add user to list
                userList.add(user);


                System.out.println(id + " " + name + " " + email);

//                printOut.println("<tr><td>" + id + "</td><td>" + name + "</td><td>" + email + "</td></tr>");
            }

            System.out.println("\nthis is data from list ");
            for (User user : userList) {
                System.out.println("id: " + user.getId() + " name: " + user.getName() + "  email: " + user.getEmail());
            }

            // Setting the attribute of the request object
            // which will be later fetched by a JSP page
            request.setAttribute("data", userList);

            // Creating a RequestDispatcher object to dispatch
            // the request to another resource
            RequestDispatcher rd =
                    request.getRequestDispatcher("user.jsp");

            // The request will be forwarded to the resource
            // specified, here the resource is a JSP named,
            // "stdlist.jsp"
            rd.forward(request, response);
            printOut.println("</div></table></body>");
            printOut.println("</html>");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    /*public void init() throws ServletException {


    }*/

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        processRequest(request, response);


    }

    public void destroy() {
    }
}
