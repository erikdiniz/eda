package solucoes;

import java.util.Scanner;

class ElementosDuplicados {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String[] v = sc.nextLine().split(" ");
        boolean rep = false;

        for (int i = 0; i < v.length-1; i++){
            for (int j = i+1; j < v.length; j++){
                if (v[i].equals(v[j])){
                    rep = true;
                }
            }
        }
        System.out.println(rep);
    }
}