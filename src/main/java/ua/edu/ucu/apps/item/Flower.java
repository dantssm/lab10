package ua.edu.ucu.apps.item;

import lombok.Getter;
import lombok.Setter;

@Setter
public class Flower extends Item {
    private FlowerColor color;
    private double price;
    @Getter
    private FlowerType flowerType;

    public Flower(FlowerColor color, double price, FlowerType flowerType) {
        this.color = color;
        this.price = price;
        this.flowerType = flowerType;
    }

    public String getColor() {
        return color.toString();
    }

    @Override
    public double price() {
        return price;
    }

    @Override
    public String getDescription() {
        return flowerType.toString() + " " + color.toString() + " Flower";
    }
}
