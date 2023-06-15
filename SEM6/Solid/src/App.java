import DIP.DieselEngine;
import DIP.PetrolEngine;
import DIP.iEngine;
import ISP.Circle;
import ISP.Cube;

import LSP.Rectangle;

import LSP.Square;
import OCP1.*;
import OCP2.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        // OCP1
        System.out.println("\n============OCP1=============");
        List<iVehicle> vehicles1 = new ArrayList<>();
        vehicles1.add(new OCP1.Bus(150, "Bus"));
        vehicles1.add(new OCP1.Car(290, "Car"));

        for (iVehicle vehicle : vehicles1) {
            System.out.println(vehicle.allowedSpeed());
        }

        // OCP2
        System.out.println("\n============OCP2=============");
        List<OCP2.Vehicle> vehicles2 = new ArrayList<>();
        vehicles2.add(new OCP2.Bus(150, "Bus"));
        vehicles2.add(new OCP2.Car(290, "Car"));

        SpeedCalculation speedCalculation = new SpeedCalculation();

        for (OCP2.Vehicle vehicle : vehicles2) {
            // Можете пояснить необходимость использования speedCalculation.calculateAllowedSpeed(vehicle) ?
            // если можно вызвать просто vehicle.calculateAllowedSpeed()

            double allowedSpeed = speedCalculation.calculateAllowedSpeed(vehicle);
            System.out.println(allowedSpeed);
        }

        // ISP
        System.out.println("\n============ISP=============");
        Circle circle = new Circle(5.0);
        System.out.println("Площадь круга: " + circle.area());

        Cube cube = new Cube(4);
        System.out.println("Объем куба: " + cube.volume());
        System.out.println("Площадь поверхности куба: " + cube.area());

        // LSP
        System.out.println("\n============LSP=============");
        Rectangle rectangle = new Square();
        rectangle.setWidth(5);
        rectangle.setHeight(4);
        System.out.println("Площадь прямоугольника: " + rectangle.area());

        Square square = new Square();
        square.setSide(5);
        System.out.println("Площадь квадрата: " + square.area());

        // DIP
        System.out.println("\n============DIP=============");
        iEngine petrol = new PetrolEngine();
        DIP.Car petrolCar = new DIP.Car(petrol);
        petrolCar.start();

        iEngine diesel = new DieselEngine();
        DIP.Car dieselCar = new DIP.Car(diesel);
        dieselCar.start();
    }
}
