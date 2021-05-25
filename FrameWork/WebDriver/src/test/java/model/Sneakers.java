package model;

public class Sneakers {

    public String model;
    public String name;
    public String size;

    public Sneakers(String model, String name, String size){

        this.model = model;
        this.name = name;
        this.size = size;
    }

    public String getSneakersModel() {
        return model;
    }

    public String getSneakersSize() {
        return size;
    }

    public String getSneakersName() {
        return name;
    }

}
