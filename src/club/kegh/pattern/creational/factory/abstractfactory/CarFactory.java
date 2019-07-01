package club.kegh.pattern.creational.factory.abstractfactory;

public interface CarFactory {
	Engine createEngine();
	Seat createSeat();
	Tyre createTyre();
}
