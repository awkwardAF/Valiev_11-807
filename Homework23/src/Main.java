public class Main {

    public static void main(String[] args) {
        // "name", "id", "grade"
        ByGradeComparator bgc = new ByGradeComparator();
        ByNameComparator bnc = new ByNameComparator();
        StudentsSortingRule ssr = new StudentsSortingRule() {
            @Override
            public void gradeUp(Student student) {
                student.setGrade(student.getGrade() + 1);
            }
        };
        SortedStudentGroup ssg = new SortedStudentGroup(4, bnc);
        Student st2 = new Student(2, 8, "Ваня");
        Student st3 = new Student(1, 9, "Лёха");
        Student st1 = new Student(0, 7, "Петя");
        Student st4 = new Student(3, 11, "Колян");
        ssg.add(st1);
        ssg.add(st2);
        ssg.add(st4);
        ssg.add(st3);
        ssr.gradeUp(st3);
        ssg.out();

    }
}
