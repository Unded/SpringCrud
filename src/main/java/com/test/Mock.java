package com.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Mock {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
//        NamedParameterJdbcTemplate tp = context.getBean("namedParameterJdbcTemplate", NamedParameterJdbcTemplate.class);
        JdbcTemplate tp = context.getBean("jdbcTemplate", JdbcTemplate.class);
//        Map<String, Integer> id = new HashMap<>();
//        id.put("id", 1);
//        String name = tp.queryForObject("SELECT name FROM users WHERE id = :id", id,String.class);
//        System.out.println("Name = " + name);

//        Integer count = tp.queryForObject("SELECT COUNT(*) FROM users", Integer.class);
//        System.out.println("Count of rows: " +count);

        List<String> query = tp.query("SELECT * FROM contact"
                , (rs, rn) -> "id: " + rs.getInt("id") +
                        ", Name: " + rs.getString("first_name") +
                        ", Surname: " + rs.getString("last_name") +
                        ", Birth date: " + rs.getDate("birth_date"));
        query.forEach(System.out::println);

    }
}
