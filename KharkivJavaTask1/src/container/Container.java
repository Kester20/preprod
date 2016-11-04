package container;

import filter.Filter;
import filter.FilterByCost;
import filter.FilterByName;


import java.util.*;

/**
 *
 * @param <T>
 */
public class Container<T> implements List {

    private int size;
    private T array [];

    public Container() {
        this.array = (T[])new Object[10];
    }

    /**
     *
     * @param size of array
     */
    public Container(int size) {
        this.array = (T[])new Object[size];
    }

    public int getSize() {
        return size;
    }

    /**
     *
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

    /**
     *
     * @return size of array
     */
    @Override
    public int size() {
        return getSize();
    }

    /**
     *
     * @return true if there are not element in array, else - false
     */
    @Override
    public boolean isEmpty() {
        if(getSize() == 0){
            return true;
        }
        return false;
    }

    /**
     *
     * @param o
     * @return true if o in array
     */
    @Override
    public boolean contains(Object o) throws ClassCastException,NullPointerException {
        for (int i = 0; i < getSize(); i++) {
            if(o.equals(getArray()[i])){
                return true;
            }
        }
        return false;
    }

    /**
     *
     * @return iterator
     */
    @Override
    public Iterator iterator() {
        return new IteratorImpl();
    }

    /**
     *
     * @param more - look for more or less than the specified criteria(true - more, false - less)
     * @param criterion look for more or less then criterion
     * @return iterator
     */
    public Iterator filterIteratorByCost(boolean more, double criterion){
        return  new FilteredIterator(new IteratorImpl(),new FilterByCost(more, criterion));
    }

    /**
     *
     * @param name of producer
     * @return iterator
     */
    public Iterator filterIteratorByName(String name){
        return  new FilteredIterator(new IteratorImpl(),new FilterByName(name));
    }

    /**
     *
     * @return array
     */
    @Override
    public Object[] toArray() {
        return this.getArray();
    }

    /**
     *
     * @param o - the added object
     * @return true
     */
    @Override
    public boolean add(Object o) throws UnsupportedOperationException, ClassCastException, NullPointerException, IllegalArgumentException{
        if(getArray().length <= getSize()){
            T[] a2 = (T[])new Object[getArray().length*2];
            System.arraycopy(getArray(), 0,a2 , 0, getSize());
            array = a2;
        }

        getArray()[size++] = o;
        return true;
    }

    /**
     *
     * @param o the removed object
     * @return true if object was removed, else - false
     */
    @Override
    public boolean remove(Object o) throws ClassCastException, NullPointerException, UnsupportedOperationException {
        for (int i = 0;i < getSize();i++){
            if(o.equals(getArray()[i])){
                for (int j = i; j < getSize(); j++) {
                    getArray()[j] = getArray()[j + 1];
                }
                size--;
                return true;
            }
        }
        return false;
    }

    /**
     *
     * @param c the added collection
     * @return true
     */
    @Override
    public boolean addAll(Collection c) throws UnsupportedOperationException, ClassCastException, NullPointerException, IllegalArgumentException {
        for (int i  = 0;i < c.size(); i ++){
            add(c.toArray()[i]);
        }
        return true;
    }

    /**
     *
     * @param index position where we add
     * @param c the added collection
     * @return
     */
    @Override
    public boolean addAll(int index, Collection c)  throws UnsupportedOperationException, ClassCastException, NullPointerException, IllegalArgumentException, IndexOutOfBoundsException {
        for (int i  = 0;i < c.size(); i ++){
            add(index++,c.toArray()[i]);
        }
        return false;
    }

    /**
     * clear the array
     */
    @Override
    public void clear() throws UnsupportedOperationException {
        this.array = (T[])new Object[0];
    }

    /**
     *
     * @param index return element
     * @return element
     */
    @Override
    public Object get(int index) throws IndexOutOfBoundsException {
        return getArray()[index];
    }

    /**
     *
     * @param index set element
     * @param element new element
     * @return true
     */
    @Override
    public Object set(int index, Object element) throws UnsupportedOperationException, ClassCastException, NullPointerException, IllegalArgumentException, IndexOutOfBoundsException {

        getArray()[index] = element;
        return true;
    }

    /**
     *
     * @param index position where we add
     * @param element added element
     */
    @Override
    public void add(int index, Object element) throws UnsupportedOperationException, ClassCastException, NullPointerException, IllegalArgumentException, IndexOutOfBoundsException {
        if(getArray().length <= getSize()){
            T[] a2 = (T[])new Object[getArray().length*2];
            System.arraycopy(getArray(), 0,a2 , 0, getSize());
            array = a2;
        }

        size++;

        for (int i = getSize() - 1;i > index;i --){
            getArray()[i] = getArray()[i - 1];
        }
        getArray()[index] = element;
    }

