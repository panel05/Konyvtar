package modell;

import java.io.Serializable;
import java.util.Set;
import java.util.TreeSet;

public class Konyvtar implements Serializable {
    // private Set<Konyv> konyvek = new TreeSet<>();
   private Set<Konyv> konyvek;
    
    public Konyvtar() {
        konyvek = new TreeSet<>();
        
        this.konyvek.add(new Konyv("Cím 1", "Szerző 11", 2000));
        this.konyvek.add(new Konyv("Cím 2", "Szerző 21", "Szerző 22", 1986));
        this.konyvek.add(new Konyv("Cím 3", "Szerző 31", 2010));
    }

    public Set<Konyv> getKonyvek() {
        return konyvek;
    }

    public void setKonyvek(Set<Konyv> konyvek) {
        this.konyvek = konyvek;
    }
    
    public void konyvHozzaadas(Konyv konyv) {
        /*
        if(!(getKonyvek().isEmpty())) {
            
            boolean vanAzonos = false;
            for(Konyv konyvtarKonyv : this.konyvek) {
                if(konyv.compareTo(konyvtarKonyv) == 0) vanAzonos = true;
            }
            
            if(!vanAzonos) this.konyvek.add(konyv);
            
            if(!vanAzonos(konyv)) this.konyvek.add(konyv);
        }
        else this.konyvek.add(konyv);
        */
        if(getKonyvek().isEmpty() || !(vanAzonos(konyv))) this.konyvek.add(konyv);
    }
    
    public boolean vanAzonos(Konyv konyv) {
        boolean valasz = false;
        for(Konyv konyvtarKonyv : this.konyvek) {
            if(konyv.compareTo(konyvtarKonyv) == 0) {
                valasz = true;
            }
        }
        return valasz;
    }

    @Override
    public String toString() {
        return "Konyvtar{" + "konyvek=" + konyvek + '}';
    }
}
