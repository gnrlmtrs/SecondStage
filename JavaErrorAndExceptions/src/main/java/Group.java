public class Group {
    private int id;
    private Faculty faculty;

    public Group(Faculty faculty, int id){
        this.faculty = faculty;
        this.id = id;
    }

    public Faculty setFaculty(){
        return this.faculty;
    }

    public Faculty getFaculty(){
        return faculty;
    }

    public int getId(){
        return id;
    }

    public int setId(){
        return this.id;
    }

    @Override
    public String toString(){
        return "Group ID: " + id
                +"\n{" + faculty.toString() + "}";
    }

}
