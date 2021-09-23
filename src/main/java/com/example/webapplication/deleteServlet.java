package com.example.webapplication;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(value = "/delete")
public class deleteServlet extends HttpServlet {
    private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws
            SQLException, IOException, ServletException {
Dboperations dboperations=new Dboperations();
        int id = Integer.parseInt(request.getParameter("id"));

        dboperations.deleteUser(id);
        response.sendRedirect("/user-servlet");

    }

}
