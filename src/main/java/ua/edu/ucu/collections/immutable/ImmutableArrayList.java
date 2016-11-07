package ua.edu.ucu.collections.immutable;

import java.util.Arrays;


public class ImmutableArrayList implements ImmutableList {
    private final Object[] myArray;

    ImmutableArrayList(Object[] myArray) {
        this.myArray = myArray;
    }

    @Override
    public ImmutableArrayList add(Object e) {
        Object[] updatedList = new Object[myArray.length + 1];
        for (int i = 0; i < size(); i++) {
            updatedList[i] = this.myArray[i];
        }
        updatedList[size()] = e;
        return new ImmutableArrayList(updatedList);
    }

    @Override
    public ImmutableArrayList add(int index, Object e) {
        if (index > size() || index < 0) {
            throw new IndexOutOfBoundsException();
        }

        Object[] newList = new Object[size() + 1];
        for (int i = 0; i < newList.length; i++) {
            if (i < index) {
                newList[i] = myArray[i];
            } else if (index == i) {
                newList[index] = e;
            } else {
                newList[i] = myArray[i - 1];
            }
        }
        return new ImmutableArrayList(newList);
    }

    @Override
    public ImmutableArrayList addAll(Object[] c) {
        Object[] newList = new Object[myArray.length + c.length];
        for (int i = 0; i < newList.length; i++) {
            if (i < myArray.length) {
                newList[i] = myArray[i];
            } else {
                if (myArray.length < newList.length) {
                    newList[i] = c[i - myArray.length];
                }
            }
        }
        return new ImmutableArrayList(newList);
    }

    @Override
    public ImmutableArrayList addAll(int index, Object[] c) {

        if (index > size() || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        Object[] newList = new Object[myArray.length + c.length];
        for (int i = 0; i < newList.length; i++) {
            if (i < index) {
                newList[i] = myArray[i];
            } else if (i < index + c.length) {
                newList[i] = c[i - index];
            } else {
                newList[i] = myArray[i - index - c.length];
            }
        }
        return new ImmutableArrayList(newList);
    }

    @Override
    public ImmutableArrayList remove(int index) {
        if (index > size()) {
            throw new IndexOutOfBoundsException();
        }
        Object[] newList = new Object[myArray.length - 1];
        for (int i = 0; i < myArray.length - 1; i++) {
            if (i < index) {
                newList[i] = myArray[i];
            } else {
                newList[i] = myArray[i + 1];
            }
        }
        return new ImmutableArrayList(newList);
    }

    @Override
    public Object get(int index) {
        if (index < size()) {
            return myArray[index];
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public ImmutableArrayList set(int index, Object e) {
        if (index > size() || index < 0) {
            throw new IndexOutOfBoundsException();
        } else {
            myArray[index] = e;
            return new ImmutableArrayList(myArray);
        }
    }

    @Override
    public int indexOf(Object e) {
        for (int i = 0; i < size(); i++) {
            if (e == myArray[i]) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return myArray.length;
    }

    @Override
    public ImmutableArrayList clear() {
        return new ImmutableArrayList(new Object[]{null});
    }

    @Override
    public boolean isEmpty() {
        return myArray.length == 0;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(myArray, size());
    }

    public String toString() {

        String asStr = " ";
        for (Object i : myArray) {
            asStr += i + ", ";
        }
        return asStr;
    }
}