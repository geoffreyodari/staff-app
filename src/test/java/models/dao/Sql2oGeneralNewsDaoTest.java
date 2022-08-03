package models.dao;

import models.Department;
import models.GeneralNews;
import models.Staff;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Sql2oGeneralNewsDaoTest {
    private Connection conn;
    private Sql2oStaffDao staffDao;

    private Sql2oDepartmentDao departmentDao;
    private Sql2oGeneralNewsDao generalNewsDao;


    @BeforeEach
    public void setUp() throws Exception {
        String connectionString = "jdbc:h2:mem:testdb;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        generalNewsDao = new Sql2oGeneralNewsDao(sql2o);
        departmentDao = new Sql2oDepartmentDao(sql2o);
        staffDao = new Sql2oStaffDao(sql2o);
        conn = sql2o.open();
    }

    @AfterEach
    public void tearDown() throws Exception {
        conn.close();
    }

    @Test
    public void add_getsNewsId(){
        GeneralNews newGeneralNews= setupNews();
        assertEquals(1,newGeneralNews.getId());

    }

    @Test
    public void findById_getsGeneralNewsById(){
        int staffId = 1;
        String title = "Government Assets Recovered";
        String contentUrl ="/government-recovers-stolen-assets";
        GeneralNews newGeneralNews = new GeneralNews(title,staffId,contentUrl);
        generalNewsDao.add(newGeneralNews);
        assertTrue(newGeneralNews.equals((generalNewsDao.findById(1)).get(0)));
    }

    @Test
    public void findByStaffId_getsAllGeneralNewsByAuthor(){
        int staffId = 1;
        String title = "Government Assets Recovered";
        String contentUrl ="/government-recovers-stolen-assets";
        GeneralNews newGeneralNews = new GeneralNews(title,staffId,contentUrl);
        generalNewsDao.add(newGeneralNews);
        assertTrue(newGeneralNews.equals((generalNewsDao.findByAuthor(1)).get(0)));
    }

    @Test
    public void clearOne_deletesGeneralNewsById(){
        int staffId = 1;
        String title = "Government Assets Recovered";
        String contentUrl ="/government-recovers-stolen-assets";
        GeneralNews newGeneralNews = new GeneralNews(title,staffId,contentUrl);
        generalNewsDao.add(newGeneralNews);
        generalNewsDao.clearOne(1);
        assertEquals(0,generalNewsDao.findById(1).size());
    }

    @Test
    public void clearAll_deletesAllGeneralNews(){
        int staffId = 1;
        String title = "Government Assets Recovered";
        String contentUrl ="/government-recovers-stolen-assets";
        GeneralNews newGeneralNews = new GeneralNews(title,staffId,contentUrl);
        generalNewsDao.add(newGeneralNews);
        generalNewsDao.add(newGeneralNews);
        generalNewsDao.add(newGeneralNews);
        generalNewsDao.clearAll();
        assertEquals(0,generalNewsDao.all().size());
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

    public GeneralNews setupNews() {
        Staff staff = setupStaff();
        int staffId = staff.getId();
        String title = "Government Assets Recovered";
        String contentUrl ="/government-recovers-stolen-assets";
        GeneralNews generalNews= new GeneralNews(title,staffId,contentUrl);
        generalNewsDao.add(generalNews);
        return generalNews;
    }


}
