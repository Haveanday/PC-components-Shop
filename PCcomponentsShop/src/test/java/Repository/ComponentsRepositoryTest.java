package Repository;

import Model.GraphicsCard;
import Model.Rating;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

public class ComponentsRepositoryTest {
    ComponentsRepository item;
    GraphicsCard graphicsCard;
    GraphicsCard newGraphicsCard;

    @Before //executes before every test method
    public void setUpCases() {
        item = new ComponentsRepository();
        graphicsCard = new GraphicsCard("Palit GeForce GTX1660", 299.90, 1530, 4, "PCI Express X16 3.0", Rating.HIGH);
        newGraphicsCard = new GraphicsCard("Palit GeForce GTX1660 Super GamingPro", 499.90, 1530, 6, "PCI Express X16 3.0", Rating.HIGH);
    }

    @Test //defines a method as test
    public void addGraphicsCardItem() {

        HashMap<Integer, GraphicsCard> expected = item.addGraphicsCardItem(777, graphicsCard); //method work expected

        HashMap<Integer, GraphicsCard> actual = new HashMap<Integer, GraphicsCard>();
        actual.put(777, graphicsCard);     //actual work

        Assert.assertEquals(expected, actual);  //if objects are equal - test passed
    }

    @Test
    public void getGraphicsCardHashMap() {
        HashMap<Integer, GraphicsCard> entity = item.addGraphicsCardItem(777, graphicsCard); //need to add object for check

        HashMap<Integer, GraphicsCard> expected = item.getGraphicsCardHashMap(); //method work expected

        HashMap<Integer, GraphicsCard> actual = new HashMap<>();
        actual.put(777, graphicsCard); //actual work

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void replaceGraphicsCardItem() {
        HashMap<Integer, GraphicsCard> entity = item.addGraphicsCardItem(777, graphicsCard); //need to add object for check

        HashMap<Integer, GraphicsCard> expected = item.replaceGraphicsCardItem(777, newGraphicsCard); //method work expected

        HashMap<Integer, GraphicsCard> actual = new HashMap<Integer, GraphicsCard>();
        actual.put(777, graphicsCard); //actual work
        actual.replace(777, newGraphicsCard);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void deleteGraphicsCardItem() {
        HashMap<Integer, GraphicsCard> entity = item.addGraphicsCardItem(777, graphicsCard); //need to add object for check

        HashMap<Integer, GraphicsCard> expected = item.deleteGraphicsCardItem(777);  //method work expected

        HashMap<Integer, GraphicsCard> actual = new HashMap<Integer, GraphicsCard>();
        actual.put(777, graphicsCard);  //actual work
        actual.remove(777);
        Assert.assertEquals(expected, actual);
    }
}