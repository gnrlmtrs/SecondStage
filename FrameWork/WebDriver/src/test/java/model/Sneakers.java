package model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sneakers {

    private String model;
    private String name;
    private String size;

    @Override
    public String toString() {
        return "Sneakers{" +
                "model='" + model + '\'' +
                ", name='" + name + '\'' +
                ", size='" + size + '\'' +
                '}';
    }
}
