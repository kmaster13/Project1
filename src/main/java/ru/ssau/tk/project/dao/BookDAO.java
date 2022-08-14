package ru.ssau.tk.project.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.ssau.tk.project.models.Book;
import ru.ssau.tk.project.models.Person;

import java.util.List;

@Component
public class BookDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public BookDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Book> index() {
        return jdbcTemplate.query("SELECT * FROM book ORDER BY book.date", new BookMapper());
    }

    public Book show(int id) {
        return jdbcTemplate.query("SELECT * FROM Book WHERE book_id=?", new Object[]{id}, new BookMapper()).stream().findAny().orElse(null);
    }

    public List<Book> showToUser(int id) {
        return jdbcTemplate.query("SELECT * FROM Book WHERE person_id=?", new Object[]{id}, new BookMapper());
    }

    public void save(Book book) {
        jdbcTemplate.update("INSERT INTO Book(book_name, author, date) VALUES (?, ?, ?)", book.getName(), book.getAuthor(), book.getDate());
    }

    public void update(int id, Book book) {
        jdbcTemplate.update("UPDATE Book SET book_name=?, author=?, date=? WHERE book_id=?", book.getName(), book.getAuthor(), book.getDate(), id);
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM Book WHERE book_id=?", id);
    }

    public void updateUser(int id, Person person){
        jdbcTemplate.update("UPDATE Book SET person_id=? WHERE book_id=?", person.getId(), id);
    }

    public void deleteUser(int id){
        jdbcTemplate.update("UPDATE Book SET person_id=null WHERE book_id=?", id);
    }
}
