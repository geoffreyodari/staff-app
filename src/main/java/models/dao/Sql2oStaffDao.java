package models.dao;

import models.Staff;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oStaffDao implements StaffDao{
    private final Sql2o sql2o;

    public Sql2oStaffDao(Sql2o sql2o) { this.sql2o = sql2o; }

    @Override
    public void add(Staff staff) {
        String sql = "INSERT INTO staff (name, staffid, email, phone,role,department) VALUES (:name, :staffId, :email, :phone,:role,:department)";
        try (Connection con = sql2o.open()) {
            int id = (int) con.createQuery(sql, true)
                    .bind(staff)
                    .executeUpdate()
                    .getKey();
            staff.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public List<Staff> getAll() {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM staff")
                    .executeAndFetch(Staff.class);
        }
    }

    @Override
    public List<Staff> findStaffId(String id) {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM staff WHERE staffid=:id")
                    .addParameter("id", id)
                    .executeAndFetch(Staff.class);
        }
    }

    @Override
    public List<Staff> findStaffByDepartmentId(int id) {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM staff WHERE department=:id")
                    .addParameter("id", id)
                    .executeAndFetch(Staff.class);
        }
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE from staff WHERE id=:id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }

    }

    @Override
    public void clearAll() {
        String sql = "DELETE from staff";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql).executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }

    }
}
