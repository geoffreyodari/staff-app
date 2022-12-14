package models.dao;

import models.Department;

import java.util.List;

public interface DepartmentDao {
    //create
    void add (Department department);

    //read
    List<Department> getAll();
    List<Department> findById(int id);


    //update
    void update(int id, String name, String description);

    //delete
    void deleteById(int id);
    void clearAll();
}
