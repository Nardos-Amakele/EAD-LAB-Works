package com.lab.exam;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/booklist")
public class DisplayBooksServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            Connection connection = DBConnectionManager.getConnection();
            String sql = "SELECT * FROM Books";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            out.println("<html><body>");
            out.println("<h1>Books</h1>");
            out.println("<table border='1'><tr><th>ID</th><th>title</th><th>author</th><th>price</th></tr>");
            
            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String author = rs.getString("author");
                int price = rs.getInt("price");

                out.println("<tr><td>" + id + "</td><td>" + title + "</td><td>" + author + "</td><td>" + price + "</td></tr>");
            }

            

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
