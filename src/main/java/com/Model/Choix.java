package com.Model;
import javax.persistence.*;

@Entity
@Table(name = "Choix")
public class Choix {

    @Id
    @GeneratedValue
    private Integer choixCode;

    private String chText;
    private int chCorrect;

    @ManyToOne
    @JoinColumn(name = "ch_qucode")
    private Question chQuCode;

    public Integer getChoixCode() {
        return choixCode;
    }

    public void setChoixCode(Integer choixCode) {
        this.choixCode = choixCode;
    }

    public String getChText() {
        return chText;
    }

    public void setChText(String chText) {
        this.chText = chText;
    }

    public int getChCorrect() {
        return chCorrect;
    }

    public void setChCorrect(int chCorrect) {
        this.chCorrect = chCorrect;
    }
}
