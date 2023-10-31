package solucoes;

import java.util.Scanner;

import algoritmos.BST;
import algoritmos.NodeBST;

public class SomaFolhas {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        BST bst = new BST();

        String[] seq = sc.nextLine().split(" ");

        for (int i = 0; i < seq.length; i++){
            bst.add(Integer.parseInt(seq[i]));
        }

        System.out.println(somaFolhas(bst.getRoot()));
     
        
    }

    public static int somaFolhas(NodeBST node){
        int sum = 0;
        
        if (node == null)
            return 0;
        
        if (node.isLeaf()){
            sum += node.getValue();
        } else {
            sum += somaFolhas(node.getLeft());
            sum += somaFolhas(node.getRight());
        }
        
        return sum;
    }
}

