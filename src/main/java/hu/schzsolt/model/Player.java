package hu.schzsolt.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.sql.Timestamp;

@AllArgsConstructor
@ToString
@Getter
@EqualsAndHashCode
public class Player {

    private Integer id;
    private String firstName;
    private String lastName;
    private Integer height;
    private Integer weight;
    private Timestamp birthDate;

    public Player(String firstName, String lastName, Integer height, Integer weight, Timestamp birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.height = height;
        this.weight = weight;
        this.birthDate = birthDate;
    }
}
