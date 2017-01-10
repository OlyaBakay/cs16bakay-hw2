package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

    public class Queue {
        ImmutableLinkedList test;

        public Queue() {
            testlist = new ImmutableLinkedList();
        }

        public Object peek() {
            return testlist.get(0);
        }

        public Object dequeue() {
            Object first = testlist.get(0);
            testlist.remove(0);
            return first;
        }

        public void enqueue(Object e) {
            testlist.add(0, e);
        }

        public String toString(){
            return testlist.toString();
        }
    }
