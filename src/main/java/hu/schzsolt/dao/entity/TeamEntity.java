package hu.schzsolt.dao.entity;

import lombok.*;
import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "teams")

public class TeamEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "tid")
    private Integer id;

    @Column(name = "tname")
    private String teamName;
}
