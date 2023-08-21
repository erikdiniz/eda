package eda.com;

import java.util.Scanner;

class MarianaLivros{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String[] v = sc.nextLine().split(",");
        System.out.println(formataString(v));
        insertionSort(v, 0, v.length-1);
    }

    private static void insertionSort(String[] v, int ini, int fim){
        for (int i = ini+1; i <= fim; i++){
            int j = i;

            while ((j > 0) && (v[j].compareTo(v[j-1]) < 0)){
                swap(v, j, j-1);
                j--;
            }
            System.out.println(formataString(v));
        }
    }

    private static void swap(String[] v, int i, int j){
        String aux = v[i];
        v[i] = v[j];
        v[j] = aux;
    }

    private static String formataString(String[] v){
        String retorno = "";

        for (int i = 0; i < v.length; i++){
            retorno += v[i] + ", ";
        }

        return retorno.substring(0, retorno.length()-2);
    }
}