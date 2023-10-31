package eda.com;

import java.util.Scanner;
import java.util.Arrays;

class SelectionSortRecursivo {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String[] v = sc.nextLine().split(" ");
        selectionSort(v, 0, v.length-1);
    }


    private static String[] selectionSort(String[] v, int ini, int fim){
        int menor = ini;
        for (int i = ini+1; i <= fim; i++){
            if (Integer.parseInt(v[i]) <= Integer.parseInt(v[menor])){
                menor = i;
            }
        }

        if (menor != ini){
            String aux = v[ini];
            v[ini] = v[menor];
            v[menor] = aux;
        }
        if (ini < fim){
            System.out.println(Arrays.toString(v));
            ini += 1;
            return selectionSort(v, ini, fim);
        } else {
            return null;
        }
    }
}
