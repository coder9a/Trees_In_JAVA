/**
 * Given a binary tree. Check whether it is a BST or not.
 * Note: We are considering that BSTs can not contain duplicate Nodes.
 *
 * Example 1:
 *
 * Input:
 *     2
 *  /    \
 * 1      3
 * Output: 1
 * Explanation:
 * The left subtree of root node contains node
 * with key lesser than the root node’s key and
 * the right subtree of root node contains node
 * with key greater than the root node’s key.
 * Hence, the tree is a BST.
 * Example 2:
 *
 * Input:
 *   2
 *    \
 *     7
 *      \
 *       6
 *        \
 *         5
 *          \
 *           9
 *            \
 *             2
 *              \
 *               6
 * Output: 0
 * Explanation:
 * Since the node with value 7 has right subtree
 * nodes with keys less than 7, this is not a BST.
 */
class NodeBST
{
    int data;
    NodeBST left;
    NodeBST right;
    NodeBST(int data)
    {
        this.data = data;
    }
}
public class CheckBST
{
    public static boolean validate(NodeBST node, int min, int max)
    {
        if (node==null)
            return true;
        else if(node.data <= min || node.data >= max)
            return false;
        else
            return validate(node.left, min, node.data) && validate(node.right, node.data, max);
    }
    public static boolean checkBST(NodeBST root)
    {
        return validate(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    public static void traverseInOrder(NodeBST node)
    {
        if(node!=null)
        {
            traverseInOrder(node.left);
            System.out.print(node.data+" ");
            traverseInOrder(node.right);
        }
    }
    public static void main(String[] args)
    {
        NodeBST node = new NodeBST(40);
        node.left = new NodeBST(30);
        node.right = new NodeBST(80);
        node.left.left = new NodeBST(25);
        node.left.right = new NodeBST(35);
        node.right.right = new NodeBST(100);
        traverseInOrder(node);
        System.out.println();
        if(checkBST(node))
            System.out.println("Valid Binary Search Tree");
        else
            System.out.println("InValid Binary Search Tree");
    }
}
