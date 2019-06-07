package model.szerelesek;

public class SzerelesTablasor {

    private Integer id;
    private String rendszam;
    private String muhely;
    private String szerelo;
    private Integer statusz;
    private Integer ar;

    public SzerelesTablasor() {
    }

    public SzerelesTablasor(Integer id, String rendszam, String muhely, String szerelo, Integer statusz, Integer ar) {
        this.id = id;
        this.rendszam = rendszam;
        this.muhely = muhely;
        this.szerelo = szerelo;
        this.statusz = statusz;
        this.ar = ar;
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

    public String getMuhely() {
        return muhely;
    }

    public void setMuhely(String muhely) {
        this.muhely = muhely;
    }

    public String getSzerelo() {
        return szerelo;
    }

    public void setSzerelo(String szerelo) {
        this.szerelo = szerelo;
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
}
