public class Stack<T> {

    private Node<T> first;
    private int count = 0;
    private Node<T> previous;


    public void push(T e) {
        Node newNode = new Node();
        newNode.setValue(e);
        newNode.setNext(null);
        if (first != null) {
            Node current = first;
            //по итогу цикла в current записана ссылка на последнюю Ноду
            while (current.getNext() != null) {
                current = current.getNext();
            }
            previous = current;
            current.setNext(newNode);
        } else {
            first = newNode;
        }
        count++;
    }

    public Object pop () {
        if (count > 0) {
            previous = first;
            for (int i = 0; i < count - 1; i++) {
                previous = previous.getNext();
            }
            Node toPop = previous;
            previous.setNext(null);
            count--;
            return toPop.getValue();
        }
        else {
            throw new NullPointerException("Nothing to pop");
        }
    }

    public int getSize () {
        return count;
    }

}
