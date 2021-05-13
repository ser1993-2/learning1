package com.example.demo1;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URL;

import java.sql.*;

@WebServlet(name = "ServletJson", value = "/ServletJson")
public class ServletJson extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");

        PrintWriter out = response.getWriter();

        Users user1 = new Users("ivan", "tes@tes.ru");

        ObjectMapper mapper = new ObjectMapper();
        StringWriter writer = new StringWriter();

        mapper.writeValue(writer, user1);
        out.print(writer.toString());

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
