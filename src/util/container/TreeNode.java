package util.container;

public class TreeNode<V> extends PrimaryTreeNode {
    private V val;

    public TreeNode(TreeNode<V> parent, V val) {
        super(parent);
        this.val = val;
    }

    public V getVal() {
        return val;
    }
}
