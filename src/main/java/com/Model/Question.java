package com.Model;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Question")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @TableGenerator(name="sqlite", table="sqlite_sequence",
            pkColumnName="name", valueColumnName="seq",
            pkColumnValue="sqliteTestTable")
    @Column(name = "qu_code")
    private Integer quCode;

    @NotNull
    @Column(name = "qu_ordre")
    private Integer quOrdre;

    @NotNull
    @Column(name = "qu_text")
    private String quText;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "qu_chcode")
    private Chapitre quChCode;


    @NotNull
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

    public Integer getQuOrdre() {
        return quOrdre;
    }

    public void setQuOrdre(Integer quOrdre) {
        this.quOrdre = quOrdre;
    }

    public Chapitre getQuChCode() {
        return quChCode;
    }

    public void setQuChCode(Chapitre quChCode) {
        this.quChCode = quChCode;
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
