package no.INFO233.v18.oblig1.matsh;

import java.util.Arrays;


public class ArrayDeque<E> implements IDeque<E> {


    private static final int MAX_CAPACITY = 5;
    private E[] data;
    private int size = 0;
    private int backIndex = 0;
    private int frontIndex = 0;


    public ArrayDeque() {

        this(MAX_CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public ArrayDeque(int capacity) {


        if (capacity <= 0) {
            throw new IllegalArgumentException("Not a valid capacity!");
        } else {
            data = (E[]) new Object[capacity];
        }
    }


    public boolean isEmpty() {
        return size == 0;
    }


    // Metoder arvet fra IDeque går under her

    @Override
    public int size() {
        return size;
    }

    private void copyTo(Object[] array) {
        if (frontIndex == backIndex) {
            System.arraycopy(data, frontIndex, array, 0, size);
        } else {
            int firstCopyCount = data.length - frontIndex;
            System.arraycopy(data, frontIndex, array, 0, firstCopyCount);
            System.arraycopy(data, 0, array, firstCopyCount, backIndex + 1);
        }
    }

    @SuppressWarnings("unchecked")
    private void ensureCapacity(int newSize) {

        if (data.length < newSize) {

            E[] newArray = (E[]) new Object[data.length * 2];
            copyTo(newArray);
            data = newArray;
            frontIndex = 0;
            backIndex = size - 1;

        }
    }

    @Override
    public void addFirst(E elem) throws DequeFullException {
        ensureCapacity(size() + 1);

        if (size == data.length) {

            throw new DequeFullException();

        } else if (isEmpty()) {
            data[frontIndex] = elem;

        } else {
            frontIndex = (frontIndex - 1 + data.length) % data.length;
            data[frontIndex] = elem;
        }
        size++;
    }

    @Override
    public void addLast(E elem) throws DequeFullException {

        ensureCapacity(size() + 1);

        if (size == data.length) {
            throw new DequeFullException();
        } else {
            backIndex = (backIndex + 1) % data.length;
            data[backIndex] = elem;
        }
        size++;

    }


    @Override
    public E pullFirst() throws DequeEmptyException {

        if (isEmpty()) {
            throw new DequeEmptyException();
        }
        E elementToPull = data[frontIndex];
        data[frontIndex] = null;
        frontIndex = (frontIndex + 1) % data.length;
        size--;

        return elementToPull;
    }

    @Override
    public E peekFirst() throws DequeEmptyException {
        if (isEmpty()) {
            throw new DequeEmptyException();
        }
        return data[frontIndex];
    }


    @Override
    public E pullLast() throws DequeEmptyException {

        if (isEmpty()) {
            throw new DequeEmptyException();
        }

        E toRemove = data[backIndex];
        data[backIndex] = null;
        backIndex = (backIndex - 1 + data.length) % data.length;

        size--;

        return toRemove;
    }

    @Override
    public E peekLast() throws DequeEmptyException {
        if (isEmpty()) {
            throw new DequeEmptyException();
        }
        E back = data[this.backIndex];
        return back;
    }

    @Override
    public boolean contains(Object elem) {

        boolean found = false;
        int index = 0;
        while (!found && (index < data.length)) {
            if (elem.equals(data[index])) {
                found = true;
            }
            index++;
        }
        return found;
    }

    @Override
    @SuppressWarnings("unchecked")
    public <E> E[] toArray(E[] a) {


        return (E[]) Arrays.copyOf(data, data.length, a.getClass());
    }


    @Override
    public void clear() {

        for (int i = 0; i < data.length; i++) {
            data[i] = null;
        }
        size = 0;
    }


}





