package model.szerelesek;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Szerelo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nev")
    private String nev;

    @Column(name = "muhely_id")
    private Integer muhely_id;

    public Szerelo() {
    }

    public Szerelo(String nev, Integer muhely_id) {
        this.nev = nev;
        this.muhely_id = muhely_id;
    }

    public Szerelo(Integer id, String nev, Integer muhely_id) {
        this.id = id;
        this.nev = nev;
        this.muhely_id = muhely_id;
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

    public Integer getMuhely_id() {
        return muhely_id;
    }

    public void setMuhely_id(Integer muhely_id) {
        this.muhely_id = muhely_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Szerelo szerelo = (Szerelo) o;
        return Objects.equals(id, szerelo.id) &&
                Objects.equals(nev, szerelo.nev) &&
                Objects.equals(muhely_id, szerelo.muhely_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nev, muhely_id);
    }
}
