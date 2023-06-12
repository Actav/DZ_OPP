package Services;

import StudentDomen.PersonComparator;
import StudentDomen.Teacher;

import java.util.ArrayList;
import java.util.List;

public class TeacherService implements iPersonService<Teacher> {
    private List<Teacher> teachers;

    public TeacherService() {
        this.teachers = new ArrayList<>();
    }

    /**
     * @return объект содержащий все записи преподавателей
     */
    @Override
    public List<Teacher> getAll() {
        return teachers;
    }

    /**
     * Создание записи преподавателя
     *
     * @param firstName  имя преподавателя
     * @param secondName фамилия преподавателя
     * @param age        возраст преподавателя
     */
    @Override
    public void create(String firstName, String secondName, int age) {
        Teacher per = new Teacher(firstName, secondName, age, null);
    }

    /**
     * Сортирует список преподавателей отсортированный по имени и фамилии
     *
     * @return отсортированный список преподавателей
     */
    public List<Teacher> getSortedByFIOTeachersList() {
        List<Teacher> newTeachersList = new ArrayList<>(teachers);
        newTeachersList.sort(new PersonComparator<>());

        return newTeachersList;
    }
}
