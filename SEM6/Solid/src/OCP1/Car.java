package OCP1;

public class Car extends Vehicle {
    public Car(int maxSpeed, String type) {
        super(maxSpeed, type);
    }

    @Override
    public double allowedSpeed() {
        return Car.super.getMaxSpeed() * 0.8;
    }
}
