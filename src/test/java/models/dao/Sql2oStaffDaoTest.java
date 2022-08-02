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
    public void getAll_getAllStaff() throws Exception {
        Staff staff1 = new Staff("Geoffrey","001","g@email.com","2355","Developer",1);
        staffDao.add(staff1);
        Staff staff2 = new Staff("James","003","j@email.com","2355","Developer",1);
        staffDao.add(staff2);
        assertEquals(2, staffDao.getAll().size());
    }

    @Test
    public void findStaffById_getByStaffId() throws Exception {
        Staff staff1 = new Staff("Geoffrey","001","g@email.com","2355","Developer",1);
        staffDao.add(staff1);
        assertTrue(staff1.equals(staffDao.findStaffId("001").get(0)));
    }

    @Test
    public void deleteById_deleteStaffById() throws Exception{
        Staff staff1 = new Staff("Geoffrey","001","g@email.com","2355","Developer",1);
        staffDao.add(staff1);
        Staff staff2 = new Staff("James","004","j@email.com","23505","Developer",1);
        staffDao.add(staff2);
        staffDao.deleteById(1);
        assertTrue(staff2.equals(staffDao.getAll().get(0)));
    }

    @Test
    public void clearAll_deletesAll() throws Exception{
        Staff staff1 = new Staff("Geoffrey","001","g@email.com","2355","Developer",1);
        Staff staff2 = new Staff("James","004","j@email.com","23505","Developer",1);
        staffDao.add(staff1);
        staffDao.add(staff2);
        staffDao.clearAll();
        assertEquals(0,staffDao.getAll().size());
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
