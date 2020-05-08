package com.Model;
import javax.persistence.*;

@Entity
@Table(name = "Question")
public class Question {

    @Id
    @GeneratedValue
    private Integer quCode;
    private int ordre;

    @ManyToOne
    @JoinColumn(name = "qu_chcode")
    private Chapitre chCode;

    @OneToOne
    @JoinColumn(name = "qu_exccode")
    private Examen exCode;

    //@OneToMany(mappedBy = "choixCode",fetch = FetchType.LAZY)
    /*@OneToMany(targetEntity = Choix.class,mappedBy = "choixCode")
    private Set<Choix> choixes;*/

    public Integer getQuCode() {
        return quCode;
    }

    public void setQuCode(Integer quCode) {
        this.quCode = quCode;
    }

    public int getOrdre() {
        return ordre;
    }

    public void setOrdre(int ordre) {
        this.ordre = ordre;
    }
}
