package com.Model;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Table(name = "Theme")
public class Theme {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @TableGenerator(name="sqlite", table="sqlite_sequence",
            pkColumnName="name", valueColumnName="seq",
            pkColumnValue="sqliteTestTable")
    private Integer thCode;

    @NotNull
    private String thNom;

/*    @OneToMany(mappedBy = "exId",fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<Examen> examens;*/

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

    @Override
    public String toString() {
        return "Theme{" +
                "thCode=" + thCode +
                ", thNom='" + thNom + '\'' +
                '}';
    }
}
