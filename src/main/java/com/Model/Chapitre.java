package com.Model;

import javax.persistence.*;

@Entity
@Table(name = "Chapitre")
public class Chapitre {

    @Id
    @GeneratedValue
    private Integer chCode;

    private String chNom;

/*    @OneToMany(mappedBy = "quCode",fetch = FetchType.LAZY)
    private Set<Question> questions;*/

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
}
