package StudentDomen;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StudentGroup implements Iterable<Student>, Comparable<StudentGroup> {
    List<Student> group;
    private int idGroup;

    public StudentGroup(List<Student> group, int idGroup) {
        this.group = group;
        this.idGroup = idGroup;
    }

    public List<Student> getGroup() {
        return group;
    }

    public void setGroup(List<Student> group) {
        this.group = group;
    }

    public int getIdGroup() {
        return idGroup;
    }

    public void setIdGroup(int idGroup) {
        this.idGroup = idGroup;
    }

    @Override
    public String toString() {
        List<String> s = new ArrayList<>();
        for (Student stud : this) {
            s.add(stud.getFirstName() + " " + stud.getSecondName());
        }

        return "StudentGroup{" +
                "idGroup=" + idGroup +
                ", groupSize=" + group.size() +
                ", group=" + s +
                '}';
    }

    @Override
    public Iterator<Student> iterator() {

        return new Iterator<Student>()
        {
            private int counter;
       
            @Override
            public boolean hasNext() {
                return counter<group.size();
            }
        
            @Override
            public Student next() {
                if (!hasNext()) {
                    return null;
                }
                return group.get(counter++);
            }
        };

        //return new SGIterator(group);
    }

    @Override
    public int compareTo(StudentGroup o) {
        if (this.group.size() == o.group.size()) {
            return Integer.compare(this.getIdGroup(), o.getIdGroup());
        } else if (this.group.size() < o.group.size()) {
            return -1;
        } else {
            return 1;
        }
    }
}
