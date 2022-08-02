package models.dao;
import models.Department;
import models.Staff;
import org.junit.jupiter.api.*;
import org.sql2o.*;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Sql2oStaffDaoTest {
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
    public void addingStaffSetsId() throws Exception {
        Staff testStaff= setupStaff();
        assertEquals(1, testStaff.getId());
    }

    @Test
    public void getAll() throws Exception {
        Staff staff1 = new Staff("Geoffrey","001","g@email.com","2355","Developer",1);
        staffDao.add(staff1);
        Staff staff2 = new Staff("James","003","j@email.com","2355","Developer",1);
        staffDao.add(staff2);
        assertEquals(2, staffDao.getAll().size());
    }

    @Test
    public void getAllByStaffId() throws Exception {

        Staff staff1 = new Staff("Geoffrey","001","g@email.com","2355","Developer",1);
        staffDao.add(staff1);
        System.out.println(staff1);
        System.out.println(staffDao.findStaffId("001").get(0));
        assertTrue(staff1.equals(staffDao.findStaffId("001").get(0)));
    }



    //helpers

    public Staff setupStaff() {
        Staff staff = new Staff("Geoffrey","001","g@email.com","2355","Developer",1);
        staffDao.add(staff);
        return staff;
    }



    public Staff setupStaffForDepartment(Department department) {
        Staff staff = new Staff("James","002","g@email.com","23556","Accountant", department.getId());
        staffDao.add(staff);
        return staff;
    }

    public Department setupDepartment() {
        Department department = new Department("Finance","Responsible funds management");
        departmentDao.add(setupDepartment());
        return department;
    }
}
