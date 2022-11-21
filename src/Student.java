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

public class Student {

    private String pib;
    private int group, grade;


    public Student(String pib, int group, int grade) {
        this.pib = pib;
        this.group = group;
        this.grade = grade;
    }

    public boolean isHigherInAlphabet (Student input){
        String base = this.getPib().toLowerCase();
        String comp = input.getPib().toLowerCase();

        int minLenght;
        boolean lowerBase;

        if(base.length() < comp.length()){
            minLenght = base.length();
            lowerBase = true;
        }else{
            minLenght = comp.length();
            lowerBase = false;
        }

        for(int i = 0; i < minLenght; i++){
            if(base.charAt(i) < comp.charAt(i)){
                return true;
            }else if(base.charAt(i) > comp.charAt(i)){
                return false;
            }
        }
        return lowerBase;
    }


    public String getPib() {
        return pib;
    }

    public void setPib(String pib) {
        this.pib = pib;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return this.pib + ", whose group is " + this.group + ", and grade is " + this.grade;
    }
}
