package solucoes;

import java.util.Scanner;
import java.util.Arrays;

class InsereUltimo {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String[] v = sc.nextLine().split(" ");
        
        for (int i = v.length-1; i > 0; i--){
            if (Integer.parseInt(v[i]) < Integer.parseInt(v[i-1])){
                String aux = v[i];
                v[i] = v[i-1];
                v[i-1] = aux;
            }
        }
        System.out.println(Arrays.toString(v));
    }
}
