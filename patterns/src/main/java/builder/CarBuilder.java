package builder;

class CarBuilder {
    private String mark = "Mercedes";
    private String color = "Black";
    private double cost = 220000;

    CarBuilder selectMark(String mark) {
        this.mark = mark;
        return this;
    }

    CarBuilder selectCost(double cost) {
        this.cost = cost;
        return this;
    }

    CarBuilder selectColor(String color) {
        this.color = color;
        return this;
    }

    Car constructCar() {
        Car car = new Car();
        car.setMark(mark);
        car.setCost(cost);
        car.setColor(color);
        return car;
    }
}
