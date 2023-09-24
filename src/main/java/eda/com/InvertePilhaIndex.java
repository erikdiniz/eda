package eda.com;

import eda.com.Stack;

/*
 * O programa recebe uma pilha como entrada, inverte os valores dessa pilha até um determinado índice também lido da entrada. Considere que o topo está no índice 0, o elemento abaixo dele no índice 1 e assim por diante.
 */
class InvertePilhaIndex {
    public static void main(String[] args){
        Stack pilha = new Stack(10);
        int[] array = new int[10];
        int index = 5;

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