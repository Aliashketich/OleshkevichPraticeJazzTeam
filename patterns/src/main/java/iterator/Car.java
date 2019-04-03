package iterator;

import java.util.ArrayList;
import java.util.List;

public class Car {

    private Body body;
    private Motor motor;
    private List<Wheel> wheels = new ArrayList<Wheel>();

    public Car() {
        body = new Body();
        wheels.add(new Wheel());
        wheels.add(new Wheel());
        wheels.add(new Wheel());
        wheels.add(new Wheel());
        motor = new Motor();
    }

    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = body;
    }

    public boolean hasBody() {
        return body != null;
    }

    public Motor getMotor() {
        return motor;
    }

    public void setMotor(Motor motor) {
        this.motor = motor;
    }

    public boolean hasMotor() {
        return motor != null;
    }

    public List<Wheel> getWheels() {
        return wheels;
    }

    public void setWheels(List<Wheel> wheels) {
        this.wheels = wheels;
    }

    public boolean hasWheel() {
        return wheels.size() != 0;
    }

    public interface MachinePart {
    }

    public static class Body implements MachinePart {
    }

    public static class Wheel implements MachinePart {
    }

    public static class Motor implements MachinePart {
    }
}