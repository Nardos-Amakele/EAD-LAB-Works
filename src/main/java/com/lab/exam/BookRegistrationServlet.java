package com.lab.exam;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/register")

public class BookRegistrationServlet extends HttpServlet {
	 @Override
	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        String title = request.getParameter("title");
	        String author = request.getParameter("author");
	        String price = request.getParameter("price");

	        try {
	            Connection connection = DBConnectionManager.getConnection();
	            String sql = "INSERT INTO Tasks (title, author, price) VALUES (?, ?, ?)";
	            PreparedStatement stmt = connection.prepareStatement(sql);
	            stmt.setString(1, title);
	            stmt.setString(2, author);
	            stmt.setString(3, price);
	            stmt.executeUpdate();

	            response.getWriter().write("Book Registered Successfully!");
	        } catch (SQLException e) {
	            e.printStackTrace();
	            response.getWriter().write("Unable to register");
	        }
	    }

}
