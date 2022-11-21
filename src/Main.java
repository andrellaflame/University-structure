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
public class Main {

    public static final String RESET = "\u001B[0m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String RED = "\u001B[31m";

    public static void main(String[] args) {
        University ukma = new University();
        int ans;

        do {
            System.out.println(BLUE + "1. Create/remove/edit a faculty\n" +
                    "2. Create/remove/edit a department of the faculty\n" +
                    "3. Add/remove/edit a student/teacher to the department\n" +
                    "4. Find a student/teacher by name/grade/group\n" +
                    "5. Print all students sorted by grades\n" +
                    "6. Print all students/teachers of the faculty sorted by alphabet\n" +
                    "7. Print all students of the department sorted by grades\n" +
                    "8. Print all students/teachers of the department sorted by alphabet\n" +
                    "9. Print all students of the department with certain grade\n" +
                    "10. Print all students of the department with certain grade and sorted by alphabet\n" +
                    "11. Print general information about the university\n" + RESET);

            System.out.print("* Choose the option (0 to finish): ");
            ans = DataInput.getIntInRange(0, 11);

            if (ans == 0) System.out.println(YELLOW + "Program ended" + RESET);

            else if (ans == 1) {
                System.out.println(BLUE + "1. Create a faculty\n" +
                        "2. Remove a faculty\n" +
                        "3. Edit a faculty\n" + RESET);

                System.out.print("* Choose the option: ");
                int choice = DataInput.getIntInRange(1, 3);

                if (choice == 1) {
                    System.out.print("How many faculties would you like to add: ");
                    int counter = DataInput.getIntInRange(1, 10);

                    for (int i = 0; i < counter; i++) {
                        System.out.print("Enter the name of the faculty: ");
                        ukma.addFaculty(new Faculty(DataInput.getAlphabeticString()));
                    }
                } else if (choice == 2) {
                    ukma.printAllFaculties();
                    if (ukma.getFaculties().length > 0) {
                        System.out.print("Enter the number of faculty to remove: ");
                        ukma.removeFaculty(DataInput.getIntInRange(1, ukma.getFaculties().length));
                    }
                } else {
                    ukma.printAllFaculties();

                    if (ukma.getFaculties().length > 0) {
                        System.out.print("Enter the number of faculty to edit: ");
                        int index = DataInput.getIntInRange(1, ukma.getFaculties().length);
                        System.out.print("Enter a new name of the faculty: ");
                        ukma.editFaculty(DataInput.getAlphabeticString(), index);
                    }
                }
            }

            else if (ans == 2) {
                ukma.printAllFaculties();

                if (ukma.getFaculties().length > 0) {
                    System.out.print("Enter the index of the faculty to proceed: ");
                    int f = DataInput.getIntInRange(1, ukma.getFaculties().length);

                    System.out.println(BLUE + "1. Create a department\n" +
                            "2. Remove a department\n" +
                            "3. Edit a department\n" + RESET);

                    System.out.print("* Choose the option: ");
                    int choice = DataInput.getIntInRange(1, 3);

                    if (choice == 1) {
                        System.out.print("How many departments would you like to add: ");
                        int counter = DataInput.getIntInRange(1, 10);

                        for (int i = 0; i < counter; i++) {
                            System.out.print("Enter the name of the department: ");
                            ukma.getFaculties()[f - 1].addDepartment(new Department(DataInput.getAlphabeticString()));
                        }

                    } else if (choice == 2) {
                        ukma.printAllDepartmentsOfTheFaculty(f);
                        if (ukma.getFaculties().length > 0) {
                            System.out.print("Enter the number of department to remove: ");
                            ukma.getFaculties()[f - 1].removeDepartment(DataInput.getIntInRange(1, ukma.getFaculties()[f - 1].getDepartments().length));
                        }

                    } else {
                        ukma.printAllDepartmentsOfTheFaculty(f);
                        if (ukma.getFaculties().length > 0) {
                            System.out.print("Enter the number of department to edit: ");
                            int index = DataInput.getIntInRange(1, ukma.getFaculties()[f - 1].getDepartments().length);
                            System.out.print("Enter a new name of the department: ");
                            ukma.getFaculties()[f - 1].editDepartment(DataInput.getAlphabeticString(), index);
                        }
                    }
                }
            }

            else if (ans == 3) {
                ukma.printAllFaculties();

                if (ukma.getFaculties().length > 0) {
                    System.out.print("Enter the index of the faculty to proceed: ");
                    int f = DataInput.getIntInRange(1, ukma.getFaculties().length);

                    ukma.printAllDepartmentsOfTheFaculty(f);

                    System.out.print("Enter the index of the department to proceed: ");
                    int d = DataInput.getIntInRange(1, ukma.getFaculties()[f - 1].getDepartments().length);

                    System.out.print("Enter 1 (student)/ 2 (teacher) to work with: ");
                    int person = DataInput.getIntInRange(1, 2);

                    if (person == 1) {
                        System.out.println(BLUE + "1. Create a student\n" +
                                "2. Remove a student\n" +
                                "3. Edit a student\n" + RESET);

                        System.out.print("* Choose the option: ");
                        int choice = DataInput.getIntInRange(1, 3);

                        if (choice == 1) {
                            System.out.print("How many students would you like to add: ");
                            int counter = DataInput.getIntInRange(1, 10);

                            for (int i = 0; i < counter; i++) {
                                System.out.print("Enter the name of the student: ");
                                String name = DataInput.getAlphabeticString();

                                System.out.print("Enter the group of the student: ");
                                int group = DataInput.getIntInRange(1, 100);

                                System.out.print("Enter the grade of the student: ");
                                int grade = DataInput.getIntInRange(1, 6);

                                ukma.getFaculties()[f - 1].getDepartments()[d - 1].add(new Student(name, group, grade));
                            }
                        }

                        else if (choice == 2) {
                            ukma.printAllStudentsFromArray(ukma.getFaculties()[f - 1].getDepartments()[d - 1].getStudents());

                            if (ukma.getFaculties()[f - 1].getDepartments()[d - 1].getStudents().length > 0) {
                                System.out.print("Enter the index of the student to remove: ");
                                ukma.getFaculties()[f - 1].getDepartments()[d - 1].removeStudent(DataInput.getIntInRange(1, ukma.getFaculties()[f - 1].getDepartments()[d - 1].getStudents().length));
                            }
                        }

                        else if (choice == 3) {
                            ukma.printAllStudentsFromArray(ukma.getFaculties()[f - 1].getDepartments()[d - 1].getStudents());

                            if (ukma.getFaculties()[f - 1].getDepartments()[d - 1].getStudents().length > 0) {
                                System.out.print("Enter the index of the student to edit: ");
                                int index = DataInput.getIntInRange(1, ukma.getFaculties()[f - 1].getDepartments()[d - 1].getStudents().length);

                                System.out.print("Enter a new group of the student: ");
                                int group = DataInput.getIntInRange(1, 100);

                                System.out.print("Enter a new grade of the student: ");
                                int grade = DataInput.getIntInRange(1, 6);

                                ukma.getFaculties()[f - 1].getDepartments()[d - 1].editStudent(index, DataInput.getAlphabeticString(), group, grade);
                            }
                        }
                    }

                    else if (person == 2) {
                        System.out.println(BLUE + "1. Create a teacher\n" +
                                "2. Remove a teacher\n" +
                                "3. Edit a teacher\n" + RESET);

                        System.out.print("* Choose the option: ");
                        int choice = DataInput.getIntInRange(1, 3);

                        if (choice == 1) {
                            System.out.print("How many teachers would you like to add: ");
                            int counter = DataInput.getIntInRange(1, 10);

                            for (int i = 0; i < counter; i++) {
                                System.out.print("Enter the name of the teacher: ");
                                String name = DataInput.getAlphabeticString();

                                System.out.print("Enter the group of the teacher: ");
                                int group = DataInput.getIntInRange(1, 100);

                                System.out.print("Enter the grade of the teacher: ");
                                int grade = DataInput.getIntInRange(1, 6);

                                ukma.getFaculties()[f - 1].getDepartments()[d - 1].add(new Teacher(name, group, grade));
                            }
                        }

                        else if (choice == 2) {
                            ukma.printAllTeachersFromArray(ukma.getFaculties()[f - 1].getDepartments()[d - 1].getTeachers());

                            if (ukma.getFaculties()[f - 1].getDepartments()[d - 1].getTeachers().length > 0) {
                                System.out.print("Enter the index of the teacher to remove: ");
                                ukma.getFaculties()[f - 1].getDepartments()[d - 1].removeTeacher(DataInput.getIntInRange(1, ukma.getFaculties()[f - 1].getDepartments()[d - 1].getTeachers().length));
                            }
                        }

                        else if (choice == 3) {
                            ukma.printAllTeachersFromArray(ukma.getFaculties()[f - 1].getDepartments()[d - 1].getTeachers());

                            if (ukma.getFaculties()[f - 1].getDepartments()[d - 1].getTeachers().length > 0) {
                                System.out.print("Enter the index of the teacher to edit: ");
                                int index = DataInput.getIntInRange(1, ukma.getFaculties()[f - 1].getDepartments()[d - 1].getTeachers().length);

                                System.out.print("Enter a new group of the teacher: ");
                                int group = DataInput.getIntInRange(1, 100);

                                System.out.print("Enter a new grade of the teacher: ");
                                int grade = DataInput.getIntInRange(1, 6);

                                ukma.getFaculties()[f - 1].getDepartments()[d - 1].editTeacher(index, DataInput.getAlphabeticString(), group, grade);
                            }
                        }
                    }
                }
            }

            else if (ans == 4) {
                System.out.print("Enter 1 (student)/ 2 (teacher) to find: ");
                int person = DataInput.getIntInRange(1, 2);

                if (person == 1) {
                    System.out.print("Search by 1 (name)/ 2 (grade)/ 3 (group): ");
                    int choice = DataInput.getIntInRange(1, 3);

                    if (choice == 1) {
                        System.out.print("Enter student's name: ");
                        String name = DataInput.getAlphabeticString();

                        ukma.findStudentByName(name);
                    } else if (choice == 2) {
                        System.out.print("Enter student's grade: ");
                        int grade = DataInput.getIntInRange(1, 6);

                        ukma.findStudentByGrade(grade);
                    } else if (choice == 3) {
                        System.out.print("Enter student's group: ");
                        int group = DataInput.getIntInRange(1, 100);

                        ukma.findStudentByGroup(group);
                    }
                }

                else if (person == 2) {
                    System.out.print("Search by 1 (name)/ 2 (grade)/ 3 (group): ");
                    int choice = DataInput.getIntInRange(1, 3);

                    if (choice == 1) {
                        System.out.print("Enter teacher's name: ");
                        String name = DataInput.getAlphabeticString();

                        ukma.findTeacherByName(name);
                    } else if (choice == 2) {
                        System.out.print("Enter teacher's grade: ");
                        int grade = DataInput.getIntInRange(1, 6);

                        ukma.findTeacherByGrade(grade);
                    } else if (choice == 3) {
                        System.out.print("Enter teacher's group: ");
                        int group = DataInput.getIntInRange(1, 100);

                        ukma.findTeacherByGroup(group);
                    }
                }
            }

            else if (ans == 5) {
                ukma.sortStudentsByGrade(ukma.allStudents());
            }

            else if (ans == 6) {
                ukma.printAllFaculties();
                if (ukma.getFaculties().length > 0) {
                    System.out.print("Enter the index of the faculty to proceed: ");
                    int f = DataInput.getIntInRange(1, ukma.getFaculties().length);

                    System.out.print("Enter 1 (student)/ 2 (teacher) to find: ");
                    int person = DataInput.getIntInRange(1, 2);

                    if (person == 1) {
                        ukma.sortStudentsByAlphabet(ukma.allStudentsFromFaculty(f));
                    }

                    else if (person == 2) {
                        ukma.sortTeachersByAlphabet(ukma.allTeachersFromFaculty(f));
                    }
                }
            }

            else if (ans == 7) {
                ukma.printAllFaculties();

                if (ukma.getFaculties().length > 0) {
                    System.out.print("Enter the index of the faculty to proceed: ");
                    int f = DataInput.getIntInRange(1, ukma.getFaculties().length);

                    ukma.printAllDepartmentsOfTheFaculty(f);

                    System.out.print("Enter the index of the department to proceed: ");
                    int d = DataInput.getIntInRange(1, ukma.getFaculties()[f - 1].getDepartments().length);

                    ukma.sortStudentsByGrade(ukma.allStudentsFromDepartment(f, d));
                }
            }

            else if (ans == 8) {
                ukma.printAllFaculties();

                if (ukma.getFaculties().length > 0) {
                    System.out.print("Enter the index of the faculty to proceed: ");
                    int f = DataInput.getIntInRange(1, ukma.getFaculties().length);

                    ukma.printAllDepartmentsOfTheFaculty(f);

                    System.out.print("Enter the index of the department to proceed: ");
                    int d = DataInput.getIntInRange(1, ukma.getFaculties()[f - 1].getDepartments().length);

                    System.out.print("Enter 1 (student)/ 2 (teacher) to find: ");
                    int person = DataInput.getIntInRange(1, 2);

                    if (person == 1) {
                        ukma.sortStudentsByAlphabet(ukma.allStudentsFromDepartment(f, d));                    }

                    else if (person == 2) {
                        ukma.sortTeachersByAlphabet(ukma.allTeachersFromDepartment(f, d));                    }
                }
            }

            else if (ans == 9) {
                ukma.printAllFaculties();

                if (ukma.getFaculties().length > 0) {
                    System.out.print("Enter the index of the faculty to proceed: ");
                    int f = DataInput.getIntInRange(1, ukma.getFaculties().length);

                    ukma.printAllDepartmentsOfTheFaculty(f);

                    System.out.print("Enter the index of the department to proceed: ");
                    int d = DataInput.getIntInRange(1, ukma.getFaculties()[f - 1].getDepartments().length);

                    System.out.print("Enter the grade of the student: ");
                    int grade = DataInput.getIntInRange(1, 6);

                    ukma.printAllStudentsFromArray(ukma.allStudentsWithGrade(ukma.allStudentsFromDepartment(f, d), grade));
                }
            }

            else if (ans == 10) {
                ukma.printAllFaculties();

                if (ukma.getFaculties().length > 0) {
                    System.out.print("Enter the index of the faculty to proceed: ");
                    int f = DataInput.getIntInRange(1, ukma.getFaculties().length);

                    ukma.printAllDepartmentsOfTheFaculty(f);

                    System.out.print("Enter the index of the department to proceed: ");
                    int d = DataInput.getIntInRange(1, ukma.getFaculties()[f - 1].getDepartments().length);

                    System.out.print("Enter the grade of the student: ");
                    int grade = DataInput.getIntInRange(1, 6);

                    ukma.sortStudentsByAlphabet(ukma.allStudentsWithGrade(ukma.allStudentsFromDepartment(f, d), grade));
                }
            }

            else if (ans == 11) {
                System.out.println(ukma);
                ukma.printAllInfo();
            }

            System.out.println(RED + "\n-------------------\n" + RESET);


        } while (ans != 0);

    }
}
