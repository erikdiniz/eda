package eda.com;

public class BuscaBinaria {
    public static void main(String[] args){
        int[] v = new int[]{1,2,3,4,5,6,7,8,9};
        int retorno = buscaBinaria(v, 8, 0, v.length-1);

        System.out.println(retorno);
    }
    

    public static int buscaBinaria(int[] v, int n, int ini, int fim){
        int meio = (ini+fim)/2;

        if(ini < fim){        
            if (v[meio] == n){
                return meio;
            } else if (v[meio] > n){
              return buscaBinaria(v, n, ini, meio-1);
            } else {
                return buscaBinaria(v, n, meio+1, fim);
            }
        } else {
            return -1;
        }
    }
}


