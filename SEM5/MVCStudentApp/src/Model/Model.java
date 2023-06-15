package Model;

import java.util.List;

import Controller.iGetModel;

public class Model implements iGetModel {
    private final List<Student> students;

    public Model(List<Student> students) {
        this.students = students;
    }

    public List<Student> getAllStudents()
    {
        return students;
    }

    @Override
    public boolean deleteStudent(int studentId) {
        return false;
    }
}
