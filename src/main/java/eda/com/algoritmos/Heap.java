package algoritmos;

import java.util.Arrays;

public class Heap {
    private int[] heap;
    private int tail;

    public Heap(int capacidade){
        this.heap = new int[capacidade];
        this.tail = -1;
    }

    public Heap(int[] array){
        this.heap = array;
        this.tail = this.heap.length - 1;
        this.buildHeap();
    }

    public boolean isEmpty(){
        return this.tail == -1;
    }

    private int left(int index){
        return 2*index + 1;
    }

    private int right(int index){
        return 2*(index+1);
    }

    private int parent(int index){
        return (index-1)/2;
    }

    private void resize(){
        int[] aux = new int[this.heap.length*2];

        for (int i = 0; i < this.heap.length; i++){
            aux[i] = this.heap[i];
        }

        this.heap = aux;
    }

    public void add(int element){
        if (this.tail >= this.heap.length-1)
            resize();
        
        tail += 1;
        this.heap[tail] = element;

        int i = tail;

        while ((i > 0) && (heap[i] > heap[parent(i)])){
            int aux = heap[parent(i)];
            heap[parent(i)] = heap[i];
            heap[i] = aux;

            i = parent(i);
        }
    }

    public int remove(){
        if (isEmpty())
            throw new RuntimeException("Está vazio");

        int element = this.heap[0];
        this.heap[0] = this.heap[tail];
        tail -= 1;

        heapify(0);

        return element;
    }

    private void heapify(int index){
        if (validIndex(index) && !isLeaf(index)){
        
            int maior = maxIndex(index, left(index), right(index));

            if (maior != index) {
                swap(index, maior);
                heapify(maior);
            }
        }
    }

    private void swap(int i, int j){
        int aux = this.heap[i];
        heap[i] = heap[j];
        heap[j] = aux;
    }

    private boolean isLeaf(int index){
        return index > parent(tail) && index <= tail;
    }

    private int maxIndex(int index, int left, int right){
        if (this.heap[index] > this.heap[left]) {
            if (validIndex(right)) {
                if (this.heap[index] < this.heap[right])
                    return right;
            }
           
            return index;
        
        } else {
            if (validIndex(right)) {
                if (this.heap[left] < this.heap[right])
                    return right;
            } 
            
            return left;
        }
    }

    private boolean validIndex(int index){
        return index >= 0 && index <= tail;
    }

    private void buildHeap(){
        for (int i = parent(tail); i >= 0; i--)
            heapify(i);
    }
    
    public String toString(){
        return Arrays.toString(heap);
    }
}
