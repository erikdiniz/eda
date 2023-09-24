package eda.com;

import java.util.Scanner;

class InvertePilhaIndex {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int tamanho = sc.nextInt();
        String[] v = sc.nextLine().split(" ");
        String limpaBuffer = sc.nextLine();
        int index = sc.nextInt();

        
        int[] array = new int[tamanho];
        int j = 0;

        for (int i = index; i < tamanho; i++){
            array[j] = Integer.parseInt(v[i]);
            j++;
        }

        for (int i = index - 1; i >= 0; i--){
            array[j] = Integer.parseInt(v[i]);
            j++;
        }

        System.out.println("-");

        for (int i = 0; i < tamanho; i++){
            System.out.println(array[i]);
        }
    }
}