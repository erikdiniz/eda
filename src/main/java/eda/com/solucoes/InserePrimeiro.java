package solucoes;

import java.util.Scanner;
import java.util.Arrays;

class InserePrimeiro {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String[] v = sc.nextLine().split(" ");
        boolean trocou = true;
        int i = 0;

        while(trocou && i < v.length-1){
            if (Integer.parseInt(v[i]) <= Integer.parseInt(v[i+1])){
                trocou = false;
            } else {
                String aux = v[i];
                v[i] = v[i+1];
                v[i+1] = aux;
                i++;
            }
        }
        System.out.println(Arrays.toString(v));
    }    
}
