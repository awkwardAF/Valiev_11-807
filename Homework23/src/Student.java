public class Student implements Comparable<Student> {
    private int id;
    private int grade;
    private String name;

    Student(int id, int grade, String name) {
        this.id = id;
        this.grade = grade;
        this.name = name;
    }

    public boolean equals (Student student) {
        return this.id == student.getId() && this.grade == student.getGrade() && this.name == student.getName();
    }

    int getId() {
        return id;
    }

    int getGrade() {
        return grade;
    }

    String getName() {
        return name;
    }

    void setGrade(int n) {
        this.grade = n;
    }

    @Override
    public int compareTo(Student o) {
        return this.id - o.id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", grade=" + grade +
                ", name='" + name + '\'' +
                '}';
    }
}
