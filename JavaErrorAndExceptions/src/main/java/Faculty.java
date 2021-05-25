import java.util.HashMap;

public class Faculty {

    private String name;
    private int id;


    public Faculty(int id, String name){
        this.name = name;
        this.id = id;
    }




    public int setId(){
        return this.id;
    }

    public int getId(){
        return id;
    }

    public String setName(){
        return this.name;
    }

    public String getName(){
        return name;
    }


    public String toString(){
        return "Faculty name: " + name +
                "\nId of this faculty is: " + id;
    }



}
