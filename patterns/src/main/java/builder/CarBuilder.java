package builder;

public class CarBuilder {
    private String mark = "Audi";
    private int speed = 220;
    private String color = "red";

    public CarBuilder buildMark(String mark) {
        this.mark = mark;
        return this;
    }

    public CarBuilder buildSpeed(int speed) {
        this.speed = speed;
        return this;
    }

    public CarBuilder buildColor(String color) {
        this.color = color;
        return this;
    }

    public Car build() {
        Car car = new Car();
        car.setMark(mark);
        car.setSpeed(speed);
        car.setColor(color);
        return car;
    }
}
