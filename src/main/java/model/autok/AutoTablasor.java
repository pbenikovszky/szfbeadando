package model.autok;

public class AutoTablasor {

    private Integer id;
    private String rendszam;
    private String tipus;
    private String tulajdonos;

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

    public String getTulajdonos() {
        return tulajdonos;
    }

    public void setTulajdonos(String tulajdonos) {
        this.tulajdonos = tulajdonos;
    }

    public AutoTablasor(Auto auto, String tulajdonos) {
        this.id = auto.getId();
        this.rendszam = auto.getRendszam();
        this.tipus = auto.getTipus();
        this.tulajdonos = tulajdonos;
    }
}
