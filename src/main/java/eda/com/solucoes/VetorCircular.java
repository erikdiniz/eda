package solucoes;

import java.util.Scanner;

class VetorCircular {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String[] seq = sc.nextLine().split(" ");
        int qntd = sc.nextInt();

        String out = "";

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < qntd){                                           
            if (k == seq.length){                                   
                j = 0;
                k = 0;
            }
            out += seq[j] + " ";
            i++;
            j++;
            k++;
        }
        System.out.println(out.trim());
    }
}