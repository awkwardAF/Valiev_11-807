import java.util.LinkedList;

public class LinkedListStack<T> {
    private LinkedList<T> stack = new LinkedList<>();

    public void push (T object) {
        stack.add(object);
    }

    public T pop () {
        T result = stack.getLast();
        stack.removeLast();
        return result;
    }

    public boolean isEmpty() {
        return stack.size() == 0;
    }

}
