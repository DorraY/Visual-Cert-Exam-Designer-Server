package com.Model;
import javax.persistence.*;

@Entity
@Table(name = "Explication")
public class Explication {

    @Id
    @GeneratedValue
    private int exCode;

    @OneToOne
    @JoinColumn(name = "ex_qucode" )
    private Question exQucode;
    private String exTextExplanation;

    public Explication() {
    }

    public int getExCode() {
        return exCode;
    }

    public void setExCode(int exCode) {
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