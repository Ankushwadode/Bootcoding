package org.bootcoding.Repository;

import org.bootcoding.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepo {

    private JdbcTemplate template;

    @Autowired
    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    public void save(Student student){
        String sql = "INSERT INTO student (id,name,tech) VALUES (?,?,?)";
        int updatedRows = template.update(sql, student.getId(), student.getName(), student.getTech());
        System.out.println("rows/affected: "+updatedRows);
    }

    public List<Student> findAll(){
        String sql = "SELECT * FROM student";
        List<Student> studentList = template.query(sql, (rs,row) -> {
            Student student = new Student();
            student.setId(rs.getInt(1));
            student.setName(rs.getString(2));
            student.setTech(rs.getString(3));
            return student;
        });
        return studentList;
    }
}
