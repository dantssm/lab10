package ua.edu.ucu.apps;

import ua.edu.ucu.apps.decorator.MockedDocument;
import ua.edu.ucu.apps.decorator.TimedDocument;
import ua.edu.ucu.apps.item.Flower;
import ua.edu.ucu.apps.item.FlowerColor;
import ua.edu.ucu.apps.item.FlowerType;
import ua.edu.ucu.apps.item.Item;
import ua.edu.ucu.apps.item.decorators.PaperDecorator;
import ua.edu.ucu.apps.item.decorators.RibbonDecorator;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        MockedDocument mockedDocument = new MockedDocument("path");
        TimedDocument timedDocument = new TimedDocument(mockedDocument);
        System.out.println(timedDocument.parse());

        Item item = new Flower(FlowerColor.RED, 15, FlowerType.ROSE);
        System.out.println(item.getDescription() + " " + item.price());
        Item item1 = new PaperDecorator(item);
        System.out.println(item1.getDescription() + " " + item1.price());
        Item item2 = new RibbonDecorator(item1);
        System.out.println(item2.getDescription() + " " + item2.price());

    }
}