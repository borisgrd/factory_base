
public class FactoryPattern {

    public interface MotorVehicle {
        void build();
    }

    public class Motorcycle implements MotorVehicle {
        @Override
        public void build() {
            System.out.println("Build Motorcycle");
        }
    }

    public class Car implements MotorVehicle {
        @Override
        public void build() {
            System.out.println("Build Car");
        }
    }

    public abstract class MotorVehicleFactory {
        public MotorVehicle create() {
            MotorVehicle vehicle = createMotorVehicle();
            vehicle.build();
            return vehicle;
        }

        protected abstract MotorVehicle createMotorVehicle();
    }

    public class MotorcycleFactory extends MotorVehicleFactory {
        @Override
        protected MotorVehicle createMotorVehicle() {
            return new Motorcycle();
        }
    }

    public class CarFactory extends MotorVehicleFactory {
        @Override
        protected MotorVehicle createMotorVehicle() {
            return new Car();
        }
    }

    public void construct() {

        var carFactory = new CarFactory();
        var motorcycleFactory = new MotorcycleFactory();
        carFactory.createMotorVehicle().build();
        motorcycleFactory.createMotorVehicle().build();

    }

    public class Solution {
        public static void main(String[] args) {
            var p = new FactoryPattern();
            p.construct();
        }
    }

}
