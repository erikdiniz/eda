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

    public int[] inverteIndex(int index){          
        int[] v = new int[size()];
        int j = 0;

        for (int i = index; i >= 0; i--){
            v[i] = pop();
            j++;
        }

        while (!isEmpty()){
            v[j] = pop();
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
