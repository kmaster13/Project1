package ru.ssau.tk.project.dao;

import org.springframework.jdbc.core.RowMapper;
import ru.ssau.tk.project.models.Book;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookMapper implements RowMapper<Book> {
    @Override
    public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
        Book book = new Book();

        book.setId(rs.getInt("book_id"));
        book.setPersonId(rs.getInt("person_id"));
        book.setName(rs.getString("book_name"));
        book.setAuthor(rs.getString("author"));
        book.setDate(rs.getInt("date"));

        return book;
    }
}
