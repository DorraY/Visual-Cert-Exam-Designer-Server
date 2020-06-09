package com.Model;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Explication")
public class Explication {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @TableGenerator(name="sqlite", table="sqlite_sequence",
            pkColumnName="name", valueColumnName="seq",
            pkColumnValue="sqliteTestTable")
    @Column(name = "ex_code")
    private Integer exCode;

    @OneToOne
    @NotNull
    @JoinColumn(name = "ex_qucode" )
    private Question exQucode;

    @Column(name = "ex_texte")
    @NotNull
    private String exTextExplanation;

    public Explication() {
    }

    public Integer getExCode() {
        return exCode;
    }

    public void setExCode(Integer exCode) {
        this.exCode = exCode;
    }

    public Question getExQucode() {
        return exQucode;
    }

    public void setExQucode(Question exQucode) {
        this.exQucode = exQucode;
    }

    public String getExTextExplanation() {
        return exTextExplanation;
    }

    public void setExTextExplanation(String exTextExplanation) {
        this.exTextExplanation = exTextExplanation;
    }
}
