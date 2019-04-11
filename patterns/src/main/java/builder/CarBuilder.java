package builder;

public class CarBuilder {
    private String mark = "Mercedes";
    private String color = "Black";
    private double cost = 220000;

    public CarBuilder selectMark(String mark) {
        this.mark = mark;
        return this;
    }

    public CarBuilder selectCost(double cost) {
        this.cost = cost;
        return this;
    }

    public CarBuilder selectColor(String color) {
        this.color = color;
        return this;
    }

    public Car constructCar() {
        Car car = new Car();
        car.setMark(mark);
        car.setCost(cost);
        car.setColor(color);
        return car;
    }

}
