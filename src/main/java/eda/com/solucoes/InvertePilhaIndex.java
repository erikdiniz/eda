package solucoes;

import algoritmos.Stack;

/*
 * O programa recebe uma pilha como entrada, inverte os 
 * valores dessa pilha até um determinado índice também lido 
 * da entrada. Considere que o topo está no índice 0, o 
 * elemento abaixo dele no índice 1 e assim por diante.
 */
class InvertePilhaIndex {
    public static void main(String[] args){
        Stack pilha = new Stack(10);
        int index = 4;

        for (int i = 1; i <= pilha.size(); i++){
            pilha.push(i);
        }

        int[] v = pilha.inverteIndex(index);

        for (int i = 0; i < v.length; i++) {
            System.out.println(v[i]);
        }
    }
}