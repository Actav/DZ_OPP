package Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Model.Student;

public class Controller {
    private final iGetView view;
    private final iGetModel model;
    private List<Student> students;

    public Controller(iGetView view, iGetModel model) {
        this.view = view;
        this.model = model;
        this.students = new ArrayList<Student>();
    }

    public void getAllStudents() {
        students = model.getAllStudents();
    }

    public boolean testData() {
        if (students.size() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public void update() {
        //MVP
        getAllStudents();
        if(testData())
        {
            view.printAllStudents(students);
        }
        else{
            System.out.println("Список студентов пуст!");
        }

        //MVC
        //view.printAllStudents(model.getAllStudents());
    }

    public void run()
    {
        Commands com = Commands.NONE;
        boolean getNewIteration = true;
        while(getNewIteration)
        {
            String command = view.prompt("Введите команду:");

            try {
                com = Commands.valueOf(command.toUpperCase());
                switch (com) {
                    case EXIT -> {
                        getNewIteration = false;
                        System.out.println("Выход из программы!");
                    }
                    case LIST -> {
                        getAllStudents();
                        view.printAllStudents(students);
                    }
                    case DELETE -> {
                        System.out.print("Введите номер студента для удаления: ");
                        Scanner scanner = new Scanner(System.in);
                        int studentId = Integer.parseInt(scanner.nextLine());

                        boolean deleted = model.deleteStudent(studentId);
                        if (deleted) {
                            System.out.println("Студент успешно удален.");
                        } else {
                            System.out.println("Студент с указанным номером не найден.");
                        }

                        break;
                    }
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Некорректная команда");
            }
        }
    }

}
