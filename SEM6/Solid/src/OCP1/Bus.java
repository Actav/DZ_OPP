package OCP1;

public class Bus extends Vehicle {
    public Bus(int maxSpeed, String type) {
        super(maxSpeed, type);
    }

    @Override
    public double allowedSpeed() {
        return Bus.super.getMaxSpeed() * 0.6;
    }
}
