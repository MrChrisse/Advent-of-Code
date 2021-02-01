package Math;

import java.util.ArrayList;

import static java.lang.Math.sqrt;

public class quadrate {

    public static void main(String[] args) {
        double result;
        ArrayList<Integer> result_i = new ArrayList<>();
        ArrayList<Integer> result_j = new ArrayList<>();
        ArrayList<Integer> result_k = new ArrayList<>();
        ArrayList<Double> result_final = new ArrayList<>();

        for (int i = 1; i<6; i++){
            for (int j = 1; j<50; j++){
                for (int k = 1; k<50; k++){
                    result = i + sqrt(j) + sqrt(k);
                    if(result >7.86 && result < 7.87){
                        result_i.add(i);
                        result_j.add(j);
                        result_k.add(k);
                    }
                }
            }
        }
        System.out.println(result_i);
        System.out.println(result_j);
        System.out.println(result_k);

        for(int l = 0; l < result_k.size(); l++){
            result = result_i.get(l) + result_j.get(l) + result_k.get(l);
            if(result < 18 && result > 7){
                result_final.add(result);
            }
        }
        result_final.stream().sorted().distinct().forEach(System.out::println);
    }
}
