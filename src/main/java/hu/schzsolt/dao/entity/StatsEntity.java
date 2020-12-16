package hu.schzsolt.dao.entity;


import lombok.*;
import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "match_stats", schema="australianfootball")

public class StatsEntity {

    @EmbeddedId()
    private key key;

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @ToString
    @Embeddable
    public static class key implements java.io.Serializable{
        @Column(name="mid")
        private String mid;

        @Column(name="pid")
        private int pid;
    }

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ManyToOne
    @JoinColumn(name="tid")
    private TeamEntity team;

    @Column(name = "loc")
    private String location;

    @Column(name = "ki")
    private Integer kicks;

    @Column(name = "mk")
    private Integer marks;

    @Column(name = "hb")
    private Integer handballs;

    @Column(name = "di")
    private Integer disposals;

    @Column(name = "gl")
    private Integer goals;

    @Column(name = "bh")
    private Integer behinds;

    @Column(name = "ho")
    private Integer hitOuts;

    @Column(name = "tk")
    private Integer tackles;

    @Column(name = "rb")
    private Integer rebound50s;

    @Column(name = "if")
    private Integer inside50s;

    @Column(name = "cl")
    private Integer clearances;

    @Column(name = "cg")
    private Integer clangers;

    @Column(name = "ff")
    private Integer freeKicksFor;

    @Column(name = "fa")
    private Integer freeKicksAgainst;

    @Column(name = "br")
    private Integer brownlowVotes;

    @Column(name = "cp")
    private Integer contestedPossessions;

    @Column(name = "up")
    private Integer uncontestedPossessions;

    @Column(name = "cm")
    private Integer contestedMarks;

    @Column(name = "mi")
    private Integer marksInside50;

    @Column(name = "1p")
    private Float onePercenters;

    @Column(name = "bo")
    private Integer bounces;

    @Column(name = "ga")
    private Integer goalAssist;

    @Column(name = "pp")
    private Float percentageOfGamePlayed;
}