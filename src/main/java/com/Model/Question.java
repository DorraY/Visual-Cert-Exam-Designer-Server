package com.Model;
import javax.persistence.*;

@Entity
@Table(name = "Question")
public class Question {

    @Id
    @GeneratedValue
    @Column(name = "qu_code")
    private Integer quCode;

    @Column(name = "qu_ordre")
    private Integer ordre;

    @Column(name = "qu_text")
    private String quText;

    @ManyToOne
    @JoinColumn(name = "qu_chcode")
    private Chapitre chCode;

    @ManyToOne
    @JoinColumn(name = "qu_exccode")
    private Examen exCode;


/*    @OneToMany(mappedBy = "choixCode",fetch = FetchType.LAZY)
    private Set<Choix> choixes;*/

    public Integer getQuCode() {
        return quCode;
    }

    public void setQuCode(Integer quCode) {
        this.quCode = quCode;
    }

    public Integer getOrdre() {
        return ordre;
    }

    public void setOrdre(Integer ordre) {
        this.ordre = ordre;
    }

    public Chapitre getChCode() {
        return chCode;
    }

    public void setChCode(Chapitre chCode) {
        this.chCode = chCode;
    }

    public Examen getExCode() {
        return exCode;
    }

    public void setExCode(Examen exCode) {
        this.exCode = exCode;
    }

    public String getQuText() {
        return quText;
    }

    public void setQuText(String quText) {
        this.quText = quText;
    }
}
