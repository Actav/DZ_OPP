package Model;

import Controller.iGetModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HashModel implements iGetModel {
    private final HashMap<Integer, Student> studentMap;

    public HashModel(HashMap<Integer, Student> studentMap) {
        this.studentMap = studentMap;
    }

    public List<Student> getAllStudents() {
        return new ArrayList<>(studentMap.values());
    }

    @Override
    public boolean deleteStudent(int studentId) {
        Student removedStudent = studentMap.remove(studentId);

        return removedStudent != null;
    }
}
