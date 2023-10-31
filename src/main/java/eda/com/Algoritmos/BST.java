package eda.com;

import java.util.Deque;
import java.util.LinkedList;

public class BST {
    private NodeBST root;

    public NodeBST getRoot(){
        return this.root;
    }

    public boolean isEmpty(){
        return this.root == null;
    }

    public void add(int element){
        if (isEmpty())
        this.root = new NodeBST(element);
    else {
            
        NodeBST aux = this.root;
            
        while (aux != null) {
                
            if (element < aux.getValue()) {
                if (aux.getLeft() == null) { 
                    NodeBST newNode = new NodeBST(element);
                    aux.setLeft(newNode);
                    newNode.setParent(aux);
                    return;
                }
                    
                aux = aux.getLeft();
            } else {
                if (aux.getRight() == null) { 
                    NodeBST newNode = new NodeBST(element);
                    aux.setRight(newNode);
                    newNode.setParent(aux);
                    return;
                }
                    
                aux = aux.getRight();
            }
        }
    }
    }

    public void recursiveAdd(int value){
        if (isEmpty())
            this.root = new NodeBST(value);
        else {
            NodeBST node = new NodeBST(value);
            recursiveAdd(node, value);
        }
    }

    private void recursiveAdd(NodeBST node, int value){
        if (value > node.getValue()){
            if (node.getRight() == null){
                NodeBST add = new NodeBST(value);
                node.setRight(add);
                add.setParent(node);
            } else
                recursiveAdd(node.getRight(), value);
        } else {
            if (node.getLeft() == null){
                NodeBST add = new NodeBST(value);
                node.setLeft(add);
                add.setParent(node);
            } else 
                recursiveAdd(node.getLeft(), value);
        }
    }

    public NodeBST search(int value){
        NodeBST aux = this.root;

        while (aux != null){
            if (aux.getValue() == value)
                return aux;
            if (value > aux.getValue())
                aux = aux.getRight();
            if (value < aux.getValue())
                aux = aux.getLeft();
        }

        return null;
    }

    public NodeBST recursiveSearch(int value){
        return recursiveSearch(root, value);
    }

    private NodeBST recursiveSearch(NodeBST node, int value){
        if (node == null)
            return null;
        if (node.getValue() == value)
            return node;
        if (node.getValue() < value)
            return recursiveSearch(node.getRight(), value);
        else
            return recursiveSearch(node.getLeft(), value);
    }

    public NodeBST min(){
        if (isEmpty())
            return null;

        return min(this.root);
    }

    private NodeBST min(NodeBST node){
        if (node.getLeft() == null)
            return node;
        
        return min(node.getLeft());
    }

    public NodeBST max(){
        if (isEmpty())
            return null;

        return max(this.root);
    }

    private NodeBST max(NodeBST node){
        if (node.getRight() == null)
            return node;
        
        return max(node.getRight());
    }

    public NodeBST sucessor(NodeBST node){
        if (node == null)
            return null;
        
        if (node.getRight() != null)
            return min(node.getRight());
        
        NodeBST aux = node.getParent();

        while (aux != null && aux.getValue() < node.getValue())
            aux = aux.getParent();
        
        return aux;
    }

    public NodeBST predecessor(NodeBST node){
        if (node == null)
            return null;

        if (node.getLeft() != null)
            return max(node.getLeft());
        
        NodeBST aux = node.getParent();

        while (aux != null && aux.getValue() > node.getValue())
            aux = aux.getParent();

        return aux;        
    }

    public int height(){
        return height(this.root);
    }

    private int height(NodeBST node){
        if (node == null)
            return -1;
        
        return Math.max(height(node.getLeft()), height(node.getRight()));
    }

    private boolean hasOnlyLeftChild(NodeBST node){
        return (node.getLeft() != null && node.getRight() == null);
    }

    private boolean hasOnlyRightChild(NodeBST node){
        return (node.getRight() != null && node.getLeft() == null);
    }

    public void remove(NodeBST toRemove){
        if (toRemove.isLeaf()){
            if (toRemove.getValue() == this.root.getValue())
                this.root = null;
            else {
                if (toRemove.getValue() > toRemove.getParent().getValue())
                    toRemove.getParent().setRight(null);
                else
                    toRemove.getParent().setLeft(null);
                
            }
        
        
        } else if (hasOnlyLeftChild(toRemove)){
            if (toRemove.getValue() == this.root.getValue()){
                this.root = toRemove.getLeft();
                this.root.setParent(null);                
            } else {
                toRemove.getLeft().setParent(toRemove.getParent());

                if (toRemove.getValue() > toRemove.getParent().getValue())
                    toRemove.getParent().setRight(toRemove.getLeft());
                else
                    toRemove.getParent().setLeft(toRemove.getLeft());
            }
        
        
        } else if (hasOnlyRightChild(toRemove)){
            if (toRemove.getValue() == this.root.getValue()){
                this.root = toRemove.getRight();
                this.root.setParent(null);
            } else {
                toRemove.getRight().setParent(toRemove.getParent());

                if (toRemove.getValue() > toRemove.getParent().getValue())
                    toRemove.getParent().setRight(toRemove.getRight());
                else
                    toRemove.getParent().setLeft(toRemove.getRight());
            }
        } else {
            NodeBST sucessor = sucessor(toRemove);
            toRemove.setValue(sucessor.getValue());
            remove(sucessor);
        }
    }

    public void preOrder(){
        preOrder(this.root);
    }

    private void preOrder(NodeBST node){
        if (node != null){
            System.out.println(node.getValue());
            preOrder(node.getLeft());
            preOrder(node.getRight());
        }
    }

    public void inOrder(){
        inOrder(this.root);
    }

    private void inOrder(NodeBST node){
        if (node != null){
            inOrder(node.getLeft());
            System.out.println(node.getValue());
            inOrder(node.getRight());
        }
    }

    public void posOrder(){
        posOrder(this.root);
    }

    private void posOrder(NodeBST node){
        if (node != null){
            posOrder(node.getLeft());
            posOrder(node.getRight());
            System.out.println(node.getValue());
        }
    }

    public void printBFS(){
        Deque<NodeBST> queue = new LinkedList<NodeBST>();

        if (!isEmpty()) {
            queue.addLast(this.root);

        while (queue.size() > 0) {
            NodeBST current = queue.removeFirst();
                
            System.out.println(current.getValue());
                
            if(current.getLeft() != null) 
                queue.addLast(current.getLeft());
            if(current.getRight() != null) 
                queue.addLast(current.getRight());   
        }
    }
    }
}