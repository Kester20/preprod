package container;

import entity.Product;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

public class IteratorImplTest {

    private Container container = new Container();
    private Product testProduct = new Product("A",5000);

    @Test
    public void testIteratorHasNext(){
        container.add(testProduct);
        Iterator<Object> it = container.iterator();
        assertTrue(it.hasNext());
    }

    @Test
    public void testIteratorHasNextWhenRemoved(){

        container.add(testProduct);
        Iterator<Object> it = container.iterator();
        container.remove(1);
        assertFalse(it.hasNext());
    }

    @Test
    public void testIteratorNext(){
        container.add(testProduct);
        Iterator<Object> it = container.iterator();
        assertTrue(it.next().equals(testProduct));
    }

    @Test
    public void testIteratorRemove(){
        container.add(testProduct);
        Iterator<Object> it = container.iterator();
        it.next();
        it.remove();
        assertTrue(container.size() == 0);
    }

}