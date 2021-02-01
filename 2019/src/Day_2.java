import java.util.Arrays;
public class Day_2 {
    public static void main(String[] args) {
        int[] Liste = new int[]{1,0,0,3,1,1,2,3,1,3,4,3,1,5,0,3,2,13,1,19,1,9,19,23,2,23,13,27,1,27,9,31,2,31,6,35,1,5,35,39,1,10,39,43,2,43,6,47,1,10,47,51,2,6,51,55,1,5,55,59,1,59,9,63,1,13,63,67,2,6,67,71,1,5,71,75,2,6,75,79,2,79,6,83,1,13,83,87,1,9,87,91,1,9,91,95,1,5,95,99,1,5,99,103,2,13,103,107,1,6,107,111,1,9,111,115,2,6,115,119,1,13,119,123,1,123,6,127,1,127,5,131,2,10,131,135,2,135,10,139,1,13,139,143,1,10,143,147,1,2,147,151,1,6,151,0,99,2,14,0,0};
        System.out.println("Dies ist der Anfang:   " + Arrays.toString(Liste));
        System.out.println("Die Liste hat:   " + Liste.length);
        Liste[1]= 12;
        Liste[2]=2;

        boolean Draus = false;

        for (int i = 0; i < Liste.length; i += 4) {
            if (!Draus) {
                int i1 = Liste[i + 1];
                int i2 = Liste[i + 2];
                int i3 = Liste[i + 3];

                //System.out.println("Bin in der For-Schleife");
                switch (Liste[i]) {
                    case 1:
                        Liste[i3] = Liste[i1] + Liste[i2];
                        //System.out.println("Addieren");
                        break;
                    case 2:
                        Liste[i3] = Liste[i1] * Liste[i2];
                        //System.out.println("Multiplizieren");
                        break;
                    case 99:
                        System.out.println("Stop bei " + i);
                        Draus = true;
                        break;
                }
            }
        }
        System.out.println("Dies ist das Ergebnis: " + Arrays.toString(Liste));
    }
}
