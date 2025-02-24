package hwtask3;

public class SinglyLinkedList<T> {

    Node<T> firstNode = null;
    private Node<T> lastNode = null;
    private int numberOfElements = 0;

    public SinglyLinkedList() {
    }

    //method to add element to the lidt
    public void addElement(T t) {
        Node<T> newNode = new Node<>(t);
        if (firstNode == null) {
            firstNode = newNode;
        } else {
            lastNode.setNext(newNode);
        }
        lastNode = newNode;
        numberOfElements++;
    }

    //finds element by Value, returns true if element is found
    public boolean findElementByValue(T t) {
        Node<T> current = firstNode;
        while (current != null) {
            if (current.getValue().equals(t)) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    //removes element by Value (removes the first occurrence of the element)
    public void removeElementByValue(T t) {
        Node<T> current = firstNode;
        Node<T> previous = null;

        while (current != null) {
            if (current.getValue().equals(t)) {
                if (previous == null) { // Removing first element
                    firstNode = current.getNext();
                } else {
                    previous.setNext(current.getNext());
                }
                numberOfElements--;
                return;
            }
            previous = current;
            current = current.getNext();
        }
    }

    //shows the list
    public void showList() {
        int size = numberOfElements;
        Node<T> current = firstNode;
        for (int i = 0; i < size; i++) {
            System.out.print("[" + current.getValue() + "] ");
            current = current.getNext();
        }
        System.out.println();
    }
}
