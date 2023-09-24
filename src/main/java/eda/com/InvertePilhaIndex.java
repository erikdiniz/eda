package eda.com;
import eda.com.Stack;

/*
 * Classe cirada para exemplificar a utilização da pilha.
 */
class InvertePilhaIndex {
    public static void main(String[] args){
        Stack pilha = new Stack(10);
        int[] array = new int[10];
        int index = 6;

        for (int i = 1; i <= pilha.size(); i++){
            pilha.push(i);
        }

        for (int i = index; i >= 0; i--){
            array[i] = pilha.pop();
        }

        int j = index+1;
        while (!pilha.isEmpty()){
            array[j] = pilha.pop();
            j++;
        }

        for (int i = 0; i < pilha.size(); i++) {
            System.out.println(array[i]);
        }
    }
}