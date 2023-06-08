package ex5.doublyLinkedList;

/**
 * A class that represents a node in a doubly linked list.
 *
 * @param <T> the type of data stored in the node.
 */
public class Node<T> {
    public T data;
    public Node<T> prev;
    public Node<T> next;

    /**
     * Constructs a new node with the specified data.
     *
     * @param data the data to be stored in the node.
     */
    public Node(T data) {
        this.data = data;
        prev = next = null;
    }

    /**
     * Returns the data stored in the node.
     *
     * @return the data stored in the node.
     */
    public T getData() {
        return data;
    }

    /**
     * Sets the data of the node.
     *
     * @param data the data to set.
     */
    public void setData(T data) {
        this.data = data;
    }

    /**
     * Returns the previous node.
     *
     * @return the previous node.
     */
    public Node<T> getPrev() {
        return prev;
    }

    /**
     * Sets the previous node.
     *
     * @param prev the previous node to set.
     */
    public void setPrev(Node<T> prev) {
        this.prev = prev;
    }

    /**
     * Returns the next node.
     *
     * @return the next node.
     */
    public Node<T> getNext() {
        return next;
    }

    /**
     * Sets the next node.
     *
     * @param next the next node to set.
     */
    public void setNext(Node<T> next) {
        this.next = next;
    }
}
