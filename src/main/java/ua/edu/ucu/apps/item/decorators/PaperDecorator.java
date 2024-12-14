package ua.edu.ucu.apps.item.decorators;

import ua.edu.ucu.apps.item.Item;

public class PaperDecorator extends ItemDecorator {
    public PaperDecorator(Item item) {
        super(item);
    }

    @Override
    public double price() {
        return super.price() + 13;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " + Paper Wrap";
    }
    
}
