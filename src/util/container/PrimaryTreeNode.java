package util.container;

public abstract class PrimaryTreeNode {
    private PrimaryTreeNode parent;
    private PrimaryTreeNode left;
    private PrimaryTreeNode right;
    private PrimaryTreeNode prev;

    public PrimaryTreeNode(PrimaryTreeNode parent) {
        this.parent = parent;
    }

    public void setLeft(PrimaryTreeNode left) {
        this.left = left;
    }

    public void setRight(PrimaryTreeNode right) {
        this.right = right;
    }

    public void setPrev(PrimaryTreeNode prev) {
        this.prev = prev;
    }
}
