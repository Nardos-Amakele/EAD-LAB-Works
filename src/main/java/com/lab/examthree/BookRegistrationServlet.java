package com.lab.examthree;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.Setter;

@RequestMapping("/addBook")
public class BookRegistrationServlet {
    private static final String query = "insert into books(title, author, price) values(?, ?, ?)";
    @Setter
    private DBConnectionManager db;

    @GetMapping
    @ResponseBody
    public String showForm() {
        return "<html><body>"
                + "<h2>TBook Register</h2>"
                + "<form method='post' action='/OnlineBookstore/books/addBook'>"
                + "Description: <input type='text' name='title'><br>"
                + "Status: <input type='text' name='author'><br>"
                + "Due Date: <input type='int' name='price'><br>"
                + "<input type='Add book' value='Add Book'>"
                + "</form>"
                + "</body></html>";
    }

    @PostMapping
    @ResponseBody
    public String addBook(@RequestParam String title, @RequestParam String author, @RequestParam int price) {
        db.openConnection();

        try {
            PreparedStatement ps = db.getConnection().prepareStatement(query);
            ps.setString(1, title);
            ps.setString(2, author);
            ps.setInt(3, price);
            int count = ps.executeUpdate();
            db.closeConnection();
            if (count == 1) {
                return "Registration Successful";
            } else {
                return "Registration Failed";
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return "Registration Failed";
        } finally {
            db.closeConnection();
        }
    }
}
