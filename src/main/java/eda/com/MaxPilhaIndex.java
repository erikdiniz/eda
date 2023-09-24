package eda.com;
import java.util.Scanner;

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
        int maior = pilha.peek();
        int j = 0;

        while (j <= index){
            int num = pilha.pop();

            if (num > maior){
                maior = num;
            }
            j++;
        }

        System.out.println(maior);
    }    
}
