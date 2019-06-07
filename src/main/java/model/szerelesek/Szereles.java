package model.szerelesek;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Szereles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "auto_id")
    private Integer auto_id;

    @Column(name = "muhely_id")
    private Integer muhely_id;

    @Column(name = "szerelo_id")
    private Integer szerelo_id;

    @Column(name = "statusz")
    private Integer statusz;

    @Column(name = "ar")
    private Integer ar;

    @Column(name = "fizetve")
    private boolean fizetve;


    public Szereles() {
    }

    public Szereles(Integer auto_id, Integer muhely_id, Integer szerelo_id, Integer statusz, Integer ar, boolean fizetve) {
        this.auto_id = auto_id;
        this.muhely_id = muhely_id;
        this.szerelo_id = szerelo_id;
        this.statusz = statusz;
        this.ar = ar;
        this.fizetve = fizetve;
    }

    public Szereles(Integer id, Integer auto_id, Integer muhely_id, Integer szerelo_id, Integer statusz, Integer ar, boolean fizetve) {
        this.id = id;
        this.auto_id = auto_id;
        this.muhely_id = muhely_id;
        this.szerelo_id = szerelo_id;
        this.statusz = statusz;
        this.ar = ar;
        this.fizetve = fizetve;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAuto_id() {
        return auto_id;
    }

    public void setAuto_id(Integer auto_id) {
        this.auto_id = auto_id;
    }

    public Integer getMuhely_id() {
        return muhely_id;
    }

    public void setMuhely_id(Integer muhely_id) {
        this.muhely_id = muhely_id;
    }

    public Integer getSzerelo_id() {
        return szerelo_id;
    }

    public void setSzerelo_id(Integer szerelo_id) {
        this.szerelo_id = szerelo_id;
    }

    public Integer getStatusz() {
        return statusz;
    }

    public void setStatusz(Integer statusz) {
        this.statusz = statusz;
    }

    public Integer getAr() {
        return ar;
    }

    public void setAr(Integer ar) {
        this.ar = ar;
    }

    public boolean isFizetve() {
        return fizetve;
    }

    public void setFizetve(boolean fizetve) {
        this.fizetve = fizetve;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Szereles szereles = (Szereles) o;
        return fizetve == szereles.fizetve &&
                Objects.equals(id, szereles.id) &&
                Objects.equals(auto_id, szereles.auto_id) &&
                Objects.equals(muhely_id, szereles.muhely_id) &&
                Objects.equals(szerelo_id, szereles.szerelo_id) &&
                Objects.equals(statusz, szereles.statusz) &&
                Objects.equals(ar, szereles.ar);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, auto_id, muhely_id, szerelo_id, statusz, ar, fizetve);
    }
}
