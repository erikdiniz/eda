package eda.com;

public class BuscaBinaria {
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