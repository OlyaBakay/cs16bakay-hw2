package ua.edu.ucu.collections.immutable;

import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

public class ImmutableArrayListTest {
    private Object[] test_list1 = {"oop", 11, "meow", 1.1, 5};
    private ImmutableArrayList test_list = new ImmutableArrayList(test_list1);

    @Test
    public void testAddToEmptyList(){
        ImmutableArrayList emptyList = new ImmutableArrayList(new Object[]{});
        emptyList = emptyList.add("rrr");

        String expected = " rrr, ";
        assertEquals(expected, emptyList.toString());
    }

    @Test
    public void testAddEl(){
        String expected = " oop, 11, meow, 1.1, 5, blablabla, ";
        test_list = test_list.add("blablabla");
        assertEquals(expected, test_list.toString());
    }

    @Test
    public void testAddElByInd(){
        String expected = " oop, NoNo, 11, meow, 1.1, 5, ";
        test_list = test_list.add(1, "NoNo");
        assertEquals(expected, test_list.toString());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddWrongInd(){
       test_list = test_list.add(100500, "rar");
    }

    @Test
    public void testAddAllEmptyList(){
        String expected = " ";
        Object[] arr_1 = {};
        ImmutableList newList = new ImmutableArrayList(arr_1);
        newList = newList.addAll(arr_1);
        assertEquals(expected, newList.toString());
    }

    @Test
    public void testAddAllInd(){
        String expected = " oop, ede, 10, 14, oop, 11, meow, 1.1, ";
        Object[] arr_1 = {"ede", 10, 14};
        test_list = test_list.addAll(1, arr_1);
        assertEquals(expected, test_list.toString());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddAllIndWrong(){
        Object[] arr_2 = {"algo", 1050, 11};
        test_list = test_list.addAll(10, arr_2);
    }


    @Test
    public void testGet(){
        String expected = "oop";
        assertEquals(expected, test_list.get(0).toString());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetWrongInd(){
        test_list.get(1050);
    }

    @Test
    public void testRemove(){
        String expected = " oop, 11, meow, 1.1, ";
        assertEquals(expected, test_list.remove(4).toString());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveWrongInd(){
        test_list.remove(10);
    }

    @Test
    public void testSet() {
        String expected = " ooo, 11, meow, 1.1, 5, ";
        test_list = test_list.set(0, "ooo");
        assertEquals(expected, test_list.toString());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSetWrongInd(){
        test_list = test_list.set(-10, "Olya");
    }

    @Test
    public void testIndexOfOk() {
        int expected = 2;
        assertEquals(expected, test_list.indexOf("meow"));
    }

    @Test
    public void testIndexOfFal(){
        int expected = -1;
        assertEquals(expected, test_list.indexOf("ferf"));
    }

    @Test
    public void testSize(){
        int expected = 5;
        assertEquals(expected, test_list.size());
    }

    @Test
    public void testIsEmpty(){
        boolean expected = false;
        assertEquals(expected, test_list.isEmpty());
    }

    @Test
    public void testClear(){
        String expected = " null, ";
        assertEquals(expected, test_list.clear().toString());
    }

    @Test
    public void testToArray(){
        Object[] expected = test_list1;
        Assert.assertArrayEquals(expected, test_list.toArray());
    }
}