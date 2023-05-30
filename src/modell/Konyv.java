package modell;

import java.io.Serializable;

public class Konyv implements Serializable, Comparable<Konyv> {
    private String cim, szerzo1, szerzo2;
    private int kiadasEve;
    
    public Konyv(String cim, String szerzo1, int kiadasEve) {
        this(cim, szerzo1, null, kiadasEve);
    }
    
    public Konyv(String cim, String szerzo1, String szerzo2, int kiadasEve) {
        this.cim = cim;
        this.szerzo1 = szerzo1;
        this.szerzo2 = szerzo2;
        this.kiadasEve = kiadasEve;
    }

    public String getCim() {
        return cim;
    }
    
    public String getSzerzo1() {
        return szerzo1;
    }

    public String getSzerzo2() {
        return szerzo2;
    }

    public int getKiadasEve() {
        return kiadasEve;
    }

    public void setCim(String cim) {
        this.cim = cim;
    }
    
    public void setSzerzo1(String szerzo1) {
        this.szerzo1 = szerzo1;
    }

    public void setSzerzo2(String szerzo2) {
        this.szerzo2 = szerzo2;
    }

    public void setKiadasEve(int kiadasEve) {
        this.kiadasEve = kiadasEve;
    }

    @Override
    public String toString() {
        return "Konyv{" + "cim=" + cim + ", szerzo1=" + szerzo1 + ", szerzo2=" + szerzo2 + ", kiadasEve=" + kiadasEve + '}';
    }

    @Override
    public int compareTo(Konyv konyv) {
        return this.cim.compareTo(konyv.getCim());
    }
}
