package ua.edu.ucu.collections.immutable;

public class ImmutableLinkedList implements ImmutableList {

    private Node head;
    private int len;


    ImmutableLinkedList(Node head){
        this.head = head;
        Node currentNode = head.getNextNode();
        while (currentNode != null){
            len++;
            currentNode = currentNode.getNextNode();
        }
    }

    ImmutableLinkedList(){
        this.head = null;
        this.len = 0;
    }

    @Override
    public ImmutableLinkedList add(Object e) {
        Node newNode;

        if (head == null) {
            newNode = head.clone();
            newNode = new Node(e);
        }
        else {
            newNode = head.clone();
            Node newCurr = newNode;

            while (newCurr.getNextNode() != null){
                newCurr = newCurr.getNextNode();
            }
            newCurr.setNextNode(new Node(e));

        }
        return new ImmutableLinkedList(newNode);
    }

    @Override
    public ImmutableLinkedList add(int index, Object e) {
        return null;
    }

    @Override
    public ImmutableLinkedList addAll(Object[] c) {
        return null;
    }

    @Override
    public ImmutableLinkedList addAll(int index, Object[] c) {
        return null;
    }

    @Override
    public Object get(int index) {
        return null;
    }

    @Override
    public ImmutableLinkedList remove(int index) {
        return null;
    }

    @Override
    public ImmutableLinkedList set(int index, Object e) {
        return null;
    }

    @Override
    public int indexOf(Object e) {
        return 0;
    }

    @Override
    public int size() {
        int len = 0;
        Node currentNode = this.head;
        while (currentNode != null){
            len++;
            currentNode = currentNode.getNextNode();
        }
        return len;
    }

    @Override
    public ImmutableLinkedList clear() {
        return new ImmutableLinkedList();
    }

    @Override
    public boolean isEmpty() {
        return head == null && size() == 0;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    public String toString(){
        String asStr = "";
        Node currentNode = this.head;
        while (currentNode != null){
            asStr += currentNode + ", ";
        }
        return asStr;
    }


}
