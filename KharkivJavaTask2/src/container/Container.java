package container;

import java.lang.ref.WeakReference;
import java.util.*;

public class Container<T> implements List {

    private int size;
    private T array[];
    private List<WeakReference<IteratorImpl>> iterators = new ArrayList<WeakReference<IteratorImpl>>();
    private static final int DEFAULT_SIZE = 10;

    public Container() {
        this.array = (T[]) new Object[DEFAULT_SIZE];
    }

    /**
     * @param size of array
     */
    public Container(int size) {
        this.array = (T[]) new Object[size];
    }

    public void changeNotification() {
        Iterator iterator = iterators.iterator();
        while (iterator.hasNext()) {
            IteratorImpl it = (IteratorImpl) iterator.next();
            it.changeDetected(array, size);
            iterator.remove();
        }
    }

    public int getSize() {
        return size;
    }

    /**
     * @param size of array
     */
    public void setSize(int size) {
        this.size = size;
    }

    public Object[] getArray() {
        return array;
    }

    public void setArray(T[] array) {
        this.array = array;
    }

    @Override
    public int size() {
        return getSize();
    }

    @Override
    public boolean isEmpty() {
        if (getSize() == 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean contains(Object o) throws ClassCastException, NullPointerException {
        for (int i = 0; i < getSize(); i++) {
            if (o.equals(getArray()[i])) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator iterator() {
        Iterator iterator = new IteratorImpl();
        WeakReference<IteratorImpl> weakIterator = new WeakReference<IteratorImpl>((IteratorImpl) iterator);
        this.iterators.add(weakIterator);
        return (Iterator) weakIterator;
    }

    @Override
    public Object[] toArray() {
        return this.getArray();
    }

    @Override
    public boolean add(Object o) throws UnsupportedOperationException, ClassCastException, NullPointerException, IllegalArgumentException {
        if (getArray().length <= getSize()) {
            T[] a2 = (T[]) new Object[getArray().length * 2];
            System.arraycopy(getArray(), 0, a2, 0, getSize());
            array = a2;
        }
        changeNotification();
        getArray()[size++] = o;
        return true;
    }

    @Override
    public boolean remove(Object o) throws ClassCastException, NullPointerException, UnsupportedOperationException {
        for (int i = 0; i < getSize(); i++) {
            if (o.equals(getArray()[i])) {

                changeNotification();

                for (int j = i; j < getSize(); j++) {
                    getArray()[j] = getArray()[j + 1];
                }
                size--;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean addAll(Collection c) throws UnsupportedOperationException, ClassCastException, NullPointerException, IllegalArgumentException {
        changeNotification();
        for (int i = 0; i < c.size(); i++) {
            add(c.toArray()[i]);
        }
        return true;
    }

    @Override
    public boolean addAll(int index, Collection c) throws UnsupportedOperationException, ClassCastException, NullPointerException, IllegalArgumentException, IndexOutOfBoundsException {
        changeNotification();
        for (int i = 0; i < c.size(); i++) {
            add(index++, c.toArray()[i]);
        }
        return false;
    }

    @Override
    public void clear() throws UnsupportedOperationException {
        changeNotification();
        this.array = (T[]) new Object[0];
    }

    @Override
    public Object get(int index) throws IndexOutOfBoundsException {
        return getArray()[index];
    }

    @Override
    public Object set(int index, Object element) throws UnsupportedOperationException, ClassCastException, NullPointerException, IllegalArgumentException, IndexOutOfBoundsException {
        changeNotification();
        getArray()[index] = element;
        return true;
    }

    @Override
    public void add(int index, Object element) throws UnsupportedOperationException, ClassCastException, NullPointerException, IllegalArgumentException, IndexOutOfBoundsException {
        if (getArray().length <= getSize()) {
            T[] a2 = (T[]) new Object[getArray().length * 2];
            System.arraycopy(getArray(), 0, a2, 0, getSize());
            array = a2;
        }
        changeNotification();
        size++;

        for (int i = getSize() - 1; i > index; i--) {
            getArray()[i] = getArray()[i - 1];
        }
        getArray()[index] = element;
    }

    @Override
    public Object remove(int index) throws UnsupportedOperationException, IndexOutOfBoundsException {
        changeNotification();
        for (int j = index; j < getSize(); j++) {
            getArray()[j] = getArray()[j + 1];
        }
        size--;
        return true;
    }

    @Override
    public int indexOf(Object o) throws ClassCastException, NullPointerException {
        for (int i = 0; i < getSize(); i++) {
            if (getArray()[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) throws ClassCastException, NullPointerException {
        int index = -1;
        for (int i = 0; i < getSize(); i++) {
            if (getArray()[i].equals(o)) {
                index = i;
            }
        }
        return index;
    }

    /**
     * This method throws a UnsupportedOperationException
     */
    @Override
    public ListIterator listIterator() {
        throw new UnsupportedOperationException();
    }

    /**
     * This method throws a UnsupportedOperationException
     */
    @Override
    public ListIterator listIterator(int index) {
        throw new UnsupportedOperationException();
    }

    /**
     * This method throws a UnsupportedOperationException
     */
    @Override
    public List subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean retainAll(Collection c) throws UnsupportedOperationException, ClassCastException, NullPointerException {
        changeNotification();
        for (int i = 0; i < this.size(); i++) {
            if (!c.contains(this.getArray()[i])) {
                this.remove(this.getArray()[i]);
            }
        }
        return true;
    }

    @Override
    public boolean removeAll(Collection c) throws UnsupportedOperationException, ClassCastException, NullPointerException {
        changeNotification();
        for (int i = 0; i < c.size(); i++) {
            for (int j = 0; j < this.size(); j++) {
                if (this.getArray()[j].equals(c.toArray()[i])) {
                    remove(getArray()[j]);
                }
            }
        }
        return true;
    }

    @Override
    public boolean containsAll(Collection c) throws ClassCastException, NullPointerException {
        int size = 0;
        for (int i = 0; i < c.size(); i++) {
            for (int j = 0; j < this.size(); j++) {
                if (this.getArray()[j].equals(c.toArray()[i])) {
                    size++;
                }
            }
        }
        return size == c.size();
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }

    @Override
    public String toString() {
        if (getSize() == 0) {
            System.out.println("Empty!");
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < getSize(); i++) {
            sb.append("[" + getArray()[i] + "]" + ", ");
        }
        return sb.toString();
    }

    private class IteratorImpl implements Iterator<Object> {

        private int currentPos = -1;
        private boolean changeDetected;
        private T[] oldArray;
        private int oldSize;

        public IteratorImpl() {
        }

        /**
         * @param array - old array
         * @param size  - old size
         *              f the change is more than one, array is no longer copied
         */
        public void changeDetected(T array[], int size) {
            changeDetected = true;
            this.oldArray = array.clone();
            this.oldSize = size;
        }

        @Override
        public boolean hasNext() {
            if (changeDetected) {
                if (currentPos + 1 == oldSize) {
                    return false;
                }
                if (currentPos < oldSize) {
                    return true;
                }
            } else {
                if (currentPos + 1 == size) {
                    return false;
                }
                if (currentPos < size) {
                    return true;
                }
            }
            return false;
        }

        @Override
        public Object next() {
            if (changeDetected) {
                if (currentPos >= oldSize - 1) {
                    throw new NoSuchElementException();
                } else {
                    return oldArray[++currentPos];
                }
            } else {
                if (currentPos >= size - 1) {
                    throw new NoSuchElementException();
                } else {
                    return array[++currentPos];
                }
            }
        }

        @Override
        public void remove() {
            for (int j = currentPos; j < size; j++) {
                array[j] = array[j + 1];
            }
            array[array.length - 1] = null;
            size--;
        }
    }
}