package com.lab.examthree;
import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor

public class Book {
	public int id;
    public String title;
    public String author;
    public Date price;
}



