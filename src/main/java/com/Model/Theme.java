package com.Model;
import javax.persistence.*;

@Entity
@Table(name = "Theme")
public class Theme {

    @Id
    @GeneratedValue
    private Integer thCode;

    private String thNom;

/*    @OneToMany(mappedBy = "exId",fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<Examen> examens; // fel chakk*/

    public Theme(String thNom) {
        this.thNom = thNom;
    }

    public Theme() {
    }

    public Integer getThCode() {
        return thCode;
    }

    public void setThCode(Integer thCode) {
        this.thCode = thCode;
    }

    public String getThNom() {
        return thNom;
    }

    public void setThNom(String thNom) {
        this.thNom = thNom;
    }

}
