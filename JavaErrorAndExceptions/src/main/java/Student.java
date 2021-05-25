import java.util.HashMap;

public class Student {


    private String name;
    private int id;
    private Group group;
    private HashMap<String, Integer> marks;

    public Student(String name, int id, Group group ){
        this.name = name;
        this.id = id;
        this.group = group;
        marks = new HashMap();
    }

    public String getName(){
        return name;
    }

    public String setName(){
        return this.name;
    }

    public int getId(){
        return id;
    }

    public int setId(){
        return this.id;
    }

    public Group getGroup() {
        return group;
    }

    public Group setGroup(){
        return this.group;
    }


}
