package model.autok;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Tulaj {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nev")
    private String nev;

    @Column(name = "cim")
    private String cim;

    public Tulaj() {
    }

    public Tulaj(String nev, String cim) {
        this.nev = nev;
        this.cim = cim;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public String getCim() {
        return cim;
    }

    public void setCim(String cim) {
        this.cim = cim;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tulaj tulaj = (Tulaj) o;
        return Objects.equals(id, tulaj.id) &&
                Objects.equals(nev, tulaj.nev) &&
                Objects.equals(cim, tulaj.cim);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nev, cim);
    }
}
