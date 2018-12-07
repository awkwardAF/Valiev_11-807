 import java.util.Iterator;

    public class Main {
        public static void main(String[] args) {
            MyArrayList<String> l = new MyArrayList<String>();
            //l.add(5); не скомпилируется
            l.add("abc");
            l.add("qwerty");
            l.add("hello");
            l.remove(0);

            MyArrayList<Integer> ints = new MyArrayList<>();

            ints.add(1);
            ints.add(2);
            ints.add(3);
            ints.add(4);
            ints.remove(1);


        }
    }
