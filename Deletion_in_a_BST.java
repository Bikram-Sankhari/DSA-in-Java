class deletion_helper {
    Node_of_Binary_Tree node;
    int depth;

    deletion_helper() {
        this.node = null;
        this.depth = 0;
    }
}

public class Deletion_in_a_BST {

    static Node_of_Binary_Tree delete(Node_of_Binary_Tree root, int key) {
        if (root == null) {
            return null;
        }

        if (root.data > key) {
            root.left = delete(root.left, key);
        } else if (root.data < key) {
            root.right = delete(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            deletion_helper pre = previous(root);
            deletion_helper post = postr(root);

            if (pre.depth <= post.depth) {
                root.data = pre.node.data;
                root.left = delete(root.left, pre.node.data);
            } else {
                root.data = post.node.data;
                root.right = delete(root.right, post.node.data);
            }
        }
        return root;
    }

    static deletion_helper previous(Node_of_Binary_Tree root) {
        deletion_helper helper = new deletion_helper();

        helper.node = root.left;
        helper.depth++;

        while (helper.node.right != null) {
            helper.node = helper.node.right;
            helper.depth++;
        }

        return helper;
    }

    static deletion_helper postr(Node_of_Binary_Tree root) {
        deletion_helper helper = new deletion_helper();

        helper.node = root.right;
        helper.depth++;

        while (helper.node.left != null) {
            helper.node = helper.node.left;
            helper.depth++;
        }

        return helper;
    }

    static void in_order_traverse(Node_of_Binary_Tree root) {
        if (root != null) {
            in_order_traverse(root.left);
            System.out.print(root.data + " ");
            in_order_traverse(root.right);
        }
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
        in_order_traverse(tree.root);
        System.out.println("\n-------------After Deletion---------------");
        delete(tree.root, 90);
        in_order_traverse(tree.root);
        System.out.println("\n" + tree.root.data);
    }
}
