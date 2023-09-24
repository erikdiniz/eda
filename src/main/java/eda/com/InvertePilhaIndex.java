package eda.com;

/*
 * Classe cirada para exemplificar a utilização da pilha.
 */
public class InvertePilhaIndex {
    public static void main(String[] args){
        Stack pilha = new Stack(10);
        int[] array = new int[10];
        int index = 6;

        for (int i = 1; i <= pilha.size(); i++){
            pilha.push(i);
        }

        for (int i = index; i >= 0; i--){
            array[i] = pilha.pop();
        }

        int j = index+1;
        while (!pilha.isEmpty()){
            array[j] = pilha.pop();
            j++;
        }

        for (int i = 0; i < pilha.size(); i++) {
            System.out.println(array[i]);
        }
    }
}

class Stack {
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
        if (!isEmpty())
            return this.array[top--];
        else
            throw new StackOverflowError("errou");
            
    }
}
