
public class IntListTestMain {
    public static void main(String[] args) {
        IntLinkedList list = new IntLinkedList();
        IntLinkedList list2 = new IntLinkedList();
        list.add(4);
        list.add(2);
        list.add(3);
        list.add(5);
        list.add(1);
        list2.add(10);
        list2.add(10);
        list2.add(10);
        list2.add(10);
        list.addAllFrom(list2, 1);
        list.out();
    }
}