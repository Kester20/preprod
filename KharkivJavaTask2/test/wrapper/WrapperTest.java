package wrapper;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class WrapperTest {

    private ArrayList testUnList;
    private ArrayList testModList;
    private LimitedAccessList testWrapper;

    @Before
    public void initial() {
        testUnList = new ArrayList();
        testModList = new ArrayList();
        testUnList.add("a");
        testUnList.add("b");
        testUnList.add("c");
        testModList.add("1");
        testModList.add("2");
        testModList.add("3");
        testWrapper = new LimitedAccessList(testUnList, testModList);
    }

    @Test
    public void testGet() {
        assertTrue("3".equals(testWrapper.get(5)));
    }

    @Test
    public void testContains() {
        assertTrue(testWrapper.contains("2"));
    }

    @Test
    public void testAddNotChangeUnmodifiableList() {
        testWrapper.add("4");
        assertTrue(testWrapper.getUnmodifiableList().size() == 3);
    }

    @Test
    public void testAddChangeModifiableList() {
        testWrapper.add("4");
        assertTrue(testWrapper.getModifiableList().size() == 4);
    }

    @Test
    public void testRemoveNotChangeUnmodifiableList() {
        testWrapper.remove("b");
        assertTrue(testWrapper.getUnmodifiableList().size() == 3);
    }

    @Test
    public void testRemoveChangeModifiableList() {
        testWrapper.remove("2");
        assertTrue(testWrapper.getModifiableList().size() == 2);
    }

    @Test(expected = IllegalAccessError.class)
    public void testRemoveWithIndexNotChangeUnmodifiableList() {
        testWrapper.remove(1);
    }

    @Test(expected = IllegalAccessError.class)
    public void testAddAllToUnmodifiableList() throws IllegalAccessError {
        testWrapper.addAll(1, new ArrayList());
    }

    @Test(expected = IllegalAccessError.class)
    public void testSetUnmodifiableList() {
        testWrapper.set(1, "G");
    }

    @Test
    public void testIndexOf() {
        assertTrue(testWrapper.indexOf("1") == 3);
    }

    @Test
    public void testLastIndexOf() {
        testModList.add("v");
        testUnList.add("v");
        assertEquals(testWrapper.lastIndexOf("v"), 7);
    }

    @Test
    public void testRetainAll() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("1");
        testWrapper.retainAll(arrayList);
        assertTrue(testWrapper.size() == 4);
    }

    @Test
    public void testRemoveAll() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("1");
        testWrapper.removeAll(arrayList);
        assertTrue(testWrapper.size() == 5);
    }

    @Test
    public void testContainsAll() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("1");
        arrayList.add("b");
        assertTrue(testWrapper.containsAll(arrayList));
    }

    @Test
    public void testContainsAllTwice() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("1");
        arrayList.add("b");
        arrayList.add("b");
        arrayList.add("b");
        assertTrue(testWrapper.containsAll(arrayList));
    }

    @Test
    public void testNotContainsAll(){
        ArrayList arrayList = new ArrayList();
        arrayList.add("1");
        arrayList.add("55");
        assertFalse(testWrapper.containsAll(arrayList));
    }
}