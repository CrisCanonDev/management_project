package com.ccdev.project5.Project5.mapper;

import com.ccdev.project5.Project5.model.Employee;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface EmployeeMapper {

    @Insert("INSERT INTO employees (name, surname, salary, department_id)" +
            "VALUES (" +
            "   #{name}," +
            "   #{surname}" +
            "   #{salary}" +
            "   #{department.id}" +
            ");")
    @Options(useGeneratedKeys = true,
            keyColumn = "id",
            keyProperty = "id")
    void insertEmployee(Employee employee);

    @Select("SELECT * FROM employees WHERE id = #{id};")
    Employee getEmployeeById(int id);

    @Select("SELECT * FROM employees WHERE department_id = #{param1};")
    @ResultMap("employeesResultMap")
    List<Employee> getEmployeesByDepartment(int departmentID);

    @Update("UPDATE employees SET name = #{name}, " +
                "surname = #{surname}, " +
                "salary = #{salary}, " +
                "department_id = #{department.id};" +
            "WHERE id = #{id};")
    void updateEmployee(Employee employee);


    @Delete("DELETE FROM employees WHERE id = #{param1};")
    void deleteEmployeeById(int id);
}
