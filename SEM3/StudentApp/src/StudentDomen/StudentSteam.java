package StudentDomen;

import java.util.Iterator;
import java.util.List;

public class StudentSteam implements Iterable<StudentGroup> {
    List<StudentGroup> steam;
    private int idSteam;

    public StudentSteam(List<StudentGroup> steam, int idSteam) {
        this.steam = steam;
        this.idSteam = idSteam;
    }

    public List<StudentGroup> getSteam() {
        return steam;
    }

    public void setSteam(List<StudentGroup> steam) {
        this.steam = steam;
    }

    public int getIdSteam() {
        return idSteam;
    }

    public void setIdSteam(int idSteam) {
        this.idSteam = idSteam;
    }

    @Override
    public String toString() {
        return "StudentSteam{" +
                "idSteam=" + idSteam +
                ", steamSize=" + steam.size() +
                ", steam=" + steam +
                '}';
    }

    @Override
    public Iterator<StudentGroup> iterator() {
        return new Iterator<>() {
            private int index = 0;
            @Override
            public boolean hasNext() {
                return index < steam.size();
            }

            @Override
            public StudentGroup next() {
                return hasNext() ? steam.get(index++) : null;
            }
        };
    }
}
