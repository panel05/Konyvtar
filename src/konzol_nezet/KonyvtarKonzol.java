package konzol_nezet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import modell.Konyv;
import modell.Konyvtar;
import java.util.Set;
import java.util.TreeSet;
import java.util.Comparator;

public class KonyvtarKonzol {
    private static Konyvtar konyvtar1, konyvtar2;
    private static Set<Konyv> konyvek;
    
    public static void main(String[] args) {
        konyvtar1 = new Konyvtar();
        konyvek = new TreeSet<>(Comparator.comparing(Konyv::getCim));
        
        konyvtarFeltoltes();
        konyvtarKonyvei(konyvtar1);
        
        szerializalas();
        deszerializalas();
        konyvtarKonyvei(konyvtar2);
    }
    
    public static void konyvtarKonyvei(Konyvtar konyvtar) {
        System.out.println("A könyvtár könyvei:");
        for(Konyv konyv : konyvtar.getKonyvek()) System.out.printf("Cím: %s, 1. szerző: %s, 2. szerző: %s, kiadás éve: %d\n", konyv.getCim(), konyv.getSzerzo1(), konyv.getSzerzo2(), konyv.getKiadasEve());
        System.out.println("");
    }
    
    public static void konyvtarFeltoltes() {
       Konyv konyv = new Konyv("Cím 0", "Szerző 41", "Szerző 42", 1950);
        konyvtar1.konyvHozzaadas(konyv);
        konyvtar1.konyvHozzaadas(konyv);
        
        // for(Konyv konyvtarKonyv : konyvtar1.getKonyvek()) System.out.println(konyvtarKonyv.getCim());
        // System.out.println(konyvtar1.getKonyvek().size());
    }
    
    public static void szerializalas() {
        try {
            FileOutputStream fileoutputstream = new FileOutputStream(new File("konyvtar.ser"));
            ObjectOutputStream objectoutputstream = new ObjectOutputStream(fileoutputstream);
            
            objectoutputstream.writeObject(konyvtar1);
            // for(Konyv konyv : konyvtar1.getKonyvek()) objectoutputstream.writeObject(konyv);
            
            objectoutputstream.close();
            fileoutputstream.close();
            
            System.out.println("Sikeres fájlba írás!\n");
        } catch (IOException e) {
            System.err.println(e);
        } catch (Exception e) {
            System.err.println(e);
        }
    }
    
    public static void deszerializalas() {
        try {
            FileInputStream fileinputstream = new FileInputStream(new File("konyvtar.ser"));
            ObjectInputStream objectinputstream = new ObjectInputStream(fileinputstream);
            
            konyvtar2 = (Konyvtar) objectinputstream.readObject();
            
            objectinputstream.close();
            fileinputstream.close();
            
            System.out.println("Sikeres fájlból olvasás!\n");
        } catch (FileNotFoundException e) {
            System.err.println(e);
        } catch (IOException e) {
            System.err.println(e);
        } catch (Exception e) {
            System.err.println();
        }
    }
}
