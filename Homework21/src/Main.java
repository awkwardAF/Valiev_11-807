public class Main {
    public static void main(String[] args) {

        Stack<Integer> intStack = new Stack<Integer>();

        intStack.push(5);
        intStack.push(6);
        intStack.push(7);
        System.out.println(intStack.pop());
        System.out.println(intStack.pop());

        Queue<Integer> intQueue = new Queue<Integer>();
        intQueue.enqueue(7);
        intQueue.enqueue(8);
        System.out.println(intQueue.dequeue());
        intQueue.enqueue(9);
        System.out.println(intQueue.dequeue());
        System.out.println(intQueue.dequeue());
    }
}
