package filter;

import entity.Product;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Said_Sulaiman_Arsala on 10/27/2016.
 */
public class FilterByCostTest {

    @Test
    public void testCheckMethod(){
        FilterByCost filterByCost = new FilterByCost(true,5000);
        Product product = new Product("A",7000);
        assertTrue(filterByCost.check(product));
    }
}