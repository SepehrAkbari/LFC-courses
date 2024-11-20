public class Exam2_11 {
    public Node findSuccessor(Node node) { 
        // if the noce is null, there is no successor!
        if (node == null) {
            return null;
        }
        
        // Case 1: the node has a right subtree
        if (node.right != null) {
            // finding the smallest node which is the leftest node in the right subtree
            Node temp = node.right;
            while (temp.left != null) {
                temp = temp.left;
            }
            // returning that node
            return temp;
        }
        
        // Case 2: the node has no right subtree so the successor is in the upper level
        Node successor = null; // initializing it
        Node current = root;   // starting search from the root
        
        // traversing the tree to find the lowest node where the node is in the left subtree
        while (current != null) {
            if (node.value < current.value) {
                // updating successor and moving left
                successor = current;
                current = current.left;
            } else if (node.value > current.value) {
                // moving to the right subtree
                current = current.right;
            } else {
                // ttoping traversal when the node is fond
                break;
            }
        }
        
        // Returning the successor node
        return successor;
    }
}
