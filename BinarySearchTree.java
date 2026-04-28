public class BinarySearchTree<T extends Comparable<T>> {

    /**
     * The root node of the binary search tree.
     * Left child = prev
     * Right child = next
     */
    private Node<T> root;

    /** Construct an empty BST */
    public BinarySearchTree() {
        this.root = null;
    }

    /** Construct a BST with a given root */
    public BinarySearchTree(Node<T> root) {
        this.root = root;
    }

    /**
     * Add an element to the BST.
     * Smaller → left (prev)
     * Larger or equal → right (next)
     */
    public void add(T element) {

        Node<T> newNode = new Node<>(element);

        if (this.root == null) {
            this.root = newNode;
            return;
        }

        Node<T> curr = this.root;
        Node<T> parent = null;

        while (curr != null) {
            parent = curr;

            if (element.compareTo(curr.getElement()) < 0) {
                curr = curr.getPrev();   // go left
            } else {
                curr = curr.getNext();   // go right
            }
        }

        // attach new node to correct side
        if (element.compareTo(parent.getElement()) < 0) {
            parent.setPrev(newNode);
        } else {
            parent.setNext(newNode);
        }
    }

    /** Public inorder display */
    public void display() {
        display(this.root);
    }

    /** Recursive inorder traversal */
    private void display(Node<T> node) {
        if (node == null)
            return;

        display(node.getPrev());
        System.out.println("visiting: " + node.getElement());
        display(node.getNext());
    }
}
