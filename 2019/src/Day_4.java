import java.util.ArrayList;
import java.util.List;

public class Day_4 {
    public static void main(String[] args) {
        long aktuelleZahl = 108457;
        List<Long> Ergebnis = new ArrayList<>();
        while (aktuelleZahl<562042) {
            int[] aktuelleListe = ListeErzeugen(aktuelleZahl);
            boolean same = false;
            boolean increase = true;
            for(int j = 0; j < 5; j++){
                if (aktuelleListe[j] == aktuelleListe[j + 1]){
                    same = true;
                }
                if (aktuelleListe[j] > aktuelleListe[j+1]){
                    increase = false;
                }
            }
            if (same && increase){
                Ergebnis.add(aktuelleZahl);
            }
            aktuelleZahl++;
        }
        System.out.println(Ergebnis.toArray().length);
        System.out.println(Ergebnis);
    }

     public static int[] ListeErzeugen(long Zahl) {
         int[] temp_Zahl = new int[6];
         int count = 0;
         int i = 5;
         while (Zahl > 0) {
             int digit = (int) (Zahl % 10);
             if (digit == 1)
                 count++;
             temp_Zahl[i] = digit;
             i = i - 1;
             Zahl /= 10;
         }
         return temp_Zahl;
     }
}
