package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableArrayList;

public class Stack {

    ImmutableArrayList testlist;
    
    public Stack() {
        testlist = new ImmutableLinkedList();
    }
    public Object peek() {
        return testlist.get(testlist.size()-1);
    }

    public Object pop() {
        Object removed = peek();
        remove(stack.array.length - 1);
        return removed;
    }

     public void pop(Object e) {
        this.testlist = testlist.add(e);
    }

    public String toString() {
        return testlist.toString();
    }

}
