package ua.edu.ucu.apps.item.decorators;

import ua.edu.ucu.apps.item.Item;

public abstract class ItemDecorator extends Item {
    private Item item;

    public ItemDecorator(Item item) {
        this.item = item;
    }

    public double price() {
        return item.price();
    }

    public String getDescription() {
        return item.getDescription();
    }
    
}
