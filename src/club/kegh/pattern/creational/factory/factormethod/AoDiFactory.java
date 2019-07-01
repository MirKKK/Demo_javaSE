package club.kegh.pattern.creational.factory.factormethod;

import club.kegh.pattern.creational.factory.factormethod.AoDi;
import club.kegh.pattern.creational.factory.factormethod.Car;

public class AoDiFactory implements CarFactory{

	public Car createCar() {
		return new AoDi();
	}
	
}
