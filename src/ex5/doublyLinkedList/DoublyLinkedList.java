package ex5.doublyLinkedList;

/**
 * A class that represents a Doubly Linked List.
 *
 * @param <T> the type of elements stored in the list.
 */
public class DoublyLinkedList<T> implements List<T> {
    private Node<T> first;
    private Node<T> last;
    /**
     * Removes the first element from the doubly linked list.
     *
     * @return the removed element, or null if the list is empty.
     */
    private T removeFirst() {
        if (isEmpty()) {
            return null;
        }

        T data = first.getData();
        if (first == last) {
            first = null;
            last = null;
        } else {
            first = first.getNext();
            first.setPrev(null);
        }
        return data;
    }

    /**
     * Removes the last element from the doubly linked list.
     *
     * @return the removed element, or null if the list is empty.
     */
    private T removeLast() {
        if (isEmpty()) {
            return null;
        }

        T data = last.getData();
        if (first == last) {
            first = null;
            last = null;
        } else {
            last = last.getPrev();
            last.setNext(null);
        }
        return data;
    }


    /**
     * Checks if the doubly linked list is empty.
     *
     * @return true if the list is empty, false otherwise.
     */
    @Override
    public boolean isEmpty() {
        return (last == first && last == null);
    }

    /**
     * Returns the size of the doubly linked list.
     *
     * @return the number of elements in the list.
     */
    @Override
    public int size() {
        int size = 0;
        Node<T> current = first;
        while (current != null) {
            size++;
            current = current.getNext();
        }
        return size;
    }

    /**
     * Adds an element to the beginning of the doubly linked list.
     *
     * @param data the element to be added.
     */
    @Override
    public void addFirst(T data) {
        Node<T> newNode = new Node<>(data);
        if (isEmpty()) {
            first = newNode;
            last = newNode;
        } else {
            newNode.setNext(first);
            first.setPrev(newNode);
            first = newNode;
        }
    }

    /**
     * Adds an element to the end of the doubly linked list.
     *
     * @param data the element to be added.
     */
    @Override
    public void addLast(T data) {
        Node<T> newNode = new Node<>(data);
        if (isEmpty()) {
            first = newNode;
            last = newNode;
        } else {
            last.setNext(newNode);
            newNode.setPrev(last);
            last = newNode;
        }
    }

    /**
     * Removes the first occurrence of the specified element from the doubly linked list.
     *
     * @param data the element to be removed.
     * @return the removed element, or null if the element is not found.
     */
    @Override
    public T remove(T data) {
        Node<T> current = first;
        while (current != null) {
            if (current.getData().equals(data)) {
                if (current == first) {
                    return removeFirst();
                } else if (current == last) {
                    return removeLast();
                } else {
                    current.getPrev().setNext(current.getNext());
                    current.getNext().setPrev(current.getPrev());
                    return current.getData();
                }
            }
            current = current.getNext();
        }
        return null;
    }

    /**
     * Clears the doubly linked list, removing all elements.
     */
    @Override
    public void clear() {
        first = null;
        last = null;
    }

    /**
     * Checks if the doubly linked list contains the specified element.
     *
     * @param data the element to be checked.
     * @return true if the list contains the element, false otherwise.
     */
    @Override
    public boolean contains(T data) {
        Node<T> current = first;
        while (current != null) {
            if (current.getData().equals(data)) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    /**
     * Prints the elements of the doubly linked list in forward order.
     */
    @Override
    public void printForward() {
        Node<T> current = first;
        System.out.print("Forward: ");
        while (current != null) {
            System.out.print(current.getData() + " ");
            current = current.getNext();
        }
        System.out.println();
    }

    /**
     * Prints the elements of the doubly linked list in backward order.
     */
    @Override
    public void printBackward() {
        Node<T> current = last;
        System.out.print("Backward: ");
        while (current != null) {
            System.out.print(current.getData() + " ");
            current = current.getPrev();
        }
        System.out.println();
    }
}
