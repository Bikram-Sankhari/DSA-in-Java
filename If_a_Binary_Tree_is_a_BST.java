public class If_a_Binary_Tree_is_a_BST {
    static Node_of_Binary_Tree temp = null;

    static void in_order_traverse(Node_of_Binary_Tree root){
        if(root != null){
            in_order_traverse(root.left);
            System.out.print(root.data + " ");
            in_order_traverse(root.right);
        }
    }

    static boolean isBST(Node_of_Binary_Tree root){
        if(root == null){
            return true;
        }

        if(!isBST(root.left)){
            return false;
        }

        if(temp != null && root.data <= temp.data){
            return false;
        }

        temp = root;
        return isBST(root.right);
    }

    public static void main(String[] args) {
        /*
                   50
            _______|________
           |                |
           25              90
       ____|____        ____|____
      |        |       |       130
      20       30           ____|_____
                           |          |
                          100        150
   */

        Binary_Tree tree = new Binary_Tree();
        System.out.println(isBST(tree.root));
    }
}
