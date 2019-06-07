package model.szerelesek;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Muhely {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nev")
    private String nev;

    @Column(name = "cim")
    private String cim;

    @Column(name = "kapacitas")
    private Integer kapacitas;

    public Muhely() {}

    public Muhely(Integer id, String nev, String cim, Integer kapacitas) {
        this.id = id;
        this.nev = nev;
        this.cim = cim;
        this.kapacitas = kapacitas;
    }

    public Muhely(String nev, String cim, Integer kapacitas) {
        this.nev = nev;
        this.cim = cim;
        this.kapacitas = kapacitas;
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

    public Integer getKapacitas() {
        return kapacitas;
    }

    public void setKapacitas(Integer kapacitas) {
        this.kapacitas = kapacitas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Muhely muhely = (Muhely) o;
        return Objects.equals(id, muhely.id) &&
                Objects.equals(nev, muhely.nev) &&
                Objects.equals(cim, muhely.cim) &&
                Objects.equals(kapacitas, muhely.kapacitas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nev, cim, kapacitas);
    }
}
