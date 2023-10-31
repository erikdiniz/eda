package solucoes;
import java.util.Scanner;

import algoritmos.Stack;

class MaxPilhaIndex {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        String[] array = sc.nextLine().split(" ");
        Stack pilha = new Stack(array.length);

        for (int i = 0; i < array.length; i++){
            int num = Integer.parseInt(array[i]);
            pilha.push(num);
        }

        int index = sc.nextInt();

        System.out.println(pilha.getMax(index));
    }    
}
