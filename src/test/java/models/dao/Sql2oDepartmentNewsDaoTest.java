package models.dao;

import models.Department;
import models.DepartmentNews;
import models.GeneralNews;
import models.Staff;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Sql2oDepartmentNewsDaoTest {

    private Connection conn;
    private Sql2oStaffDao staffDao;

    private Sql2oDepartmentNewsDao departmentNewsDao;
    private Sql2oDepartmentDao departmentDao;
    private Sql2oGeneralNewsDao generalNewsDao;


    @BeforeEach
    public void setUp() throws Exception {
        String connectionString = "jdbc:h2:mem:testdb;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        departmentNewsDao = new Sql2oDepartmentNewsDao(sql2o);
        staffDao = new Sql2oStaffDao(sql2o);
        conn = sql2o.open();
    }

    @AfterEach
    public void tearDown() throws Exception {
        conn.close();
    }

    @Test
    public void add_getsNewsId(){
        DepartmentNews newDepartmentNews= setupNews();
        assertEquals(1,newDepartmentNews.getId());

    }

    @Test
    public void findById_getsDepartmentNewsById(){
        int staffId = 1;
        String title = "Government Assets Recovered";
        String contentUrl ="/government-recovers-stolen-assets";
        DepartmentNews newDepartmentNews = new DepartmentNews(title,staffId,contentUrl,1);
        departmentNewsDao.add(newDepartmentNews);
        assertTrue(newDepartmentNews.equals((departmentNewsDao.findById(1)).get(0)));
    }

    @Test
    public void findByStaffId_getsAllDepartmentNewsByAuthor(){
        int staffId = 1;
        String title = "Government Assets Recovered";
        String contentUrl ="/government-recovers-stolen-assets";
        DepartmentNews newDepartmentNews = new DepartmentNews(title,staffId,contentUrl,1);
        departmentNewsDao.add(newDepartmentNews);
        assertTrue(newDepartmentNews.equals((departmentNewsDao.findByAuthor(1)).get(0)));
    }

    @Test
    public void clearOne_deletesDepartmentNewsById(){
        int staffId = 1;
        String title = "Government Assets Recovered";
        String contentUrl ="/government-recovers-stolen-assets";
        DepartmentNews newDepartmentNews  = new DepartmentNews(title,staffId,contentUrl,1);
        departmentNewsDao.add(newDepartmentNews );
        departmentNewsDao.clearOne(1);
        assertEquals(0,departmentNewsDao.findById(1).size());
    }

    @Test
    public void findByDepartmentId_findsNewsByDepartmentId(){
        int staffId = 1;
        String title = "Government Assets Recovered";
        String contentUrl ="/government-recovers-stolen-assets";
        DepartmentNews newDepartmentNews = new DepartmentNews(title,staffId,contentUrl,1);
        departmentNewsDao.add(newDepartmentNews);
        assertTrue(newDepartmentNews.equals(departmentNewsDao.findByDepartmentId(1).get(0)));
    }

    @Test
    public void clearAll_deletesAllDepartmentNews(){
        int staffId = 1;
        String title = "Government Assets Recovered";
        String contentUrl ="/government-recovers-stolen-assets";
        DepartmentNews newDepartmentNews = new DepartmentNews(title,staffId,contentUrl,1);
        departmentNewsDao.add(newDepartmentNews);
        departmentNewsDao.add(newDepartmentNews);
        departmentNewsDao.add(newDepartmentNews);
        departmentNewsDao.clearAll();
        assertEquals(0,departmentNewsDao.all().size());
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

    public DepartmentNews setupNews() {
        Staff staff = setupStaff();
        int staffId = staff.getId();
        String title = "Government Assets Recovered";
        String contentUrl ="/government-recovers-stolen-assets";
        DepartmentNews departmentNews = new DepartmentNews(title,staffId,contentUrl,1);
        departmentNewsDao.add(departmentNews);
        return departmentNews;
    }

}
