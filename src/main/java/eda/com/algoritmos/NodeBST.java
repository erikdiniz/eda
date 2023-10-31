package algoritmos;

public class NodeBST {
    private int value;
    private NodeBST parent;
    private NodeBST left;
    private NodeBST right;

    public NodeBST(int v){
        this.value = v;
    }

    public boolean isLeaf(){
        return (this.getLeft() == null && this.getRight() == null);
    }

    public int getValue(){
        return this.value;
    }

    public NodeBST getParent(){
        return this.parent;
    }

    public NodeBST getLeft(){
        return this.left;
    }

    public NodeBST getRight(){
        return this.right;
    }

    public void setParent(NodeBST node){
        this.parent = node;
    }

    public void setLeft(NodeBST node){
        this.left = node;
    }

    public void setRight(NodeBST node){
        this.right = node;
    }

    public void setValue(int value){
        this.value = value;
    }

}