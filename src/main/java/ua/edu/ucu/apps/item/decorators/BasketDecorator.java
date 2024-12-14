package ua.edu.ucu.apps.item.decorators;

import ua.edu.ucu.apps.item.Item;

public class BasketDecorator extends ItemDecorator {
    private Item item;

    public BasketDecorator(Item item) {
        super(item);
        this.item = item;
    }

    @Override
    public double price() {
        return item.price() + 4;
    }

    @Override
    public String getDescription() {
        return item.getDescription() + " + Basket";
    }
    
}
