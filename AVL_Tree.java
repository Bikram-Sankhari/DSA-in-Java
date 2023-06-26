public class AVL_Tree {
    public static void in_order_traverse(Node_of_AVL_Tree root) {
        if (root != null) {
            in_order_traverse(root.left);
            System.out.print(root.data + " ");
            in_order_traverse(root.right);
        }
    }

    public static int get_height(Node_of_AVL_Tree root) {
        if (root == null) {
            return 0;
        }
        return root.height;
    }

    public static void update_height(Node_of_AVL_Tree root) {
        int lh = get_height(root.left);
        int rh = get_height(root.right);

        root.height = Math.max(lh, rh) + 1;
    }

    public static int balance_factor(Node_of_AVL_Tree root) {
        int lh = get_height(root.left);
        int rh = get_height(root.right);

        return (lh - rh);
    }

    public static Node_of_AVL_Tree rotate_right(Node_of_AVL_Tree root) {
        Node_of_AVL_Tree result = root.left;
        Node_of_AVL_Tree temp = root.left.right;
        root.left.right = root;
        root.left = temp;

        update_height(root);
        update_height(result);
        return result;
    }

    public static Node_of_AVL_Tree rotate_left(Node_of_AVL_Tree root) {
        Node_of_AVL_Tree result = root.right;
        Node_of_AVL_Tree temp = root.right.left;
        root.right.left = root;
        root.right = temp;

        update_height(root);
        update_height(result);

        return result;
    }

    public static Node_of_AVL_Tree apply_rotation(Node_of_AVL_Tree root) {
        int bf = balance_factor(root);

        if (bf > 1) {
            if (balance_factor(root.left) == -1) {
                root.left = rotate_left(root.left);
            }
            return rotate_right(root);
        }

        if (bf < -1) {
            if (balance_factor(root.right) == 1) {
                root.right = rotate_right(root.right);
            }
            return rotate_left(root);
        }

        return root;
    }

    public static Node_of_AVL_Tree insert(Node_of_AVL_Tree root, int data) {
        if (root == null) {
            return new Node_of_AVL_Tree(data);
        } else if (root.data > data) {
            root.left = insert(root.left, data);
        } else if (root.data < data) {
            root.right = insert(root.right, data);
        } else {
            System.out.println("Element already exists in Tree");
        }

        update_height(root);
        return apply_rotation(root);
    }

    public static Node_of_AVL_Tree delete(Node_of_AVL_Tree root, int key) {
        if (root == null) {
            System.out.println("Element doesn't exists in the Tree");
        }

        if (root.data > key) {
            root.left = delete(root.left, key);
        } else if (root.data < key) {
            root.right = delete(root.right, key);
        } else {
            if (root.right == null) {
                return root.left;
            }

            if (root.left == null) {
                return root.right;
            }

            Node_of_AVL_Tree temp = root.left;
            while (temp.right != null) {
                temp = temp.right;
            }

            root.data = temp.data;
            root.left = delete(root.left, temp.data);
        }

        update_height(root);
        return apply_rotation(root);
    }

    public static void main(String[] args) {
         /*
                            40
                 ____________|____________
                |                         |
                20                       70
             ___|___             _________|_________
            |       |           |                   |
            10      30          50                  80
         ___|____           ____|_____         _____|______
        |                  |          |                    |
        5                  45         60                   90

    */

        Node_of_AVL_Tree root = new Node_of_AVL_Tree(10);
        root = insert(root, 20);
        root = insert(root, 30);
        root = insert(root, 40);
        root = insert(root, 50);
        root = insert(root, 60);
        root = insert(root, 70);
        root = insert(root, 80);
        root = insert(root, 90);
        root = insert(root, 5);

        in_order_traverse(root);
        System.out.println("\n" + root.left.data);

        System.out.println("------------------------------AFTER DELETION---------------------------------");
        root = delete(root, 50);
        in_order_traverse(root);
        System.out.println("\n" + root.left.data);

    }
}
