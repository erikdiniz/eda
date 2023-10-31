package solucoes;

import java.util.Scanner;
import java.util.Arrays;

class Move {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String[] array = sc.nextLine().split(" ");

        for (int i = 0; i < array.length-1; i++){
            int j = i+1;
            boolean troca = false;

            if (Integer.parseInt(array[i]) > Integer.parseInt(array[j])){
                troca = true;
                swap(array, i, j);
                i = -1;                
                System.out.println(Arrays.toString(array));
            }
        }
    }
    
    private static void swap(String[] v, int i, int j){
        String aux = v[i];
        v[i] = v[j];
        v[j] = aux;
    }
}