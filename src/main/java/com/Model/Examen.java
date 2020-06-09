package com.Model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Table(name = "Examen")
public class Examen {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @TableGenerator(name="sqlite", table="sqlite_sequence",
            pkColumnName="name", valueColumnName="seq",
            pkColumnValue="sqliteTestTable")
    @Column(name = "ex_id")
    private Integer exId;

    @Column(name = "ex_nom")
    @NotNull
    private String exNom;

    @NotNull
    private int exTime;

    @NotNull
    private int exScore;

    public Examen() {
    }

    public Examen(String exNom, int exTime, int exScore, Theme exThCode) {
        this.exNom = exNom;
        this.exTime = exTime;
        this.exScore = exScore;
        this.exThCode = exThCode;
    }

    @ManyToOne
    @JoinColumn(name = "ex_thcode")
    private Theme exThCode;

/*    @OneToMany(mappedBy = "quCode")
    private Set<Question> questions;*/


    public Integer getExId() {
        return exId;
    }

    public void setExId(Integer exId) {
        this.exId = exId;
    }

    public String getExNom() {
        return exNom;
    }

    public void setExNom(String exNom) {
        this.exNom = exNom;
    }

    public int getExTime() {
        return exTime;
    }

    public void setExTime(int exTime) {
        this.exTime = exTime;
    }

    public int getExScore() {
        return exScore;
    }

    public void setExScore(int exScore) {
        this.exScore = exScore;
    }

    public Theme getExThCode() {
        return exThCode;
    }

    public void setExThCode(Theme exThCode) {
        this.exThCode = exThCode;
    }


}
