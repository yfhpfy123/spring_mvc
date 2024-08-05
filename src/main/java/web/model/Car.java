package web.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Car {

    public static List<Car> carList = new ArrayList<>();

    private String name;
    private int series;
    private String color;

    public Car(String name, int series, String color) {
        this.name = name;
        this.series = series;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public int getSeries() {
        return series;
    }

    public String getColor() {
        return color;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", series=" + series +
                ", color='" + color + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car car)) return false;
        return series == car.series && Objects.equals(name, car.name) && Objects.equals(color, car.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, series, color);
    }
}
