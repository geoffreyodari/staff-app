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

import java.util.List;

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
        setupNews();
        int newDepartmentNews= ((departmentNewsDao.all().get(0))).getId();
        assertEquals(1,newDepartmentNews);

    }

    @Test
    public void findById_getsDepartmentNewsById(){

        setupDepartment();
        int staffId = 1;
        String title = "Government Assets Recovered";
        String contentUrl ="/government-recovers-stolen-assets";
        DepartmentNews newDepartmentNews = new DepartmentNews(title,staffId,contentUrl,(setupDepartment()).getId());
        departmentNewsDao.add(newDepartmentNews);
        assertTrue(newDepartmentNews.equals(departmentNewsDao.findById(1).get(0)));
    }

    @Test
    public void findByStaffId_getsAllDepartmentNewsByAuthor(){
        Staff newStaff = setupStaff();
        int staffId = 1;
        String title = "Government Assets Recovered";
        String contentUrl ="/government-recovers-stolen-assets";
        DepartmentNews newDepartmentNews = new DepartmentNews(title,newStaff.getId(),contentUrl,1);
        departmentNewsDao.add(newDepartmentNews);
        System.out.println((departmentNewsDao.findByAuthor(newStaff.getId()).get(0)));
        System.out.println(newDepartmentNews);
        assertTrue(newDepartmentNews.equals((departmentNewsDao.findByAuthor(newStaff.getId()).get(0))));
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
        Staff newStaff = setupStaff();
        Department newDepartment = setupDepartment();
        String title = "Government Assets Recovered";
        String contentUrl ="/government-recovers-stolen-assets";

        departmentDao.add(newDepartment);
        DepartmentNews newDepartmentNews = new DepartmentNews(title,newStaff.getId(),contentUrl,((departmentDao.getAll()).get(0)).getId());
        departmentNewsDao.add(newDepartmentNews);
        assertTrue(newDepartmentNews.equals(departmentNewsDao.findByDepartmentId(((departmentDao.getAll()).get(0)).getId()).get(0)));
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

    @Test
    public void getsNameOfDepartment(){
        Department name = setupDepartment() ;
        setupNews();
        assertEquals(name.getName(),((departmentNewsDao.all()).get(0)).getName());
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
        setupDepartment();
        Staff staff = setupStaff();
        int staffId = staff.getId();
        Department newDepartment = (departmentDao.getAll()).get(0);
        String title = "Government Assets Recovered";
        String contentUrl ="/government-recovers-stolen-assets";
        DepartmentNews departmentNews = new DepartmentNews(title,staffId,contentUrl,newDepartment.getId());
        departmentNewsDao.add(departmentNews);
        return departmentNews;
    }

}
