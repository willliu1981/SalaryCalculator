package test.test16;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test16LazyDemo {

//車子工廠
	static class CarAssembler {
		CarFactory factory;
		int carIndex = 0;
		String carName;
		Car car;
		CarFactory[] carfactories = null;
		List<CarFactory> filteredfactories = new ArrayList<>();

		static CarAssembler ofCarFactory(CarFactory[] factories) {
			CarAssembler assembler = new CarAssembler();
			assembler.carfactories = factories;
			return assembler;
		}

		CarAssembler setCar(String carName) {
			this.carName = carName;
			for (int i = 0; i < carfactories.length; i++) {
				if (carfactories[i].createCar(this.carName) != null) {
					filteredfactories.add(carfactories[i]);
				}
			}

			return this;
		}

		CarAssembler createShell(ShellFactory factory) {
			for (CarFactory f : filteredfactories) {
				car = factory.createShell(f.createCar(carName));
				System.out.println("xxx " + car);
			}

			return this;
		}

		CarAssembler createWheel(WheelFactory factory) {
			for (CarFactory f : filteredfactories) {
				car = factory.createWheel(f.createCar(carName));
			}

			return this;
		}

		Car getCar() {
			return car;
		}

	}

//車子和其工廠

	static abstract class CarFactory {
		abstract Car createCar(String name);
	}

	static class SportsCarFactory extends CarFactory {
		SportsCar createCar(String name) {
			switch (name) {
			case "SportsCar1":
				return new SportsCar("SportsCarI");
			case "SportsCar2":
				return new SportsCar("SportsCarII");
			default:
				return null;
			}
		}
	}

	static class SedanCarFactory extends CarFactory {
		Sedan createCar(String name) {
			switch (name) {
			case "Sedan1":
				return new Sedan("SedanI");
			case "Sedan2":
				return new Sedan("SedanII");
			default:
				return null;
			}
		}
	}

	static class Car {
		String name;
		Shell shell;
		Wheel wheel;

		Car(String name) {
			this.name = name;
		}

		public String toString() {
			return "carClass=" + this.getClass().getName() + ",name=" + name
					+ "," + shell + "," + wheel;
		}
	}

	static class SportsCar extends Car {

		SportsCar(String name) {
			super(name);
		}

	}

	static class Sedan extends Car {

		Sedan(String name) {
			super(name);
		}

	}

//車殼和其工廠
	static class ShellFactory {
		Car createShell(Car car) {
			car.shell = new Shell("灰色烤漆");
			return car;
		};

		Car createShell(SportsCar car) {
			car.shell = new SportsCarShell("黑色烤漆");
			return car;
		};

		Car createShell(Sedan car) {
			car.shell = new SedanShell("白色烤漆");
			return car;
		};
	}

	static class Shell {
		String color;

		Shell(String color) {
			this.color = color;
		}

		public String toString() {
			return this.color;
		}
	}

	static class SportsCarShell extends Shell {

		SportsCarShell(String color) {
			super(color);
		}

	}

	static class SedanShell extends Shell {

		SedanShell(String color) {
			super(color);
		}

	}

// 輪子和其工廠
	static class WheelFactory {
		Car createWheel(Car car) {
			car.wheel = new Wheel("無說明");
			return car;
		};

		Car createWheel(SportsCar car) {
			car.wheel = new SportsCarWheel("看起來很炫的輪框");
			return car;
		};

		Car createWheel(Sedan car) {
			car.wheel = new SedanWheel("很普通的輪框");
			return car;
		};
	}

	static class Wheel {
		String wheelDisc;

		Wheel(String disc) {
			this.wheelDisc = disc;
		}

		public String toString() {
			return this.wheelDisc;
		}
	}

	static class SportsCarWheel extends Wheel {

		SportsCarWheel(String disc) {
			super(disc);
		}

	}

	static class SedanWheel extends Wheel {

		SedanWheel(String disc) {
			super(disc);
		}

	}

	public static void main(String[] args) {
		CarAssembler assembler = CarAssembler.ofCarFactory(new CarFactory[] {
				new SportsCarFactory(), new SedanCarFactory() });

		Car car1 = assembler.setCar("SportsCar1")
				.createShell(new ShellFactory()).createWheel(new WheelFactory())
				.getCar();

		System.out.println(car1);

	}

}
