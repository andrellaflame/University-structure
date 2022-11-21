/**
 * @author Andriy Sulimenko, Vladislav Marchenko
 * @files Main.java; University.java; Faculty.java; Department.java; Teacher.java; Student.java; DataInput.java
 *
 * @taskSetting Написати програму, що буде формувати список студентів та викладачів університету НаУКМА.
 * Відповідно мають бути реалізовані такі можливості роботи, як:
 * 1.	Створити/видалити/редагувати факультет.
 * 2.	Створити/видалити/редагувати кафедру факультета.
 * 3.	Додати/видалити/редагувати студента/викладача до кафедри.
 * 4.	Знайти студента/викладача за ПІБ, курсом або групою.
 * 5.	Вивести всіх студентів впорядкованих за курсами.
 * 6.	Вивести всіх студентів/викладачів факультета впорядкованих за алфавітом.
 * 7.	Вивести всіх студентів кафедри впорядкованих за курсами.
 * 8.	Вивести всіх студентів/викладачів кафедри впорядкованих за алфавітом.
 * 9.	Вивести всіх студентів кафедри вказаного курсу.
 * 10.	Вивести всіх студентів кафедри вказаного курсу впорядкованих за алфавітом.
 */

public class Department {
    private String name;

    Student[] students = new Student[0];
    Teacher[] teachers = new Teacher[0];

    public Department(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void add(Object person) {
        if (person.getClass() == Student.class) {
            Student[] res = new Student[students.length + 1];

            System.arraycopy(students, 0, res, 0, students.length);
            res[students.length] = (Student) person;

            setStudents(res);
        } else if (person.getClass() == Teacher.class) {
            Teacher[] res = new Teacher[teachers.length + 1];

            System.arraycopy(teachers, 0, res, 0, teachers.length);
            res[teachers.length] = (Teacher) person;

            setTeachers(res);
        } else return;
    }

    public void removeStudent(int index) {
        Student[] res = new Student[students.length - 1];

        System.arraycopy(students, 0, res, 0, index - 1);
        System.arraycopy(students, index, res, index - 1, res.length - index + 1);

        setStudents(res);
    }

    public void removeTeacher(int index) {
        Teacher[] res = new Teacher[teachers.length - 1];

        System.arraycopy(teachers, 0, res, 0, index - 1);
        System.arraycopy(teachers, index, res, index - 1, res.length - index + 1);

        setTeachers(res);
    }

    public void editStudent (int index, String name, int group, int grade) {
        students[index - 1].setPib(name);
        students[index - 1].setGroup(group);
        students[index - 1].setGrade(grade);
    }

    public void editTeacher (int index, String name, int group, int grade) {
        teachers[index - 1].setPib(name);
        teachers[index - 1].setGroup(group);
        teachers[index - 1].setGrade(grade);

    }

    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }

    public Teacher[] getTeachers() {
        return teachers;
    }

    public void setTeachers(Teacher[] teachers) {
        this.teachers = teachers;
    }

    @Override
    public String toString() {
        return this.name + " depart.";
    }
}
