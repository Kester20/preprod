package filter;

import entity.Product;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Said_Sulaiman_Arsala on 10/27/2016.
 */
public class FilterByNameTest {

    @Test
    public void testCheckMethod(){
        FilterByName filterByName = new FilterByName("acer");
        Product product = new Product("acer",7000);
        assertTrue(filterByName.check(product));
    }
}