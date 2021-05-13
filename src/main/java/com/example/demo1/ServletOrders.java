package com.example.demo1;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

@WebServlet(name = "ServletOrders", value = "/ServletOrders")
public class ServletOrders extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");

        PrintWriter out = response.getWriter();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/isdon", "mysql", "mysql");

            Statement stmt = connection.createStatement();
            ResultSet executeQuery = stmt.executeQuery("SELECT * FROM `orders` limit 1000");
            out.println("{");

            while (executeQuery.next()) {
                out.print("\"" + executeQuery.getString("id") +  "\" : {");
                out.print( "\"id\" : \"" + executeQuery.getString("id") + "\"" +
                        ", \"don_session_id\" : \"" + executeQuery.getString("don_session_id") + "\"" +
                        ", \"client_id\" : \"" + executeQuery.getString("client_id") + "\"" +
                        "\",  \"created_at\" : \"" + executeQuery.getString("created_at") + "\"}");

                if (!executeQuery.isLast()) {
                    out.print(", ");
                }
            }

            out.println("}");

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
