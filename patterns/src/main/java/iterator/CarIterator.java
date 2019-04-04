package iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Реализация паттерна Iterator.
 * Iterator используется для простого переббора обьектов класса, так же мы получаем методы hasNext() , remove(), next()
 * с помощью которых мы можем удобно оперировать обьектами при переборе.
 */
public class CarIterator implements Iterator<Car.MachinePart> {

    private int index = -1;
    private Car car;

    public CarIterator(Car car) {
        this.car = car;
    }

    public boolean hasNext() {
        if (index == -1) return car.hasBody() || car.hasMotor() || car.hasWheel();
        if (index == 0) return car.hasMotor() || car.hasWheel();
        return index == 1 && car.hasWheel();
    }

    public Car.MachinePart next() {
        if (index == -1) {
            if (car.hasBody()) {
                index = 0;
                return car.getBody();
            }
            if (car.hasMotor()) {
                index = 1;
                return car.getMotor();
            }
            if (car.hasWheel()) {
                index = 2;
                return car.getWheels().get(0);
            }
        }
        if (index == 0) {
            if (car.hasMotor()) {
                index = 1;
                return car.getMotor();
            }
            if (car.hasWheel()) {
                index = 2;
                return car.getWheels().get(0);
            }
        }
        if (index == 1) {
            if (car.hasWheel()) {
                index = 2;
                return car.getWheels().get(0);
            }
        }
        throw new NoSuchElementException();
    }


    public void remove() {
        if (index == -1) throw new IllegalStateException();
        if (index == 0)
            if (car.hasBody()) car.setBody(null);
            else throw new IllegalStateException();
        if (index == 1)
            if (car.hasMotor()) car.setBody(null);
            else throw new IllegalStateException();
        if (index == 2)
            if (car.hasWheel()) car.getWheels().remove(0);
            else throw new IllegalStateException();
    }
}