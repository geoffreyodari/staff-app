package models.dao;

public interface NewsDao {
    //CREATE
   void add(Object object);

    //READ
    void all();
    void findByAuthor(int id);
    void findById(int id);
    //UPDATE

    //DELETE
    void clearAll();
    //all users can delete articles
    void clearOne(int articleId);
}
