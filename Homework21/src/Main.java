public class Main {
    public static void main(String[] args) {

        Stack<Integer> intStack = new Stack<Integer>();

        intStack.push(5);
        intStack.push(6);
        intStack.push(7);
        System.out.println(intStack.pop());
        System.out.println(intStack.pop());

    }
}
