package part1;

import java.util.ArrayList;
import java.util.Collection;


/**
 * Created by Said_Sulaiman_Arsala on 11/1/2016.
 */
public class SetList extends ArrayList {

    /**
     * Throws exception if the element is in list
     *
     * @param element
     */
    private void checkNotExistElement(Object element) {
        if (super.contains(element)) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public Object set(int index, Object element) {
        checkNotExistElement(element);
        return super.set(index, element);
    }

    @Override
    public boolean add(Object o) {
        checkNotExistElement(o);
        return super.add(o);
    }

    @Override
    public void add(int index, Object element) {
        checkNotExistElement(element);
        super.add(index, element);
    }

    /**
     * If at least one item in the list then exception
     *
     * @param c
     * @return
     */
    @Override
    public boolean addAll(Collection c) {
        for (Object collection : c) {
            checkNotExistElement(collection);
        }
        return super.addAll(c);
    }

    /**
     * If at least one item in the list then exception
     *
     * @param index
     * @param c
     * @return
     */
    @Override
    public boolean addAll(int index, Collection c) {
        for (Object collection : c) {
            checkNotExistElement(collection);
        }
        return super.addAll(index, c);
    }
}
