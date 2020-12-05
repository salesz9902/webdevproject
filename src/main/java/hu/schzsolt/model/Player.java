package hu.schzsolt.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Getter
@EqualsAndHashCode
public class Player {

    private String firstName;
    private String lastName;
    private String height;
    private String weight;
    private String birthDate;
}
