package models.dao;

import models.Department;
import models.DepartmentNews;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oDepartmentDao implements DepartmentDao{

    private final Sql2o sql2o;


    public Sql2oDepartmentDao(Sql2o sql2o) { this.sql2o = sql2o; }
    @Override
    public void add(Department department) {
        String sql = "INSERT INTO departments (departmentname, description) VALUES (:departmentName, :description)";
        try (Connection con = sql2o.open()) {
            int id = (int) con.createQuery(sql, true)
                    .bind(department)
                    .executeUpdate()
                    .getKey();
            department.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }

    }

    @Override
    public List<Department> getAll() {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM departments")
                    .executeAndFetch(Department.class);
        }
    }

    @Override
    public List<Department> findById(int id) {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM departments WHERE id = :departmentId")
                    .addParameter("departmentId", id)
                    .executeAndFetch(Department.class);
        }
    }

    @Override
    public void update(int id, String name, String description) {

    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public void clearAll() {

    }


}
