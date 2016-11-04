package wrapper;

import java.util.*;

public class LimitedAccessList<T> implements List {

    private List<T> unmodifiableList;
    private List<T> modifiableList;

    public LimitedAccessList(ArrayList<T> list1, ArrayList<T> list2) {
        this.unmodifiableList = list1;
        this.modifiableList = list2;
    }

    public List<T> getUnmodifiableList() {
        return unmodifiableList;
    }

    public List<T> getModifiableList() {
        return modifiableList;
    }

    /**
     * Indexes from unmodifiable list are similar as global indexes from List.
     * But indexes from modifiable list are not.
     * To calculate indexes from modifiable list, use this method.
     *
     * @param index - global index of the list
     * @return returns index from modifiable list
     */
    public int getIndexInModifiableList(int index) {
        return index - (size() - unmodifiableList.size());
    }

    @Override
    public int size() {
        return unmodifiableList.size() + modifiableList.size();
    }

    @Override
    public boolean isEmpty() {
        return unmodifiableList.isEmpty() && modifiableList.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        boolean contains = false;
        if (unmodifiableList.contains(o) || modifiableList.contains(o)) {
            contains = true;
        }
        return contains;
    }

    @Override
    public Iterator iterator() {
        return new IteratorImpl();
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public boolean add(Object o) {
        return modifiableList.add((T) o);
    }

    @Override
    public boolean remove(Object o) {
        return modifiableList.remove(o);
    }

    @Override
    public boolean addAll(Collection c) {
        return modifiableList.addAll(c);
    }

    @Override
    public boolean addAll(int index, Collection c) throws IllegalAccessError {
        if (index < unmodifiableList.size()) {
            throw new IllegalAccessError();
        }
        return modifiableList.addAll(getIndexInModifiableList(index),c);
    }

    @Override
    public void clear() {
        modifiableList.clear();
    }

    @Override
    public Object get(int index) {
        Object object = null;
        if (index <= unmodifiableList.size()) {
            object = unmodifiableList.get(index);
        } else {
            object = modifiableList.get(getIndexInModifiableList(index));
        }
        return object;
    }

    @Override
    public Object set(int index, Object element) throws IllegalAccessError {
        if (index < unmodifiableList.size()) {
            throw new IllegalAccessError();
        }
        modifiableList.set(getIndexInModifiableList(index), (T) element);
        return modifiableList.get(getIndexInModifiableList(index));
    }

    @Override
    public void add(int index, Object element) throws IllegalAccessError {
        if (index < unmodifiableList.size()) {
            throw new IllegalAccessError();
        }
        modifiableList.add(getIndexInModifiableList(index), (T) element);
    }

    @Override
    public Object remove(int index) throws IllegalAccessError {
        if (index < unmodifiableList.size()) {
            throw new IllegalAccessError();
        }
        return modifiableList.remove(getIndexInModifiableList(index));
    }

    @Override
    public int indexOf(Object o) {
        int index = -1;
        if (unmodifiableList.contains(o)) {
            index = unmodifiableList.indexOf(o);
        } else {
            index = unmodifiableList.size() + modifiableList.indexOf(o);
        }
        return index;
    }

    @Override
    public int lastIndexOf(Object o) {
        int index =  modifiableList.indexOf(o);
        return index != -1 ? index + unmodifiableList.size() : unmodifiableList.indexOf(o);
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
    public boolean retainAll(Collection c) {
        return modifiableList.retainAll(c);
    }

    @Override
    public boolean removeAll(Collection c) {
        return modifiableList.removeAll(c);
    }

    @Override
    public boolean containsAll(Collection c) {
        boolean containsAll = true;
        for (Object o : c) {
            if (!unmodifiableList.contains(o) && !modifiableList.contains(o)) {
                containsAll = false;
            }
        }
        return containsAll;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }

    private class IteratorImpl implements Iterator<Object> {

        private Iterator itUn = unmodifiableList.iterator();
        private Iterator itMod = modifiableList.iterator();
        private int currentPos = -1;

        public boolean hasNext() {
            currentPos++;
            return itUn.hasNext() || itMod.hasNext();
        }

        public Object next() {
            Object o;
            if (currentPos < unmodifiableList.size()) {
                o = itUn.next();
            } else {
                o = itMod.next();
            }
            return o;
        }

        public void remove() throws IllegalAccessError {
            if (currentPos < unmodifiableList.size()) {
                throw new IllegalAccessError();
            }
            itMod.remove();
        }
    }
}
