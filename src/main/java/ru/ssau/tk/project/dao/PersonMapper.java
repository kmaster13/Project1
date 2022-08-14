package ru.ssau.tk.project.dao;

import org.springframework.jdbc.core.RowMapper;
import ru.ssau.tk.project.models.Person;

import java.sql.ResultSet;
import java.sql.SQLException;


public class PersonMapper implements RowMapper<Person> {
    @Override
    public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
        Person person = new Person();

        person.setId(rs.getInt("person_id"));
        person.setName(rs.getString("full_name"));
        person.setAge(rs.getInt("age"));

        return person;
    }
}
