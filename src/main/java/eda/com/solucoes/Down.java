package solucoes;

import java.util.Scanner;

class Down {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] array = sc.nextLine().split(" ");
        int posicao = sc.nextInt();

        selectionSort(array, 0, array.length-1);
        String out = "";

        for (int i = 0; i < posicao; i++){
            out += array[i] + " ";
        }
        
        System.out.println(out.trim());      
    }

    private static void selectionSort(String[] v, int ini, int fim){
        for (int i = ini; i < fim; i++){
            int menor = i;
            for (int j = i+1; j <= fim; j++){
                if (Integer.parseInt(v[j]) < Integer.parseInt(v[i])){
                    menor = j;
                    swap(v, i, menor);                    
                }
            }
        }        
    }

    private static void swap(String[] v, int i,int j){
        String aux = v[i];
        v[i] = v[j];
        v[j] = aux;
    }
}