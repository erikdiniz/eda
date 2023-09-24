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
}
