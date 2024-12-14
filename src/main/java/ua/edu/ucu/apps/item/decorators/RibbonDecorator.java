package ua.edu.ucu.apps.item.decorators;

import ua.edu.ucu.apps.item.Item;

public class RibbonDecorator extends ItemDecorator {
    public RibbonDecorator(Item item) {
        super(item);
    }

    @Override
    public double price() {
        return super.price() + 40;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " + Ribbon";
    }
    
}
