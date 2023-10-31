package solucoes;

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
        if (fim <= 0) {
            return;
        }

        insertionSort(v, ini, fim - 1);

        String currentElement = v[fim];
        int i = fim - 1;

        while (i >= 0 && Integer.parseInt(v[i]) > Integer.parseInt(currentElement)) {
            v[i + 1] = v[i];
            i--;
        }

        v[i + 1] = currentElement;
    }
}
