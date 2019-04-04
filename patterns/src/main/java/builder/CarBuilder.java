package builder;

class CarBuilder {
    private String mark = "Audi";
    private int speed = 220;
    private String color = "red";

    CarBuilder buildMark(String mark) {
        this.mark = mark;
        return this;
    }

    CarBuilder buildSpeed(int speed) {
        this.speed = speed;
        return this;
    }

    CarBuilder buildColor(String color) {
        this.color = color;
        return this;
    }

    Car build() {
        Car car = new Car();
        car.setMark(mark);
        car.setSpeed(speed);
        car.setColor(color);
        return car;
    }
}
