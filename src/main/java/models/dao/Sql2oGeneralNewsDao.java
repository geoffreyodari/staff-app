package models.dao;

import models.GeneralNews;
import models.News;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oGeneralNewsDao implements NewsDao{
    private final Sql2o sql2o;
    public Sql2oGeneralNewsDao(Sql2o sql2o) {

        this.sql2o = sql2o;
    }


    public void add(GeneralNews generalNews) {
        String sql = "INSERT INTO news (title, author, type, contenturl) VALUES (:title, :author, 'general', :contentUrl)";
        try (Connection con = sql2o.open()) {
            int id = (int) con.createQuery(sql, true)
                    .bind(generalNews)
                    .executeUpdate()
                    .getKey();
            generalNews.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }

    }




    public List<GeneralNews> all() {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM news WHERE type='general'" )
                    .throwOnMappingFailure(false)
                    .executeAndFetch(GeneralNews.class);
        }
    }


    public List<GeneralNews> findByAuthor(int id) {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM news WHERE author=:id AND type='general'")
                    .addParameter("id", id)
                    .throwOnMappingFailure(false)
                    .executeAndFetch(GeneralNews.class);
        }
    }

    public List<GeneralNews> findById(int id) {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM news WHERE id=:id AND type='general'")
                    .addParameter("id", id)
                    .throwOnMappingFailure(false)
                    .executeAndFetch(GeneralNews.class);
        }
    }

    @Override
    public void clearAll() {
        String sql = "DELETE from news WHERE type='general'";
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
