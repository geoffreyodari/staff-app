package models;

import java.util.List;
import java.util.Objects;

public class Department {
    private String name;
    private String description;
    private int id;



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


    public int setId(int id) {
        return this.id = id;
    }

    @Override
    public boolean equals(Object o){
        if(this==o) return true;
        if(!(o instanceof Department)){
            return false;
        }else{
            Department that = (Department) o;
            return  id == that.id &&
                    Objects.equals(name, that.name)&&
                    Objects.equals(description, that.description);


        }

    }
}
