package OCP1;

public class Vehicle implements iVehicle {
    int maxSpeed;
    String type;

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

    @Override
    public double allowedSpeed() {
        return maxSpeed;
    }
}
