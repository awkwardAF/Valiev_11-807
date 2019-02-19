import java.util.Comparator;

public class SortedStudentGroup {

    private String type;
    private int amount = 0;
    Comparator<Student> comparator;
    private Student[] students;

    public SortedStudentGroup(int x) {
        this.students = new Student[x];
    }

    public SortedStudentGroup(int x, Comparator<Student> comparator) {
        this.students = new Student[x];
        this.comparator = comparator;
    }



    public void add (Student studentToAdd) {
        int c = 0;
        if (comparator == null) {
            while (c < amount && students[c].compareTo(studentToAdd) < 0) {
                c++;
            }
        }
        else {
            while (c < amount &&
                    comparator.compare(students[c], studentToAdd) < 0) {
                c++;
            }
        }
        for (int i = amount - 1; i >= c; i--) {
            students[i + 1] = students[i];
        }
        //вставляем на нужное место
        students[c] = studentToAdd;
        amount++;
    }


    public void out () {
        for (int i = 0; i < amount; i++) {
            System.out.println(students[i].toString());
        }
    }

}
