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

public class Faculty {

    private String name;
    Department[] departments = new Department[0];

    public Faculty(String name) {
        this.name = name;
    }

    public void addDepartment(Department d) {
        Department[] res = new Department[departments.length + 1];

        System.arraycopy(departments, 0, res, 0, departments.length);
        res[departments.length] = d;

        setDepartments(res);
    }

    public void removeDepartment(int index) {
        Department[] res = new Department[departments.length - 1];

        System.arraycopy(departments, 0, res, 0, index - 1);
        System.arraycopy(departments, index, res, index - 1, res.length - index + 1);

        setDepartments(res);
    }

    public void editDepartment(String newName, int index) {
        departments[index - 1].setName(newName);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Department[] getDepartments() {
        return departments;
    }

    public void setDepartments(Department[] departments) {
        this.departments = departments;
    }

    @Override
    public String toString() {
        return this.name + " faculty";
    }
}