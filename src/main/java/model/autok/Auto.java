package model.autok;

import javax.persistence.*;

@Entity
public class Auto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "rendszam")
    private String rendszam;

    @Column(name = "tipus")
    private String tipus;

    @Column(name = "tulaj_id")
    private Integer tulaj_id;

    public Auto() {

    }

    public Auto(String rendszam, String tipus, Integer tulaj_id) {
        this.rendszam = rendszam;
        this.tipus = tipus;
        this.tulaj_id = tulaj_id;
    }

    public Auto(Integer id, String rendszam, String tipus, Integer tulaj_id) {
        this.id = id;
        this.rendszam = rendszam;
        this.tipus = tipus;
        this.tulaj_id = tulaj_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRendszam() {
        return rendszam;
    }

    public void setRendszam(String rendszam) {
        this.rendszam = rendszam;
    }

    public String getTipus() {
        return tipus;
    }

    public void setTipus(String tipus) {
        this.tipus = tipus;
    }

    public Integer getTulaj_id() {
        return tulaj_id;
    }

    public void setTulaj_id(Integer tulaj_id) {
        this.tulaj_id = tulaj_id;
    }

}
