package algoritmos;

public class NodeLinkedList {
    private NodeLinkedList next;
    private NodeLinkedList previus;
    private int data;

    public NodeLinkedList(int data, NodeLinkedList next, NodeLinkedList previus){
        this.data = data;
        this.next = next;
        this.previus = previus;
    }

    public int getData(){
        return this.data;
    }

    public NodeLinkedList getNext(){
        return this.next;
    }

    public NodeLinkedList getPrevius(){
        return this.previus;
    }

    public void setData(int newData){
        this.data = newData;
    }

    public void setNext(NodeLinkedList node){
        this.next = node;
    }

    public void setPrevius(NodeLinkedList node){
        this.previus = node;
    }    
}
