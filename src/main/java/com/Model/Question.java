package com.Model;
import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Question")
public class Question {

    @Id
    @GeneratedValue
    private int quCode;
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

    public int getQuCode() {
        return quCode;
    }

    public void setQuCode(int quCode) {
        this.quCode = quCode;
    }

    public int getOrdre() {
        return ordre;
    }

    public void setOrdre(int ordre) {
        this.ordre = ordre;
    }
}
