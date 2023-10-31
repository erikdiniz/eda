package eda.com;

import java.util.Scanner;
import java.util.Arrays;

class SelectionSortPassoaPasso {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String[] v = sc.nextLine().split(" ");

        for (int i = 0; i < v.length-1; i++){
            int menor = i;

            for (int j = i+1; j < v.length; j++){
                if (Integer.parseInt(v[j]) < Integer.parseInt(v[menor])){
                    menor = j;
                } 
            }
            if (menor != i){
                String aux = v[i];
                v[i] = v[menor];
                v[menor] = aux;
                System.out.println(Arrays.toString(v));
            }
        }
    }
}
