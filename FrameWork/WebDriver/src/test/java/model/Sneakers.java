package model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sneakers {

    public String model;
    public String name;
    public String size;

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
