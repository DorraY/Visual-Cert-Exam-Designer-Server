package com.Model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Chapitre")
public class Chapitre {

    @Id
    @GeneratedValue
    private int chCode;

    private String chNom;

/*    @OneToMany(mappedBy = "quCode",fetch = FetchType.LAZY)
    private Set<Question> questions;*/

    public Chapitre() {
    }

    public int getChCode() {
        return chCode;
    }

    public void setChCode(int chCode) {
        this.chCode = chCode;
    }

    public String getChNom() {
        return chNom;
    }

    public void setChNom(String chNom) {
        this.chNom = chNom;
    }
}
