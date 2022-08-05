package models;

public abstract class News {
    public String title;
    public int author;
    public int id;

    public News(String title,int author){
        this.title = title;
        this.author = author;

    }

    public String getTitle() {
        return title;
    }

    public int getAuthor() {
        return author;
    }

    public int getId() {
        return id;
    }



    @Override
    public boolean equals(Object otherNews){
        if(!(otherNews instanceof News)){
            return false;
        }else{
            News newStory = (News) otherNews;
            return this.getTitle().equals(newStory.getTitle());
        }
    }

    public int setId(int id) {
        return this.id = id;
    }
}
