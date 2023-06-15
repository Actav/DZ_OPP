package OCP2;

public class Vehicle {
    private final int maxSpeed;
    private final String type;

    public Vehicle(int maxSpeed, String type) {
        this.maxSpeed = maxSpeed;
        this.type = type;
    }

    public int getMaxSpeed() {
        return this.maxSpeed;
    }

    public String getType() {
        return this.type;
    }

    public double calculateAllowedSpeed() {
        return maxSpeed;
    }
}
