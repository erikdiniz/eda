package eda.com;

public class BST {
    private NodeBST root;

    public boolean isEmpty(){
        return this.root == null;
    }

    public void add(int value){
        NodeBST node = new NodeBST(value);
        
        if (isEmpty())
            this.root = node;
        else {
            NodeBST aux = root;

            while (aux != null){
                if (value > aux.getValue()){
                    if (aux.getRight() == null){
                        aux.setRight(node);
                        node.setParent(aux);
                    } else                     
                        aux = aux.getRight();
                } else {
                    if (aux.getLeft() == null){
                        aux.setLeft(node);
                        node.setParent(aux);
                    } else                    
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
}
