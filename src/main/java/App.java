import com.google.gson.Gson;
import models.Department;
import models.DepartmentNews;
import models.GeneralNews;
import models.Staff;
import models.dao.Sql2oDepartmentDao;
import models.dao.Sql2oDepartmentNewsDao;
import models.dao.Sql2oGeneralNewsDao;
import models.dao.Sql2oStaffDao;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static spark.Spark.*;

public class App {


    public static void main(String[] args) {
        Sql2oStaffDao staffDao;
        Sql2oDepartmentDao departmentDao;
        Sql2oDepartmentNewsDao departmentNewsDao;
        Sql2oGeneralNewsDao generalNewsDao;
        Gson gson = new Gson();
        Connection conn;

        String connectionString = "jdbc:h2:~/staffapp.db;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        staffDao = new Sql2oStaffDao(sql2o);
        departmentDao = new Sql2oDepartmentDao(sql2o);
        departmentNewsDao = new Sql2oDepartmentNewsDao(sql2o);
        generalNewsDao = new Sql2oGeneralNewsDao(sql2o);
        conn = sql2o.open();

        //CREATE
        //Adding new department
        post("/departments/new", "application/json", (req, res) -> {
            Department department = gson.fromJson(req.body(), Department.class);
            departmentDao.add(department);
            res.status(201);;
            return gson.toJson(department);
        });

        //Adding new staff
        post("/departments/:departmentId/staff/new", "application/json", (req, res) -> {
            int departmentId = Integer.parseInt(req.params("departmentId"));
            Staff newStaff = gson.fromJson(req.body(), Staff.class);
            newStaff.setDepartment(departmentId);
            staffDao.add(newStaff);
            res.status(201);
            return gson.toJson(staffDao);
        });

        //Adding department news
        post("/departments/:id/news/new", "application/json", (req, res) -> {
            int departmentId = Integer.parseInt(req.params("id"));
            DepartmentNews newDepartmentNews = gson.fromJson(req.body(), DepartmentNews.class);
            newDepartmentNews.setDepartment(departmentId);
            departmentNewsDao.add(newDepartmentNews);
            res.status(201);
            return gson.toJson(departmentDao);
        });


        //adding general news
        post("/news/new", "application/json", (req, res) -> {
            GeneralNews newGeneralNews = gson.fromJson(req.body(), GeneralNews.class);
            generalNewsDao.add(newGeneralNews);
            res.status(201);
            return gson.toJson(newGeneralNews);
        });




        //READ
        //Get all departments
        get("/departments", "application/json", (req, res) -> {
            return gson.toJson(departmentDao.getAll());
        });

        //Get department by Id
        get("/departments/:id", "application/json", (req, res) -> {
            int departmentId = Integer.parseInt(req.params("id"));
            return gson.toJson(departmentDao.findById(departmentId));
        });

        //get all staff in a department
        get("/departments/:id/staff", "application/json", (req, res) -> {
            int departmentId = Integer.parseInt(req.params("id"));
            return gson.toJson(staffDao.findStaffByDepartmentId(departmentId));
        });

        //get single staff in a department
        get("/staff","application/json", (req, res) -> {
            return gson.toJson(staffDao.getAll());
        });

        //get all news in a department
        get("/departments/:id/news", "application/json", (req, res) -> {
            int departmentId = Integer.parseInt(req.params("id"));
            return gson.toJson(departmentNewsDao.findByDepartmentId(departmentId));
        });

        //get all general news
        get("/news", "application/json", (req, res) -> {
            return gson.toJson(generalNewsDao.all());
        });

        //FILTERS
        after((req, res) ->{
            res.type("application/json");
        });


    }
}
