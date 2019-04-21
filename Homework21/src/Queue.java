public class Queue<T> {
    Node<T> first;
    Node<T> last;

    void enqueue(T elem) {
        Node<T> oldLast = last;
        last = new Node<>();
        last.item = elem;
        if (isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }
    }

    T dequeue(T elem) {
        if (isEmpty()) {
            throw new IllegalStateException();
        } else {
            elem = first.item;
            first = first.next;
            return elem;
        }


    }

    boolean isEmpty() {

        return first == null;
    }

    class Node<Item> {
        Item item;
        Node<Item> next;
    }
}