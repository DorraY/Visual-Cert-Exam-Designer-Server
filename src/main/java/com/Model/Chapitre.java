package com.Model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Table(name = "Chapitre")
public class Chapitre {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @TableGenerator(name="sqlite", table="sqlite_sequence",
            pkColumnName="name", valueColumnName="seq",
            pkColumnValue="sqliteTestTable")
    private Integer chCode;


    private String chNom;

    public Chapitre() {
    }

    public Integer getChCode() {
        return chCode;
    }

    public void setChCode(Integer chCode) {
        this.chCode = chCode;
    }

    public String getChNom() {
        return chNom;
    }

    public void setChNom(String chNom) {
        this.chNom = chNom;
    }

    @Override
    public String toString() {
        return "Chapitre{" +
                "chCode=" + chCode +
                ", chNom='" + chNom + '\'' +
                '}';
    }
}
