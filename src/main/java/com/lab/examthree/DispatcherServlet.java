package com.lab.examthree;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.Setter;

@RequestMapping("/displayBookDispatcher")
public class DispatcherServlet<Books> {
    private static final String query = "select * from Books";

    @Setter
    private DBConnectionManager db;

    @GetMapping
    @ResponseBody
    public String displayTasks() {
        StringBuilder htmlResponse = new StringBuilder();
        db.openConnection();
        Connection connection = db.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            ArrayList<Books> books = new ArrayList<Books>();
            while (rs.next()) {
                books.add(new Book(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4)));
            }

            htmlResponse.append("<html><head> </head><body>");
            htmlResponse.append("<table>");
            htmlResponse.append("<tr>");
            htmlResponse.append("<th>Task ID</th>");
            htmlResponse.append("<th>Description</th>");
            htmlResponse.append("<th>Status</th>");
            htmlResponse.append("<th>Due Date</th>");
            htmlResponse.append("<th>Delete</th>");
            htmlResponse.append("</tr>");
            for (Books Book : books) {
                htmlResponse.append("<tr>");
                htmlResponse.append("<td>").append(Book.id).append("</td>");
                htmlResponse.append("<td>").append(Book.title).append("</td>");
                htmlResponse.append("<td>").append(Book.author).append("</td>");
                htmlResponse.append("<td>").append(Book.price).append("</td>");
                htmlResponse.append("<td><form method='post' action='/OnlineBookstore/book/displayBookDispatcher?id=").append(Book.id)
                        .append("'>")
                        .append("<input type='submit' value='Delete'/>")
                        .append("</form></td>");
                htmlResponse.append("</tr>");
            }
            htmlResponse.append("</table>");
            htmlResponse.append("</body></html>");
        } catch (SQLException se) {
            se.printStackTrace();
            htmlResponse.append("<h1>").append(se.getMessage()).append("</h1>");
        } catch (Exception e) {
            e.printStackTrace();
            htmlResponse.append("<h1>").append(e.getMessage()).append("</h1>");
        }

        htmlResponse.append("</body></html>");
        db.closeConnection();
        return htmlResponse.toString();
    }
}
