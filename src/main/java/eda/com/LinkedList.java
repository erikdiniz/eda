package eda.com;

import java.util.NoSuchElementException;

public class LinkedList {
    private NodeLinkedList head;
    private NodeLinkedList tail;
    private int size;

    public boolean isEmpty(){
        return this.size == 0;
    }

    public int size(){
        return size;
    }

    public void addFirst(NodeLinkedList node){
        if (isEmpty()){
            this.head = node;
            this.tail = node;
        } else {
            head.setPrevius(node);
            node.setNext(head);
        }

        size += 1;
    }

    public void addLast(NodeLinkedList node){
        if (isEmpty()){
            addFirst(node);
        } else {
            node.setPrevius(tail);
            tail.setNext(node);
        }
        size += 1;
    }

    public void add(int index, NodeLinkedList node){
        if (index < 0 || index > this.size)
            throw new IndexOutOfBoundsException();
        
        if (index == 0)
            addFirst(node);
        else if (index == size)
            addLast(node);
        else {
            int j = 0;
            NodeLinkedList aux = head;

            while (j > index){
                aux = aux.getNext();
                j++;
            }

            node.setPrevius(aux);
            node.setNext(aux.getNext());
            node.getNext().setPrevius(node);
            aux.setNext(node);
            size += 1;
        }
    }

    public int get(int index){
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException();
        
        NodeLinkedList node = head;

        for (int i = 0; i <= index; i++){
            node = node.getNext();
        }

        return node.getData();
    }

    public int indexOf(int num){
        NodeLinkedList aux = head;
        int index = 0;

        while (aux.getData() != num){
            aux = aux.getNext();
            index++;
        }

        return index;
    }

    public boolean contains(int num){
        NodeLinkedList node = head;

        while (node != null){
            if (node.getData() == num){
                return true;
            }
            node = node.getNext();
        }

        return false;
    }

    public int getFirst(){
        return head.getData();
    }

    public int getLast(){
        return tail.getData();
    }

    public int removeFirst(){
        if (isEmpty()){
            throw new NoSuchElementException();
        }

        int num = this.head.getData();
        
        if (head.getNext() == null){
            this.head = null;
            this.tail = null;
        } else {
            this.head = head.getNext();
            this.head.setPrevius(null);
        }

        size -= 1;
        return num;
    }

    public int removeLast(){
        if (isEmpty()){
            throw new NoSuchElementException();
        }

        int num = this.tail.getData();

        if (head.getNext() == null){
            this.head = null;
            this.tail = null;
        } else {
            this.tail = tail.getPrevius();
            this.tail.setNext(null);
        }

        size -= 1;
        return num;
    }

    public int removeIndex(int index){
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException();
        
        if (isEmpty())
            throw new NoSuchElementException();

        NodeLinkedList node = head;

        int j = 0;
        while (j < index){
            node = node.getNext();
            j++;
        }

        node.getPrevius().setNext(node.getNext());
        node.getNext().setPrevius(node.getPrevius());
        size -= 1;

        return node.getData();
    }

    public boolean remove(int num){
        if (isEmpty())
            throw new NoSuchElementException();

        NodeLinkedList node = head;

        while (node != null){
            if (node.getData() == num){
                node.getPrevius().setNext(node.getNext());
                node.getNext().setPrevius(node.getPrevius());
                size -= 1;
                return true;
            }
            node = node.getNext();
        }

        return false;        
    }

    public String toString(){
        String retorno = "";

        NodeLinkedList node = head;
        while (node != null){
            retorno += String.valueOf(node.getData()) + " ";
            node = node.getNext();
        }

        return retorno.trim();
    }
}