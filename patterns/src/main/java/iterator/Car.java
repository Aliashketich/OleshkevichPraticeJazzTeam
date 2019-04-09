package iterator;

import java.util.ArrayList;
import java.util.List;

class Car {

    private Body body;
    private Motor motor;
    private List<Wheel> wheels = new ArrayList<>();

    Car() {
        body = new Body();
        wheels.add(new Wheel());
        wheels.add(new Wheel());
        wheels.add(new Wheel());
        wheels.add(new Wheel());
        motor = new Motor();
    }

    Body getBody() {
        return body;
    }

    void setBody(Body body) {
        this.body = body;
    }

    boolean hasBody() {//NOSONAR
        return body != null;//NOSONAR
    }//NOSONAR

    Motor getMotor() {
        return motor;
    }


    boolean hasMotor() {//NOSONAR
        return motor != null;//NOSONAR
    }//NOSONAR

    List<Wheel> getWheels() {
        return wheels;
    }


    boolean hasWheel() {//NOSONAR
        return wheels.size() != 0;//NOSONAR
    }//NOSONAR

    interface MachinePart {
    }

    private static class Body implements MachinePart {
    }

    private static class Wheel implements MachinePart {
    }

    private static class Motor implements MachinePart {
    }
}