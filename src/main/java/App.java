import com.google.gson.Gson;
import models.Department;
import models.Staff;
import models.dao.Sql2oDepartmentDao;
import models.dao.Sql2oStaffDao;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static spark.Spark.*;

public class App {


    public static void main(String[] args) {
        Sql2oStaffDao staffDao;
        Sql2oDepartmentDao departmentDao;
        Gson gson = new Gson();
        Connection conn;

        String connectionString = "jdbc:h2:~/staffapp.db;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        staffDao = new Sql2oStaffDao(sql2o);
        departmentDao = new Sql2oDepartmentDao(sql2o);
        conn = sql2o.open();

        //CREATE
        post("/departments/new", "application/json", (req, res) -> {
            Department department = gson.fromJson(req.body(), Department.class);
            departmentDao.add(department);
            res.status(201);;
            return gson.toJson(department);
        });

        post("/departments/:departmentId/staff/new", "application/json", (req, res) -> {
            int departmentId = Integer.parseInt(req.params("departmentId"));
            Staff newStaff = gson.fromJson(req.body(), Staff.class);
            newStaff.setDepartment(departmentId); //we need to set this separately because it comes from our route, not our JSON input.
            staffDao.add(newStaff);
            res.status(201);
            return gson.toJson(staffDao);
        });



        //READ
        get("/departments", "application/json", (req, res) -> {
            return gson.toJson(departmentDao.getAll());
        });

        get("/departments/:id", "application/json", (req, res) -> {
            int restaurantId = Integer.parseInt(req.params("id"));
            return gson.toJson(departmentDao.findById(restaurantId));
        });

        get("/departments/:id/staff", "application/json", (req, res) -> {
            int departmentId = Integer.parseInt(req.params("id"));
            return gson.toJson(staffDao.findStaffByDepartmentId(departmentId));
        });

        get("/staff","application/json", (req, res) -> {
            return gson.toJson(staffDao.getAll());
        });

        //FILTERS
        after((req, res) ->{
            res.type("application/json");
        });


    }
}