    /**
     *
     * @param index removed element
     * @return true
     */
    @Override
    public Object remove(int index) throws UnsupportedOperationException, IndexOutOfBoundsException {
        for (int j = index; j < getSize(); j++) {
            getArray()[j] = getArray()[j + 1];
        }
        size--;
        return true;
    }

    /**
     *
     * @param o object
     * @return index of this object in array else - -1
     */
    @Override
    public int indexOf(Object o) throws ClassCastException, NullPointerException {
        for (int i = 0;i < getSize();i ++){
            if(getArray()[i].equals(o)){
                return i;
            }
        }
        return -1;
    }

    /**
     *
     * @param o object
     * @return last index of this object in array
     */
    @Override
    public int lastIndexOf(Object o) throws ClassCastException, NullPointerException {

        //!!!!!!!!!!!!!!

        StringBuilder sb = new StringBuilder();
        for (int i = 0;i < getSize();i ++){
            if(getArray()[i].equals(o)){
                sb.append(i);
            }
        }
        sb.delete(0,sb.length() - 1);
        return Integer.parseInt(sb.toString());
    }

    @Override
    public ListIterator listIterator() {
        return null;
    }

    @Override
    public ListIterator listIterator(int index) {
        return null;
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        return null;
    }

    /**
     *
     * @param c collection
     * @return true
     */
    @Override
    public boolean retainAll(Collection c) throws UnsupportedOperationException, ClassCastException, NullPointerException {
        /*Удалить все, кроме того, что передали*/
        for (int i = 0; i < this.size(); i++) {
            if(!c.contains(this.getArray()[i])){
                this.remove(this.getArray()[i]);
            }
        }
        return true;
    }

    /**
     *
     * @param c collection
     * @return true
     */
    @Override
    public boolean removeAll(Collection c) throws UnsupportedOperationException, ClassCastException, NullPointerException {
        for (int i = 0; i < c.size(); i++) {
            for (int j = 0; j < this.size(); j++) {
                if(this.getArray()[j].equals(c.toArray()[i])){
                    remove(getArray()[j]);
                }
            }
        }
        return true;
    }

    /**
     *
     * @param c collection
     * @return true if collection is in array else - false
     */
    @Override
    public boolean containsAll(Collection c) throws ClassCastException, NullPointerException {
        int size = 0;
        for (int i = 0; i < c.size(); i++) {
            for (int j = 0; j < this.size(); j++) {
                if(this.getArray()[j].equals(c.toArray()[i])){
                    size++;
                }
            }
        }
        return size == c.size();
    }

    /**
     *
     * @param a
     * @return
     */
    @Override
    public Object[] toArray(Object[] a)  {
        return new Object[0];
    }

    /**
     *
     * @return a string representation of array
     */
    @Override
    public String toString() {
        if(getSize() == 0){
            System.out.println("Empty!");
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < getSize(); i++) {
            sb.append("[" + getArray()[i] + "]" + ", ") ;
        }
        return sb.toString();
    }

    private class IteratorImpl implements Iterator<Object> {

        private int currentPos = -1;

        /* (non-Javadoc)
         * @see java.util.Iterator#hasNext()
         */
        public boolean hasNext() {
            if(currentPos + 1 == size){
                return false;
            }
            if(currentPos < size){
                return true;
            }
            return false;
        }

        /* (non-Javadoc)
         * @see java.util.Iterator#next()
         */
        public Object next() {

            System.err.println(currentPos);
            if(currentPos >= size - 1 ){
                throw new NoSuchElementException();
            }else{
                return array[++currentPos];
            }
        }

        /* (non-Javadoc)
         * @see java.util.Iterator#remove()
         */
        public void remove() {
            for (int j = currentPos; j < size; j++) {
                array[j] = array[j + 1];
            }
            array[array.length - 1] = null;
            size--;
        }
    }

    private class FilteredIterator<T> implements Iterator<T> {
        private Iterator<? extends T> iterator;
        private Filter<T> filter;
        private T nextElement;
        private boolean hasNext;

        /**
         * Creates a new FilteredIterator using wrapping the iterator and returning only elements matching the filter.
         *
         * @param iterator
         *            the iterator to wrap
         * @param filter
         *            elements must match this filter to be returned
         */
        public FilteredIterator(Iterator<? extends T> iterator, Filter<T> filter) {
            this.iterator = iterator;
            this.filter = filter;

            nextMatch();
        }

        @Override
        public boolean hasNext() {
            return hasNext;
        }

        @Override
        public T next() {
            if (!hasNext) {
                throw new NoSuchElementException();
            }

            return nextMatch();
        }

        private T nextMatch() {
            T oldMatch = nextElement;

            while (iterator.hasNext()) {
                T o = iterator.next();

                if (filter.matches(o)) {
                    hasNext = true;
                    nextElement = o;

                    return oldMatch;
                }
            }

            hasNext = false;

            return oldMatch;
        }

        @Override
        public void remove() {
            iterator.remove();
        }
    }
}
