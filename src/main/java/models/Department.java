package models;

public class Department {
    String name;
    String description;
    int id;

    public Department(String name,String description){
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getId() {
        return id;
    }



}
