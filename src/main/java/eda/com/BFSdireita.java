package eda.com;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class BFSdireita {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] arrayS = sc.nextLine().split(" ");

        BST bst = new BST();  
        Deque<NodeBST> queue = new LinkedList<NodeBST>();      

        for (int i = 0; i < arrayS.length; i++){
            bst.add(Integer.parseInt(arrayS[i]));
        }

        queue.addLast(bst.getRoot());

        while (!queue.isEmpty()){
            NodeBST current = queue.removeFirst();

            if (current.getRight() != null)
                queue.addLast(current.getRight());
            if (current.getLeft() != null)
                queue.addLast(current.getLeft());

            System.out.println(current.getValue());
        }        
     }
}