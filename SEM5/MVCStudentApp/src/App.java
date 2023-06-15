import Controller.Controller;
import Controller.iGetModel;
import Controller.iGetView;
import Model.HashModel;
import Model.Student;
import View.ViewEng;

import java.util.HashMap;

public class App {
    public static void main(String[] args) throws Exception {
       Student s1 = new Student("Сергей", "Иванов", 21, 101);
       Student s2 = new Student("Андрей", "Сидоров", 22, 111);
       Student s3 = new Student("Иван", "Петров", 22, 121);
       Student s4 = new Student("Игорь", "Иванов", 23, 301);
       Student s5 = new Student("Даша", "Цветкова", 25, 171);
       Student s6 = new Student("Лена", "Незабудкина", 23, 104);

        HashMap<Integer, Student> studentMap = new HashMap<>();
        studentMap.put(s1.getId(), s1);
        studentMap.put(s2.getId(), s2);
        studentMap.put(s3.getId(), s3);
        studentMap.put(s4.getId(), s4);
        studentMap.put(s5.getId(), s5);
        studentMap.put(s6.getId(), s6);

       iGetModel hashModek = new HashModel(studentMap);

       iGetView viewEng = new ViewEng();

       Controller controller = new Controller(viewEng, hashModek);
       controller.run();
    }
}
