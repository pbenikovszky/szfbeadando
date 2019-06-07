package model.szerelesek;

public class SzereloTablasor {

    private Integer id;
    private String nev;
    private String muhely;

    public SzereloTablasor(Szerelo szerelo, String muhelynev) {
        this.id = szerelo.getId();
        this.nev = szerelo.getNev();
        this.muhely = muhelynev;
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

    public String getMuhely() {
        return muhely;
    }

    public void setMuhely(String muhely) {
        this.muhely = muhely;
    }
}
