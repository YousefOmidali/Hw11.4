import Entity.Employee;
import Entity.Master;
import Entity.MasterLevel;
import Entity.Student;
import Repository.Methods;
import Services.EmployeeService;
import Services.MasterService;
import Services.ScoreAndCourseService;
import Services.StudentService;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Methods methods = new Methods();
        EmployeeService employeeService = new EmployeeService();
        MasterService masterService = new MasterService();
        StudentService studentService = new StudentService();
        ScoreAndCourseService scoreAndCourseService = new ScoreAndCourseService();
        boolean login = true;
        boolean profileMenu = false;
        int role = -1, salary = 0, unit = 0;
        String firstName, lastName, username, password, courseNameInMain;
        employeeService.signUp(new Employee("yousef", "123", "yousef", "omidali", 5000000));
        int order = 0;
        int index = 0;
        int studentIndexInMain = 0;
        int score = 0;
        int tedadJalasatTadris = 0;
        String courseName = "";

        while (login) {
            methods.showLoginMenu();
            int loginStats = -1;
            try {
                role = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("enter number");
            }
            scanner.nextLine();
            if (role == 1) {
                System.out.println("Please enter your username: ");
                username = scanner.nextLine();
                System.out.println("Please enter your password: ");
                password = scanner.nextLine();
                if (role == 1) {
                    loginStats = studentService.studentCheck(username, password);
                    if (loginStats == 1) {
                        login = false;
                        profileMenu = true;
                        break;
                    }
                }


            } else if (role == 2) {
                System.out.println("Please enter your username: ");
                username = scanner.nextLine();
                System.out.println("Please enter your password: ");
                password = scanner.nextLine();
                loginStats = masterService.masterCheck(username, password);
                if (loginStats == 1) {
                    login = false;
                    profileMenu = true;
                    break;
                }
            } else if (role == 3) {
                System.out.println("Please enter your username: ");
                username = scanner.nextLine();
                System.out.println("Please enter your password: ");
                password = scanner.nextLine();
                loginStats = employeeService.employeeCheck(username, password);
                if (loginStats == 1) {
                    login = false;
                    profileMenu = true;
                    break;
                }
            }
        }
        while (profileMenu) {
            if (role == 1) {
                methods.studentMenu();
                try {
                    order = scanner.nextInt();
                    System.out.println("please enter your student index: ");
                    index = scanner.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Just enter number! ");
                }

                if (order == 1)
                    studentService.studentInfo(index);
                else if (order == 2)
                    scoreAndCourseService.viewCourseList();
                else if (order == 3) {
                    System.out.println(studentService.scoreAvg(index));
                    System.out.println("Check that can you take a course? Enter the course name: "); // check baraye bar nadashtane yek dars , 2 bar
                    courseNameInMain = scanner.nextLine();
                    if (studentService.passCourseCheck(index, courseNameInMain))
                        System.out.println("Allowed");
                    else System.out.println("You have passed this course once! ");

                } else if (order == 4) {
                    login = true;
                    profileMenu = false;
                    break;
                } else System.out.println("Wrong number! ");
            } else if (role == 2) {
                methods.masterMenu();
                order = scanner.nextInt();
                System.out.println("please enter your Master index: ");
                try {
                    index = scanner.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Just enter number! ");
                }
                if (order == 1)
                    masterService.masterInfo(index);
                else if (order == 2) {
                    try {
                        System.out.println("Enter the student's Index: ");
                        studentIndexInMain = scanner.nextInt();
                        System.out.println("Enter course name: ");
                        courseName = scanner.nextLine();
                        System.out.println("Enter the score: ");
                        score = scanner.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("Just enter number! ");
                    }
                    studentService.scoreRegister(studentIndexInMain, courseName, score);
                } else if (order == 3) {
                    System.out.println("Please enter number session you have teach: ");
                    try {
                        tedadJalasatTadris = scanner.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("Just enter number! ");
                    }

                    System.out.println(masterService.payslip(index, tedadJalasatTadris));
                } else if (order == 4) {
                    login = true;
                    profileMenu = false;
                    break;
                }
            } else if (role == 3) {
                methods.employeeMenu();
                try {
                    order = scanner.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Just enter number! ");
                }

                if (order == 1) {
                    scanner.nextLine();
                    System.out.println("Enter student's first name:");
                    firstName = scanner.nextLine();
                    System.out.println("Enter student's last name:");
                    lastName = scanner.nextLine();
                    System.out.println("Enter student's username :");
                    username = scanner.nextLine();
                    System.out.println("Enter student's password: ");
                    password = scanner.nextLine();
                    Student student = new Student(username, password, firstName, lastName, null);
                    studentService.sigUp(student);
                    System.out.println("Done! ");
                }
                if (order == 2) {
                    System.out.println("Enter student's Index: ");

                    try {
                        index = scanner.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("Just enter number! ");
                    }

                    studentService.remove(index);
                }
                if (order == 3) {
                    System.out.println("Enter student's Index: ");
                    try {
                        index = scanner.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("Just enter number! ");
                    }
                    System.out.println("Enter student's first name:");
                    firstName = scanner.nextLine();
                    System.out.println("Enter student's last name:");
                    lastName = scanner.nextLine();
                    System.out.println("Enter student's username :");
                    username = scanner.nextLine();
                    System.out.println("Enter student's password: ");
                    password = scanner.nextLine();
                    studentService.edit(index, firstName, lastName, username, password);
                }
                if (order == 4) {
                    System.out.println("Enter student's first name:");
                    firstName = scanner.nextLine();
                    System.out.println("Enter student's last name:");
                    lastName = scanner.nextLine();
                    System.out.println("Enter student's username :");
                    username = scanner.nextLine();
                    System.out.println("Enter student's password: ");
                    password = scanner.nextLine();
                    System.out.println("Enter the level of master: ");
                    String masterLevel = scanner.nextLine().toUpperCase();
                    if (masterLevel.equals("HAGHOTADRIS")) {
                        Master master = new Master(username, password, firstName, lastName, null, MasterLevel.HAGHOTADRIS);
                        masterService.signUp(master);
                    } else if (masterLevel.equals("HEIATELMI")) {
                        Master master = new Master(username, password, firstName, lastName, null, MasterLevel.HEIATELMI);
                        masterService.signUp(master);
                    }
                }
                if (order == 5) {
                    System.out.println("Enter master's Index: ");
                    try {
                        index = scanner.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("Just enter number! ");
                    }
                    masterService.remove(index);
                }

                if (order == 6) {
                    System.out.println("Please enter master's Index: ");
                    try {
                        index = scanner.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("Just enter number! ");
                    }

                    System.out.println("Enter master's first name:");
                    firstName = scanner.nextLine();
                    System.out.println("Enter master's last name:");
                    lastName = scanner.nextLine();
                    System.out.println("Enter master's username :");
                    username = scanner.nextLine();
                    System.out.println("Enter master's password: ");
                    password = scanner.nextLine();
                    System.out.println("Enter the level of master: ");
                    String masterLevel = scanner.nextLine().toUpperCase();
                    if (masterLevel.equals("HAGHOTADRIS")) {
                        Master master = new Master(username, password, firstName, lastName, null, MasterLevel.HAGHOTADRIS);
                        masterService.edit(index, master);
                    } else if (masterLevel.equals("HEIATELMI")) {
                        Master master = new Master(username, password, firstName, lastName, null, MasterLevel.HEIATELMI);
                        masterService.edit(index, master);
                    }
                }

                if (order == 7) {
                    System.out.println("Enter employee's first name:");
                    firstName = scanner.nextLine();
                    System.out.println("Enter employee's last name:");
                    lastName = scanner.nextLine();
                    System.out.println("Enter employee's username :");
                    username = scanner.nextLine();
                    System.out.println("Enter employee's password: ");
                    password = scanner.nextLine();
                    System.out.println("Enter employee's salary:  ");
                    try {
                        salary = scanner.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("Just enter number! ");
                    }
                    Employee employee = new Employee(username, password, firstName, lastName, salary);
                    employeeService.signUp(employee);
                }
                if (order == 8) {
                    System.out.println("Enter employee's Index: ");
                    try {
                        index = scanner.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("Just enter number! ");
                    }

                    employeeService.removeEmployee(index);
                }
                if (order == 9) {
                    System.out.println("Enter employee's Index: ");
                    try {
                        index = scanner.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("Just enter number! ");
                    }

                    System.out.println("Enter employee's first name:");
                    firstName = scanner.nextLine();
                    System.out.println("Enter employee's last name:");
                    lastName = scanner.nextLine();
                    System.out.println("Enter employee's username :");
                    username = scanner.nextLine();
                    System.out.println("Enter employee's password: ");
                    password = scanner.nextLine();
                    System.out.println("Enter employee's salary:  ");
                    try {
                        salary = scanner.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("Just enter number! ");
                    }

                    Employee employee = new Employee(username, password, firstName, lastName, salary);
                    employeeService.editEmployee(index, employee);
                }
                if (order == 10) {
                    System.out.println("Enter course name: ");
                    courseNameInMain = scanner.nextLine();
                    System.out.println("Enter number of course unit: ");
                    try {
                        unit = scanner.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("Just enter number! ");
                    }

                    scoreAndCourseService.addCourse(courseNameInMain, unit);
                }
                if (order == 11) {
                    System.out.println("Enter the index of course: ");
                    index = scanner.nextInt();
                   scoreAndCourseService.removeCourse(index);
                }
                if (order == 12) {
                    try {
                        System.out.println("Enter course index: ");
                        index = scanner.nextInt();
                        System.out.println("Enter course new name: ");
                        courseNameInMain = scanner.nextLine();
                        System.out.println("Enter course's unit: ");
                        unit = scanner.nextInt();
                        scoreAndCourseService.editCourse(index, courseNameInMain, unit);
                    } catch (InputMismatchException e) {
                        System.out.println("Just enter number! ");
                    }

                }
                if (order == 13) {
                    System.out.println("Enter employee Index: ");
                    index = scanner.nextInt();
                    try {
                        employeeService.viewEmployeeSalaryAndInfo(index);
                    } catch (InputMismatchException e) {
                        System.out.println("Just enter number! ");
                    }

                    if (order == 14) {
                        profileMenu = false;
                        login = true;
                    }
                }
            }
        }
    }
}
