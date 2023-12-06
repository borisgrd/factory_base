
public class FactoryPattern {

    public interface MotorVehicle {
        void build();
    }

    public interface ElectricVehicle {
        void build();
    }

    public abstract class Corporation {
        public abstract MotorVehicle createMotorVehicle();

        public abstract ElectricVehicle createElectricVehicle();
    }

    public class FutureVehicleMotorcycle implements MotorVehicle {
        @Override
        public void build() {
            System.out.println("Future Vehicle Motorcycle");
        }
    }

    public class FutureVehicleElectricCar implements ElectricVehicle {
        @Override
        public void build() {
            System.out.println("Future Vehicle Electric Car");
        }
    }

    public class NextGenMotorcycle implements MotorVehicle {
        @Override
        public void build() {
            System.out.println("NextGen Motorcycle");
        }
    }

    public class NextGenElectricCar implements ElectricVehicle {
        @Override
        public void build() {
            System.out.println("NextGen Electric Car");
        }
    }

    public class FutureVehicleCorporation extends Corporation {
        @Override
        public MotorVehicle createMotorVehicle() {
            return new FutureVehicleMotorcycle();
        }

        @Override
        public ElectricVehicle createElectricVehicle() {
            return new FutureVehicleElectricCar();
        }
    }

    public class NextGenCorporation extends Corporation {
        @Override
        public MotorVehicle createMotorVehicle() {
            return new NextGenMotorcycle();
        }

        @Override
        public ElectricVehicle createElectricVehicle() {
            return new NextGenElectricCar();
        }
    }

    // region regular factory
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
    // endregion regular factory

    public void constructRegularFactory() {

        var carFactory = new CarFactory();
        var motorcycleFactory = new MotorcycleFactory();
        carFactory.createMotorVehicle().build();
        motorcycleFactory.createMotorVehicle().build();

    }

    public void constructAbstractFactory() {

        var fvc = new FutureVehicleCorporation();
        var ngc = new NextGenCorporation();

        fvc.createMotorVehicle().build();
        fvc.createElectricVehicle().build();

        ngc.createMotorVehicle().build();

        ngc.createElectricVehicle().build();

    }

}
