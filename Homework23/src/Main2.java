public class Main2 {
    public static void main(String[] args) {
        StudentsSortingRule ssr = student -> student.setGrade(student.getGrade() + 1);
        SortedStudentGroup ssg = new SortedStudentGroup(4);
        Student st2 = new Student(2, 8, "Ваня");
        Student st3 = new Student(1, 9, "Лёха");
        Student st1 = new Student(0, 7, "Петя");
        Student st4 = new Student(3, 11, "Колян");
        ssg.add(st1);
        ssg.add(st2);
        ssg.add(st4);
        ssg.add(st3);
        ssr.gradeUp(st1);
        ssg.out();
    }
}
