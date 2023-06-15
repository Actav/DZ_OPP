package DIP;

public class Car {
    private final iEngine engine;

    public Car(iEngine engine) {
        this.engine = engine;
    }

    public void start() {
        this.engine.start();
    }
}

