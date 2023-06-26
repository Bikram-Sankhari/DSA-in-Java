public class Binary_Tree {
    Node_of_Binary_Tree root;
    Binary_Tree(){
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

        this.root = new Node_of_Binary_Tree(50);
        root.left = new Node_of_Binary_Tree(25);
        root.left.left = new Node_of_Binary_Tree(20);
        root.left.right = new Node_of_Binary_Tree(30);
        root.right = new Node_of_Binary_Tree(90);
        root.right.right = new Node_of_Binary_Tree(130);
        root.right.right.left = new Node_of_Binary_Tree(100);
        root.right.right.right = new Node_of_Binary_Tree(150);

    }
}
