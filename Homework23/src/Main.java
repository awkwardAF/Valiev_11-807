import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Student st1 = new Student(1, 6, "Georgie");
        Student st2 = new Student(2, 10, "Ben");

        Comparator<Student> byNameComparator =
                (o1, o2) -> o1.compareTo(o2);


        SortedStudentGroup ssg = new SortedStudentGroup(4, byNameComparator);
        ssg.add(st1);
        ssg.add(st2);

        Comparator<Student> byGradeComparator =
                (o1, o2) -> o1.getGrade() - o2.getGrade();

        SortedStudentGroup ssg1 = new SortedStudentGroup(4, byGradeComparator);
        ssg1.add(st1);
        ssg1.add(st2);

        Comparator<Student> biIdComparator =
                (o1, o2) -> o1.getId() - o2.getId();

        SortedStudentGroup ssg2 = new SortedStudentGroup(4, biIdComparator);
        ssg2.add(st1);
        ssg2.add(st2);

        ssg.out();
        ssg1.out();
        ssg2.out();
    }
}
