package eda.com;

import java.util.Scanner;
import java.util.Arrays;

class TrocaVizinhos{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        String[] seqStr = sc.nextLine().split(" ");

        for (int i = 0; i < seqStr.length - 1; i = i + 2){
            String aux = seqStr[i];
            seqStr[i] = seqStr[i+1];
            seqStr[i+1] = aux;
        }
        System.out.println(Arrays.toString(seqStr));
    }
}