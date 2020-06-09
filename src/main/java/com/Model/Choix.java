package com.Model;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Choix")
public class Choix {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @TableGenerator(name="sqlite", table="sqlite_sequence",
            pkColumnName="name", valueColumnName="seq",
            pkColumnValue="sqliteTestTable")
    @Column(name = "ch_code")
    private Integer choixCode;

    @Column(name = "ch_texte")
    private String chText;

    @Column(name = "ch_correct")
    private Integer chCorrect;

    @Column(name = "ch_ordre")
    private Integer choixOrdre;

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

    public Integer getChCorrect() {
        return chCorrect;
    }

    public void setChCorrect(Integer chCorrect) {
        this.chCorrect = chCorrect;
    }

    public Integer getChoixOrdre() {
        return choixOrdre;
    }

    public void setChoixOrdre(Integer choixOrdre) {
        this.choixOrdre = choixOrdre;
    }

    public Question getChQuCode() {
        return chQuCode;
    }

    public void setChQuCode(Question chQuCode) {
        this.chQuCode = chQuCode;
    }
}
