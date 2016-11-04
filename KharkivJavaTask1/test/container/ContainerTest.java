package container;

import entity.Product;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

public class ContainerTest {

    private Container container = new Container();
    private Product testProduct = new Product("A",5000);
    private Product testProduct2 = new Product("B",6000);
    private Product testProduct3 = new Product("C",8000);

    @Test
    public void testAdd() throws Exception{
        container.add(testProduct);
        container.add(testProduct2);
        assertTrue(container.size() == 2);
    }

    @Test
    public void testAddWithIndex() throws Exception{

        container.add(testProduct);
        container.add(testProduct3);
        container.add(1,testProduct2);
        assertTrue(container.indexOf(testProduct2) == 1);
    }

    @Test
    public void testGet() throws IndexOutOfBoundsException {
        container.add(testProduct);
        container.add(testProduct2);
        assertTrue(container.get(1).equals(testProduct2));
    }

    @Test
    public void testRemoveWithIndex() throws Exception{
        container.add(testProduct);
        container.add(testProduct2);
        container.remove(1);
        assertTrue(container.size() == 1);
    }

    @Test
    public void testRemove() throws Exception{
        container.add(testProduct);
        container.add(testProduct2);
        container.add(testProduct3);
        container.remove(testProduct3);
        assertTrue(container.size() == 2);
    }
}