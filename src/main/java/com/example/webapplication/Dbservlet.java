package com.example.webapplication;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.swing.text.Style;

@WebServlet(name = "Dbservlet", value = "/DB-servlet")
public class Dbservlet extends HttpServlet {

    private String sqlQuery = "select * from items";
    private Connection connection = null;
    int id;
    String name;
    String itemprice;
    String itemquantity;


    public void init() throws ServletException {

        connection = H2JDBConnection.getConnection();

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String cssTag = "<link rel='stylesheet' type='text/css' href='/css/styles.css' ";

        response.setContentType("text/html");

        // Printwriter class object
        PrintWriter printOut = response.getWriter();
        printOut.println("<html> <head><title>Display Data</title>" + cssTag + "</head><body>");

        try {
            PreparedStatement getdbdata = connection.prepareStatement(sqlQuery);
            ResultSet rs = getdbdata.executeQuery();

            printOut.println("<div><table border=5px solid red >");
            printOut.println("<tr><th>ItemId</th><th>Itemname</th><th>Itemprice</th><th>itemquantity</th></tr>");
            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                id = rs.getInt("itemid");
                name = rs.getString("itemname");
                itemprice = rs.getString("itemprice");
                itemquantity = rs.getString("itemquantity");
                printOut.println("<tr><td>" + id + "</td><td>" + name + "</td><td>" + itemprice + "</td><td>" + itemquantity + "</td></tr>");
            }
            printOut.println("</div></table></body></html>");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void destroy() {
    }
}
