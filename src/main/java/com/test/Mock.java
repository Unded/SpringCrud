package com.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Mock {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");

        // Named parameter query
        NamedParameterJdbcTemplate namedTp = context.getBean("namedParameterJdbcTemplate", NamedParameterJdbcTemplate.class);
        Map<String, Integer> id = new HashMap<>();
        id.put("id", 1);
        String name = namedTp.queryForObject("SELECT first_name FROM contact WHERE id = :id", id, String.class);
        System.out.println("Name = " + name);

        // Query without parameters
        JdbcTemplate tp = context.getBean("jdbcTemplate", JdbcTemplate.class);
        Integer count = tp.queryForObject("SELECT COUNT(*) FROM contact", Integer.class);
        System.out.println("Count of rows: " + count);

        // Query with RowMapperResultSetExtractor
        List<String> query = tp.query("SELECT * FROM contact"
                , (rs, rm) -> "id: " + rs.getInt("id") +
                        ", Name: " + rs.getString("first_name") +
                        ", Surname: " + rs.getString("last_name") +
                        ", Birth date: " + rs.getDate("birth_date"));
        query.forEach(System.out::println);

    }
}
