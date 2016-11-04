package part1;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Said_Sulaiman_Arsala on 11/1/2016.
 */
public class SetListTest {

    private List setList;
    private Collection collection;

    @Before
    public void initial() {
        setList = new SetList();
        setList.add("a");
        setList.add("b");
        setList.add("c");
        collection = new ArrayList();
        collection.add("z");
        collection.add("b");
        collection.add("y");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAdd() {
        setList.add("a");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddAll() {
        setList.addAll(collection);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSet() {
        setList.set(2, "b");
    }
}