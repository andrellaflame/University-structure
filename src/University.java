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
import java.util.Locale;

public class University {

    public static final String RESET = "\u001B[0m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String RED = "\u001B[31m";
    public static final String SPACE = "    ";


    private final String name = "NaUKMA";
    private Faculty[] faculties = new Faculty[0];

    public void addFaculty(Faculty f) {
        Faculty[] res = new Faculty[faculties.length + 1];

        System.arraycopy(faculties, 0, res, 0, faculties.length);
        res[faculties.length] = f;

        setFaculties(res);
    }

    public void removeFaculty(int index) {
        Faculty[] res = new Faculty[faculties.length - 1];

        System.arraycopy(faculties, 0, res, 0, index - 1);
        System.arraycopy(faculties, index, res, index - 1, res.length - index + 1);

        setFaculties(res);
    }

    public void editFaculty(String newName, int index) {
        faculties[index - 1].setName(newName);
    }

    public Faculty[] getFaculties() {
        return faculties;
    }

    public void setFaculties(Faculty[] faculties) {
        this.faculties = faculties;
    }

    public void findStudentByName (String pib) {
        int counter = 0;
        pib = pib.toLowerCase(Locale.ROOT);
        for (int i = 0; i < faculties.length; i++) {
            for (int j = 0; j < faculties[i].departments.length; j++) {
                for (int k = 0; k < faculties[i].departments[j].students.length; k++) {
                    if (pib.length() > faculties[i].departments[j].students[k].getPib().length()) continue;
                    else {
                        boolean temp = true;
                        for (int t = 0; t < pib.length(); t++) {
                            if (faculties[i].departments[j].students[k].getPib().toLowerCase(Locale.ROOT).charAt(t) != pib.charAt(t)) {
                                temp = false;
                            }
                        }
                        if (temp){
                            counter ++;
                            System.out.println(faculties[i].departments[j].students[k]);
                        }
                    }
                }
            }
        }
        if (counter == 0) System.out.println("Nobody was found");
    }

    public void findTeacherByName (String pib) {
        int counter = 0;
        pib = pib.toLowerCase(Locale.ROOT);
        for (int i = 0; i < faculties.length; i++) {
            for (int j = 0; j < faculties[i].departments.length; j++) {
                for (int k = 0; k < faculties[i].departments[j].teachers.length; k++) {
                    if (pib.length() > faculties[i].departments[j].teachers[k].getPib().length()) continue;
                    else {
                        boolean temp = true;
                        for (int t = 0; t < pib.length(); t++) {
                            if (faculties[i].departments[j].teachers[k].getPib().toLowerCase(Locale.ROOT).charAt(t) != pib.charAt(t)) {
                                temp = false;
                            }
                        }
                        if (temp) {
                            counter++;

                            System.out.println(faculties[i].departments[j].teachers[k]);
                        }
                    }
                }
            }
        }
        if (counter == 0) System.out.println("Nobody was found");
    }

    public void findStudentByGrade (int grade) {
        int counter = 0;
        for (int i = 0; i < faculties.length; i++) {
            for (int j = 0; j < faculties[i].departments.length; j++) {
                for (int k = 0; k < faculties[i].departments[j].students.length; k++) {

                    if (grade == faculties[i].departments[j].students[k].getGrade()) {
                        counter++;
                        System.out.println(faculties[i].departments[j].students[k]);
                    }
                }
            }
        }
        if (counter == 0) System.out.println("Nobody was found");
    }

    public void findTeacherByGrade (int grade) {
        int counter = 0;
        for (int i = 0; i < faculties.length; i++) {
            for (int j = 0; j < faculties[i].departments.length; j++) {
                for (int k = 0; k < faculties[i].departments[j].teachers.length; k++) {

                    if (grade == faculties[i].departments[j].teachers[k].getGrade()) {
                        counter++;
                        System.out.println(faculties[i].departments[j].teachers[k]);
                    }
                }
            }
        }
        if (counter == 0) System.out.println("Nobody was found");
    }

    public void findStudentByGroup (int group) {
        int counter = 0;
        for (int i = 0; i < faculties.length; i++) {
            for (int j = 0; j < faculties[i].departments.length; j++) {
                for (int k = 0; k < faculties[i].departments[j].students.length; k++) {

                    if (group == faculties[i].departments[j].students[k].getGroup()) {
                        counter++;
                        System.out.println(faculties[i].departments[j].students[k]);
                    }
                }
            }
        }
        if (counter == 0) System.out.println("Nobody was found");
    }

    public void findTeacherByGroup (int group) {
        int counter = 0;
        for (int i = 0; i < faculties.length; i++) {
            for (int j = 0; j < faculties[i].departments.length; j++) {
                for (int k = 0; k < faculties[i].departments[j].teachers.length; k++) {

                    if (group == faculties[i].departments[j].teachers[k].getGroup()) {
                        counter++;
                        System.out.println(faculties[i].departments[j].teachers[k]);
                    }
                }
            }
        }
        if (counter == 0) System.out.println("Nobody was found");
    }

    public Student[] allStudents() {
        Student[] allStudents = new Student[0];

        for (int i = 0; i < faculties.length; i++) {
            for (int j = 0; j < faculties[i].departments.length; j++) {
                for (int k = 0; k < faculties[i].departments[j].students.length; k++) {
                    Student[] temp = new Student[allStudents.length + 1];
                    System.arraycopy(allStudents, 0, temp, 0, allStudents.length);
                    temp[allStudents.length] = faculties[i].departments[j].students[k];
                    allStudents = temp;
                }
            }
        }

        return allStudents;
    }

    public Student[] allStudentsFromFaculty(int index) {
        Student[] allFacultyStudents = new Student[0];

        for (int j = 0; j < faculties[index - 1].departments.length; j++) {
            for (int k = 0; k < faculties[index - 1].departments[j].students.length; k++) {
                Student[] temp = new Student[allFacultyStudents.length + 1];
                System.arraycopy(allFacultyStudents, 0, temp, 0, allFacultyStudents.length);
                temp[allFacultyStudents.length] = faculties[index - 1].departments[j].students[k];
                allFacultyStudents = temp;
            }
        }

        return allFacultyStudents;
    }

    public Student[] allStudentsFromDepartment(int facIndex, int depIndex) {
        Student[] allDepartmentStudents = new Student[0];

        for (int k = 0; k < faculties[facIndex - 1].departments[depIndex - 1].students.length; k++) {
            Student[] temp = new Student[allDepartmentStudents.length + 1];
            System.arraycopy(allDepartmentStudents, 0, temp, 0, allDepartmentStudents.length);
            temp[allDepartmentStudents.length] = faculties[facIndex - 1].departments[depIndex - 1].students[k];
            allDepartmentStudents = temp;
        }

        return allDepartmentStudents;
    }

    public Teacher[] allTeachersFromDepartment(int facIndex, int depIndex) {
        Teacher[] allDepartmentTeachers = new Teacher[0];

        for (int k = 0; k < faculties[facIndex - 1].departments[depIndex - 1].teachers.length; k++) {
            Teacher[] temp = new Teacher[allDepartmentTeachers.length + 1];
            System.arraycopy(allDepartmentTeachers, 0, temp, 0, allDepartmentTeachers.length);
            temp[allDepartmentTeachers.length] = faculties[facIndex - 1].departments[depIndex - 1].teachers[k];
            allDepartmentTeachers = temp;
        }

        return allDepartmentTeachers;
    }

    public Teacher[] allTeachersFromFaculty(int index) {
        Teacher[] allFacultyTeachers = new Teacher[0];

        for (int j = 0; j < faculties[index - 1].departments.length; j++) {
            for (int k = 0; k < faculties[index - 1].departments[j].teachers.length; k++) {
                Teacher[] temp = new Teacher[allFacultyTeachers.length + 1];
                System.arraycopy(allFacultyTeachers, 0, temp, 0, allFacultyTeachers.length);
                temp[allFacultyTeachers.length] = faculties[index - 1].departments[j].teachers[k];
                allFacultyTeachers = temp;
            }
        }

        return allFacultyTeachers;
    }

    public Student[] allStudentsWithGrade(Student[] array, int grade) {

        Student[] res = new Student[0];

        for(int i = 0; i < array.length; i++) {
            if(array[i].getGrade() == grade){
                Student[] temp = new Student[res.length + 1];
                System.arraycopy(res, 0, temp, 0, res.length);
                temp[res.length] = array[i];
                res = temp;
            }
        }

        return res;
    }

    public void printAllStudentsFromArray(Student[] array) {
        if (array.length == 0) {
            System.out.println("Nobody was found");
            return;
        }
        for (Student s: array) {
            System.out.println(s);
        }
    }

    public void printAllTeachersFromArray(Teacher[] array) {
        if (array.length == 0) {
            System.out.println("Nobody was found");
            return;
        }

        for (Teacher t: array) {
            System.out.println(t);
        }
    }

    public void printAllFaculties() {
        System.out.println("NaUKMA faculties:");
        if (faculties.length == 0) {
            System.out.println(BLUE + "There are no faculties" + RESET);
            return;
        }
        for (int i = 0; i < faculties.length; i++) {
            System.out.println(BLUE + (i + 1) + ". " + faculties[i].getName() + RESET);
        }
    }

    public void printAllDepartmentsOfTheFaculty(int facIndex) {
        System.out.println("Departments of " + faculties[facIndex - 1].getName() + " faculty: ");
        if (faculties[facIndex - 1].getDepartments().length == 0) {
            System.out.println(BLUE + "There are no departments yet" + RESET);
            return;
        }
        for (int i = 0; i < faculties[facIndex - 1].getDepartments().length; i++) {
            System.out.println(BLUE + (i + 1) + ". " + faculties[facIndex - 1].getDepartments()[i].getName() + RESET);
        }
    }

    public void printAllInfo() {

        if (faculties.length == 0) {
            System.out.println("University is empty yet");
            return;
        }

        for (int i = 0; i < faculties.length; i++) {
            System.out.println(SPACE + "•" + faculties[i]);

            for (int j = 0; j < faculties[i].getDepartments().length; j++) {
                System.out.println(SPACE + SPACE + "•" + faculties[i].getDepartments()[j]);

                System.out.println(SPACE + SPACE + SPACE + "• Teachers:");
                for (int k = 0; k < faculties[i].getDepartments()[j].getTeachers().length; k++)
                    System.out.println(SPACE + SPACE + SPACE + SPACE + "•" + faculties[i].getDepartments()[j].getTeachers()[k]);

                System.out.println(SPACE + SPACE + SPACE + "• Students:");
                for (int t = 0; t < faculties[i].getDepartments()[j].getStudents().length; t++)
                    System.out.println(SPACE + SPACE + SPACE + SPACE + "•" + faculties[i].getDepartments()[j].getStudents()[t]);
            }
        }
    }

    public void sortStudentsByGrade (Student[] array) {

        if (array.length == 0) {
            System.out.println("Nobody was found");
            return;
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = 1; j < array.length; j++) {
                if (array[j].getGrade() < array[j - 1].getGrade()) {
                    Student temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
            }
        }

        for (Student s: array) {
            System.out.println(s);
        }
    }

    public void sortStudentsByAlphabet(Student[] array) {

        if (array.length == 0) {
            System.out.println("Nobody was found");
            return;
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = 1; j < array.length; j++) {
                if (array[j].isHigherInAlphabet(array[j - 1])) {
                    Student temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
            }
        }

        for (Student s: array) {
            System.out.println(s);
        }
    }

    public void sortTeachersByAlphabet(Teacher[] array) {

        if (array.length == 0) {
            System.out.println("Nobody was found");
            return;
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = 1; j < array.length; j++) {
                if (array[j].isHigherInAlphabet(array[j - 1])) {
                    Teacher temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
            }
        }

        for (Teacher t: array) {
            System.out.println(t);
        }
    }

    @Override
    public String toString() {
        return "University " + this.name;
    }
}
