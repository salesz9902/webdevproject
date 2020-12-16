package hu.schzsolt.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.sql.Timestamp;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class PlayerDto {
    private Integer id;
    private String firstName;
    private String lastName;
    private Integer height;
    private Integer weight;
    private String birthDate;
}
