package com.example.demo1;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

@WebServlet(name = "ServletUser", value = "/ServletUser")
public class ServletUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String userId = request.getParameter("id");

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/isdon", "mysql", "mysql");

            Statement stmt = connection.createStatement();
            ResultSet executeQuery = stmt.executeQuery("SELECT * FROM `users` where id=" + userId);

            while (executeQuery.next()) {
                System.out.println(executeQuery.getString("name"));
                //Users user = new Users(executeQuery.getString("name"), executeQuery.getString("email"));
                request.setAttribute("name", executeQuery.getString("name"));
                request.setAttribute("email", executeQuery.getString("email"));
            }

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        request.getRequestDispatcher("/user.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
