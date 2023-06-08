package ex5.doublyLinkedList;

/**
 * An interface that defines a doubly linked list.
 *
 * @param <T> the type of elements in the list.
 */
public interface List<T> {

    /**
     * Checks if the list is empty.
     *
     * @return true if the list is empty, false otherwise.
     */
    boolean isEmpty();

    /**
     * Returns the size of the list.
     *
     * @return the size of the list.
     */
    int size();

    /**
     * Adds a new element at the beginning of the list.
     *
     * @param data the element to add.
     */
    void addFirst(T data);

    /**
     * Adds a new element at the end of the list.
     *
     * @param data the element to add.
     */
    void addLast(T data);

    /**
     * Removes an element from the list.
     *
     * @param data the element to remove.
     * @return the removed element, or null if the element was not found.
     */
    T remove(T data);

    /**
     * Clears the list, removing all elements.
     */
    void clear();

    /**
     * Checks if the list contains a specific element.
     *
     * @param data the element to search for.
     * @return true if the element is found, false otherwise.
     */
    boolean contains(T data);

    /**
     * Prints the elements of the list in forward order.
     */
    void printForward();

    /**
     * Prints the elements of the list in backward order.
     */
    void printBackward();
}

