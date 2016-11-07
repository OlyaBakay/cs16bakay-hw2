package ua.edu.ucu.collections.immutable;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

public class ImmutableArrayList implements ImmutableList {
    private final Object[] my_array;

    ImmutableArrayList(Object[] my_array) {
        this.my_array = my_array;
    }

    @Override
    public ImmutableArrayList add(Object e) {
        Object[] updated_list = new Object[my_array.length + 1];
        for (int i = 0; i < size(); i++) {
            updated_list[i] = this.my_array[i];
        }
        updated_list[size()] = e;
        return new ImmutableArrayList(updated_list);
    }

    @Override
    public ImmutableArrayList add(int index, Object e) {
        if (index > size() || index < 0) {
            throw new IndexOutOfBoundsException();
        }

        Object[] newList = new Object[size() + 1];
        for (int i = 0; i < newList.length; i++) {
            if (i < index) {
                newList[i] = my_array[i];
            } else if (index == i) {
                newList[index] = e;
            } else {
                newList[i] = my_array[i - 1];
            }
        }
        return new ImmutableArrayList(newList);
    }

    @Override
    public ImmutableArrayList addAll(Object[] c) {
        Object[] newList = new Object[my_array.length + c.length];
        for (int i = 0; i < newList.length; i++) {
            if (i < my_array.length) {
                newList[i] = my_array[i];
            } else {
                if (my_array.length < newList.length) {
                    newList[i] = c[i - my_array.length];
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
        Object[] newList = new Object[my_array.length + c.length];
        for (int i = 0; i < newList.length; i++) {
            if (i < index) {
                newList[i] = my_array[i];
            } else if (i < index + c.length) {
                newList[i] = c[i - index];
            } else {
                newList[i] = my_array[i - index - c.length];
            }
        }
        return new ImmutableArrayList(newList);
    }

    @Override
    public ImmutableArrayList remove(int index) {
        if (index > size()) {
            throw new IndexOutOfBoundsException();
        }
        Object[] newList = new Object[my_array.length - 1];
        for (int i = 0; i < my_array.length - 1; i++) {
            if (i < index) {
                newList[i] = my_array[i];
            } else {
                newList[i] = my_array[i + 1];
            }
        }
        return new ImmutableArrayList(newList);
    }

    @Override
    public Object get(int index) {
        if (index < size()) {
            return my_array[index];
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public ImmutableArrayList set(int index, Object e) {
        if (index > size() || index < 0) {
            throw new IndexOutOfBoundsException();
        } else {
            my_array[index] = e;
            return new ImmutableArrayList(my_array);
        }
    }

    @Override
    public int indexOf(Object e) {
        for (int i = 0; i < size(); i++) {
            if (e == my_array[i]) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return my_array.length;
    }

    @Override
    public ImmutableArrayList clear() {
        return new ImmutableArrayList(new Object[]{null});
    }

    @Override
    public boolean isEmpty() {
        return my_array.length == 0;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(my_array, size());
    }

    public String toString() {

        String asStr = " ";
        for (Object i : my_array) {
            asStr += i + ", ";
        }
        return asStr;
    }
}