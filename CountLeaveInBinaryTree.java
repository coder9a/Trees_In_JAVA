class NodeCL
{
    int value;
    NodeCL left, right;
    public NodeCL(int value)
    {
        this.value = value;
    }
}
public class CountLeaveInBinaryTree
{
    public static NodeCL insert(NodeCL root, int value)
    {
        NodeCL newNode = new NodeCL(value);
        NodeCL x = root;
        NodeCL y = null;
        while (x!=null)
        {
            y=x;
            if(value<x.value)
                x = x.left;
            else
                x = x.right;
        }
        if(y==null)
            y = newNode;
        else if(y.value>value)
            y.left = newNode;
        else
            y.right = newNode;
        return y;
    }
    public static int CountLeafNodes(NodeCL node)
    {
        if(node==null)
            return 0;
        if(node.left ==null && node.right==null)
            return 1;
        else
            return CountLeafNodes(node.left) + CountLeafNodes(node.right);
    }
    public static void traverseInOrder(NodeCL node)
    {
        if(node!=null)
        {
            traverseInOrder(node.left);
            System.out.print(node.value+" ");
            traverseInOrder(node.right);
        }
    }
    public static void main(String[] args)
    {
        NodeCL root = null;
        root = insert(root, 50);
        insert(root, 30);
        insert(root, 20);
        insert(root, 40);
        insert(root, 70);
        insert(root, 60);
        insert(root, 80);
        traverseInOrder(root);
        System.out.println();
        int count = CountLeafNodes(root);
        System.out.println("Leaf Count = "+count);
    }
}
