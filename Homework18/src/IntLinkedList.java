public class IntLinkedList {
    private Node head;
    private int count = 0;
    private Node middle;

    //добавление в конец
    public void add(int e) {
        Node newNode = new Node();
        newNode.setValue(e);
        newNode.setNext(null);
        if (head != null) {
            Node current = head;
            //по итогу цикла в current записана ссылка на последнюю Ноду
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        } else {
            head = newNode;
        }
        count++;
    }



    public int get(int index) {
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException("Index: " + index + " вне границ");
        }
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current.getValue();
    }

    public void remove(int index) {
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException("Index: " + index + " вне границ");
        }
        if (index == 0) {
            head = head.getNext();
        } else {
            Node beforeRemovable = head;
            for (int i = 0; i < index - 1; i++) {
                beforeRemovable = beforeRemovable.getNext();
            }
            Node nodeToRemove = beforeRemovable.getNext();
            beforeRemovable.setNext(nodeToRemove.getNext());
        }
        count--;
    }

    public boolean contains(int value) {
        Node current = head;
        for (int i = 0; i < count; i++) {
            current = current.getNext();
            if (current.getValue() == value){
                return true;
            }
            if (current.getNext() == null) {
                return false;
            }
        }
        return false;
    }

    public int[] toArray () {
        int[] arr = new int[count];
        Node current = head;
        int i = 0;
        while (current.getNext() != null) {
            arr[i] = current.getValue();
            current = current.getNext();
            i++;
        }
        arr[i] = current.getValue();
        return arr;
    }

    public void addAll(IntLinkedList newList) {
        int [] arr = newList.toArray();
        for (int i = 0; i < arr.length; i++) {
            add(arr[i]);
        }
    }

    public void addAllFrom (IntLinkedList newList, int index) {
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException("Index: " + index + " вне границ");
        }
        Node current = head;
        int[] arr = newList.toArray();
        Node afterRemovable = middle;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        for (int i = 0; i < arr.length; i++) {
            Node qwe = addNode(arr[i]);
            current.setNext(qwe);
            current = current.getNext();
        }
        current.setNext(afterRemovable);
    }

    // метод, который возвращает Ноду, для реализации addAllFrom (я не знал что еще можно сделать)
    public Node addNode(int e) {
        Node newNode = new Node();
        newNode.setValue(e);
        newNode.setNext(null);
        if (head != null) {
            Node current = head;
            //по итогу цикла в current записана ссылка на последнюю Ноду
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        } else {
            head = newNode;
        }
        count++;
        return newNode;
    }

    // метод для удобства
    public void out() {
        Node current = head;
        while (current.getNext() != null) {
            System.out.print(current.getValue() + " ");
            current = current.getNext();
        }
        System.out.println(current.getValue());
    }

}