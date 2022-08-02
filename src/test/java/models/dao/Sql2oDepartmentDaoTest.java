package models.dao;

import models.Department;
import models.Staff;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Sql2oDepartmentDaoTest {
    private Connection conn;
    private Sql2oStaffDao staffDao;

    private Sql2oDepartmentDao departmentDao;




    @BeforeEach
    public void setUp() throws Exception {
        String connectionString = "jdbc:h2:mem:testdb;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        staffDao = new Sql2oStaffDao(sql2o);
        departmentDao = new Sql2oDepartmentDao(sql2o);
        conn = sql2o.open();
    }

    @AfterEach
    public void tearDown() throws Exception {
        conn.close();
    }

    @Test
    public void add_getsDepartmentId(){
        Department newDepartment = setupDepartment();
        assertEquals(1,newDepartment.getId());

    }

    @Test
    public void findById_getsCorrectDepartment(){
        Department department = new Department("Finance","Responsible funds management");
        departmentDao.add(department);
        assertTrue(department.equals((departmentDao.findById(1)).get(0)));
    }



    //helpers

    public Staff setupStaff() {
        Staff staff = new Staff("Geoffrey","001","g@email.com","2355","Developer",1);
        staffDao.add(staff);
        return staff;
    }


    public Department setupDepartment() {
        Department department = new Department("Finance","Responsible funds management");
        departmentDao.add(department);
        return department;
    }

}
