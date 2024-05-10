package com.ccdev.project5.Project5.mapper;

import com.ccdev.project5.Project5.model.Department;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DepartmentMapper {

    @Insert("INSERT INTO departments (name, location) VALUES (#{name}, #{location})")
    void insertDepartment(Department department);

    @Select("SELECT * FROM departments WHERE id = #{id}")
    Department getDepartmentById(int id);

    @Select("SELECT * FROM departments")
    List<Department> getAllDepartments();

    @Update("UPDATE departments SET name = #{name}, location = #{location}")
    void updateDepartment(Department department);

    @Delete("DELETE FROM departments WHERE id = #{id}")
    void deleteDepartmentById(int id);
}
