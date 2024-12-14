import org.junit.jupiter.api.Test;

import ua.edu.ucu.apps.item.FlowerColor;
import ua.edu.ucu.apps.item.FlowerType;
import ua.edu.ucu.apps.item.decorators.BasketDecorator;
import ua.edu.ucu.apps.item.decorators.PaperDecorator;
import ua.edu.ucu.apps.item.decorators.RibbonDecorator;
import ua.edu.ucu.apps.item.Item;
import ua.edu.ucu.apps.item.Flower;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {

    @Test
    void testFlower() {
        Item flower = new Flower(FlowerColor.RED, 15, FlowerType.ROSE);
        assertEquals("ROSE #FF0000 Flower", flower.getDescription());
        assertEquals(15, flower.price());
    }

    @Test
    void testPaperDecorator() {
        Item flower = new Flower(FlowerColor.BLUE, 20, FlowerType.TULIP);
        Item paperWrappedFlower = new PaperDecorator(flower);
        
        assertEquals("TULIP #0000FF Flower + Paper Wrap", paperWrappedFlower.getDescription());
        assertEquals(33, paperWrappedFlower.price());
    }

    @Test
    void testRibbonDecorator() {
        Item flower = new Flower(FlowerColor.RED, 25, FlowerType.CHAMOMILE);
        Item ribbonWrappedFlower = new RibbonDecorator(flower);
        
        assertEquals("CHAMOMILE #FF0000 Flower + Ribbon", ribbonWrappedFlower.getDescription());
        assertEquals(65, ribbonWrappedFlower.price());
    }

    @Test
    void testBasketDecorator() {
        Item flower = new Flower(FlowerColor.RED, 10, FlowerType.ROSE);
        Item basketWrappedFlower = new BasketDecorator(flower);
        
        assertEquals("ROSE #FF0000 Flower + Basket", basketWrappedFlower.getDescription());
        assertEquals(14, basketWrappedFlower.price());
    }

    @Test
    void testMultipleDecorators() {
        Item flower = new Flower(FlowerColor.BLUE, 30, FlowerType.TULIP);
        Item paperWrapped = new PaperDecorator(flower);
        Item ribbonWrapped = new RibbonDecorator(paperWrapped);
        Item basketWrapped = new BasketDecorator(ribbonWrapped);

        assertEquals("TULIP #0000FF Flower + Paper Wrap + Ribbon + Basket", basketWrapped.getDescription());
        assertEquals(87, basketWrapped.price());
    }
}