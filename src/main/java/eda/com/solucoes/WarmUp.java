package solucoes;

import java.util.Scanner;

class WarmUp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        String[] seq = sc.nextLine().split(" ");

        String out = "";

        for (int i = 0; i<seq.length; i++){
            out = out + Integer.parseInt(seq[i])*n + " ";
        }

        System.out.println(out.trim());
    }
}