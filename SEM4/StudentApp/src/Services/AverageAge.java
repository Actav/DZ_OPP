package Services;

import StudentDomen.Person;

import java.util.List;

public class AverageAge<T extends Person> {
    private final int roundTo;
    private final List<T> persons;

    public AverageAge(List<T> persons, int roundTo) {
        this.persons = persons;
        this.roundTo = roundTo;
    }

    public double getAverageAge() {
        return calculateAverageAge();
    }

    private double calculateAverageAge() {
        int totalAge = 0;
        for (T person : persons) {
            totalAge += person.getAge();
        }
        double averageAge = (double) totalAge / persons.size();

        return roundTo(averageAge, roundTo);
    }

    private double roundTo(double number, int roundTo) {
        double scale = Math.pow(10, roundTo);

        return Math.round(number * scale) / scale;
    }
}
