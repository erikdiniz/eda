package eda.com;

public class Stack {
    private int[] array;
    private int top;

    public Stack(int tamanho){
        this.array = new int[tamanho];
        this.top = -1;
    }

    public boolean isEmpty(){
        return this.top == -1;
    }

    public boolean isFull(){
        return this.top == array.length - 1;
    }

    public int size(){
        return array.length;
    }

    public int peek(){
        return array[top];
    }

    public void push(int num){
        this.top += 1;
        this.array[top] = num;
    }

    public int pop(){
        return this.array[top--];            
    }

    private Stack copia(){
        Stack copia = new Stack(size());
        int[] v = new int[size()];
        
        for (int i = v.length-1; i >= 0; i--){
            v[i] = pop();
        }

        for (int i = 0; i < v.length; i++){
            push(v[i]);
        }

        for (int i = 0; i < v.length; i++){
            copia.push(v[i]);
        }

        return copia;
    }

    public int[] inverteIndex(int index){          
        int[] v = new int[size()];
        int j = 0;
        Stack copia = copia();

        for (int i = index; i >= 0; i--){
            v[i] = copia.pop();
            j++;
        }

        while (!copia.isEmpty()){
            v[j] = copia.pop();
            j++;
        }
        
        return v;
    }

    public int getMax(int index){
        int maior = peek();
        int[] v = new int[size()];
        int j = 0;

        while (j <= index) {
            v[j] = pop();

            if (v[j] > maior){
                maior = v[j];
            }

            j++;
        }

        j--;
        while (j >= 0){
            push(v[j]);
            j--;
        }

        return maior;
    }
}
