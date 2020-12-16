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

    private String firstName;
    private String lastName;
    private Integer height;
    private Integer weight;
    private Timestamp birthDate;
}
