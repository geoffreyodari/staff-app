package models.dao;

import models.News;

import java.util.List;

public interface NewsDao {


    //DELETE
    void clearAll();
    //all users can delete articles
    void clearOne(int articleId);
}
