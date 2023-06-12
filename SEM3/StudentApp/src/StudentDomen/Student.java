package StudentDomen;

public class Student extends Person implements Comparable<Student>{
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
                "firstName='" + super.firstName + '\'' +
                ", secondName='" + super.getSecondName() + '\'' +
                ", age=" + super.getAge() +
                ", id=" + id +
                '}';
    }

    @Override
    public int compareTo(Student o) {
        if(this.getAge()==o.getAge())
        {
            return Integer.compare(this.getId(), o.getId());
        }
        if(this.getAge()<o.getAge())
        {
        return -1;
        }        
        return 1;
    }
  }
