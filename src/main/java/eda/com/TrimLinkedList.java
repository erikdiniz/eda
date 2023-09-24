package eda.com;

import java.util.Scanner;

class TrimLinkedList {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        String[] seq = sc.nextLine().split(" ");
        int extremos = sc.nextInt();
        LinkedList lista = new LinkedList();

        for (int i = 0; i < seq.length; i++){
            int num = Integer.parseInt(seq[i]);
            NodeLinkedList node = new NodeLinkedList(num, null, null);
            lista.addLast(node);
        }

        for (int i = 0; i < extremos; i++){
            if (lista.isEmpty()){
                System.out.println("vazia");
                break;
            } else {
                lista.removeFirst();
                lista.removeLast();
            }
        }

        System.out.println(lista.toString());
    }
}
