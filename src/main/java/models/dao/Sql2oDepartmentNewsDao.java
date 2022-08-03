package models.dao;

import models.Department;
import models.DepartmentNews;
import models.GeneralNews;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oDepartmentNewsDao implements NewsDao {
    private final Sql2o sql2o;

    public Sql2oDepartmentNewsDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    public void add(DepartmentNews departmentNews) {
        String sql = "INSERT INTO news (title, author, type, contenturl,department) VALUES (:title, :author, :type, :contentUrl,:department)";
        try (Connection con = sql2o.open()) {
            int id = (int) con.createQuery(sql, true)
                    .bind(departmentNews)
                    .executeUpdate()
                    .getKey();
            departmentNews.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }

    }


    public List<DepartmentNews> all() {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM news WHERE type='departmental'")
                    .throwOnMappingFailure(false)
                    .executeAndFetch(DepartmentNews.class);
        }
    }


    public List<DepartmentNews> findByAuthor(int id) {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM news WHERE author=:id AND type='departmental'")
                    .addParameter("id", id)
                    .throwOnMappingFailure(false)
                    .executeAndFetch(DepartmentNews.class);
        }
    }

    public List<DepartmentNews> findById(int id) {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM news WHERE id=:id AND type='departmental'")
                    .addParameter("id", id)
                    .throwOnMappingFailure(false)
                    .executeAndFetch(DepartmentNews.class);
        }
    }

    public List<DepartmentNews> findByDepartmentId(int id) {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM news WHERE department =:id")
                    .addParameter("id", id)
                    .throwOnMappingFailure(false)
                    .executeAndFetch(DepartmentNews.class);
        }
    }

    @Override
    public void clearAll() {
        String sql = "DELETE from news WHERE type='departmental'";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void clearOne(int articleId) {
        String sql = "DELETE from news WHERE id=:id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", articleId)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }

    }

}
