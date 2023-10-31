package solucoes;

import java.util.Scanner;

import algoritmos.BST;
import algoritmos.NodeBST;

/*
 * Escreva um programa que leia os números a serem adicionados
 * em uma BST e os números a serem removidos (em sequência)
 * dessa árvore. Seu programa deve imprimir o estado da árvore
 * (pré-ordem) a cada remoção.
 * 
 * Importante! A remoção de um nó com dois filhos deve sempre
 * ser realizada utilizando o sucessor do nó a ser removido.
 */
public class RemocaoBST {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        BST bst = new BST();

        String[] toAdd = sc.nextLine().split(" ");
        String[] toRemove = sc.nextLine().split(" ");

        for (int i = 0; i < toAdd.length; i++){
            bst.add(Integer.parseInt(toAdd[i]));
        }

        int cont = toRemove.length;
        int index = 0;

        while (cont > 0){
            NodeBST node = bst.search(Integer.parseInt(toRemove[index]));
            
            bst.remove(node);
            index += 1;
            cont -= 1;
            System.out.println("Remoção " + index);
            bst.preOrder();
        }
    }
}
