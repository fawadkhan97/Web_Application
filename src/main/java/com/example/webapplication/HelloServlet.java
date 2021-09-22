package com.example.webapplication;

import java.io.*;
import java.sql.Connection;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    Connection connection = H2DBConnection.getConnection();

    private String sqlQuery = "select * from items";



    private String message;

    private String displayTable;

    public void init() {
        message = "World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h3>" + message + "</h3>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}

