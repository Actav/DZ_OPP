package StudentDomain;

public class Student extends Person {
    int id;

    public Student(String firstName, String secondName, int age, int id) {
        super(firstName, secondName, age);
        this.id = id;
    }

    /**
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id присваевает уник. номер
     */
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id + '\'' +
                ", firstName='" + super.getFirstName() + '\'' +
                ", secondName='" + super.getSecondName() + '\'' +
                ", age=" + super.getAge() +
                '}';
    }

}
