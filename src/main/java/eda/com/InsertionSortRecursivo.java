package eda.com;

import java.util.Scanner;
import java.util.Arrays;

class InsertionSortRecursivo {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String[] v = sc.nextLine().split(" ");
        insertionSort(v, 0, v.length-1);

        System.out.println(Arrays.toString(v));
    }   
    
    private static void insertionSort(String[] v, int ini, int fim){
        int i = ini;

        while (i < fim){
            if (Integer.parseInt(v[i]) > Integer.parseInt(v[i+1])){
                String aux = v[i];
                v[i] = v[i+1];
                v[i+1] = aux;
                i++;
            }
        }
    }
}
