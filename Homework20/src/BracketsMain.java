import java.util.Scanner;

public class BracketsMain {
    public static void main(String[] args) {
        //пример: {(2+5)*[(2+3)*4]+1}/7
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        boolean correct = bracketsAreCorrect(s);
    }

    /**
     * Возвращает true, если скобки в выражении расставлены корректно.
     */
    public static boolean bracketsAreCorrect(String s) {
        boolean areCorrect = true;
        LinkedListStack<Character> stack = new LinkedListStack();
        char[] symbols = s.toCharArray();
        for (int i = 0; i < symbols.length; i++) {
            char c = symbols[i];
            if (c == '(' || c == '{' || c =='['){
                stack.push(c);
            }
            if (c == ')' && '(' != stack.pop()) {
                return false;
            }
            if (c == ']' && '[' != stack.pop()) {
                return false;
            }
            if (c == '}' && '{' != stack.pop()) {
                return false;
            }
        }


        return areCorrect;
    }
}