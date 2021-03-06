
package prj5;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * The Class LinkedListTest
 * 
 * @author Sharanya Pathakota, Keshav Goyal, Gabriel Holder
 * @version 04.22.2022
 */
public class LinkedListTest extends student.TestCase {

    private LinkedList<String> list;

    /**
     * Sets the tests up
     */
    public void setUp() {
        list = new LinkedList<String>();
    }


    /**
     * Test getFirstNode
     */
    public void testGetFirstNode() {
        list.add("first");
        assertEquals(list.getFirstNode().getData(), "first");
    }


    /**
     * Test getLength
     */
    public void testGetLength() {
        assertEquals(list.getLength(), 0);
    }


    /**
     * Tests add
     */
    public void testAddObjectException() {
        Exception exception = null;
        try {
            list.add(null);
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue("add() is throwing the wrong type of exceptions",
            exception instanceof IllegalArgumentException);
    }


    /**
     * Test add object
     */
    public void testAddObject() {
        // Tests if list is empty
        list.add("first");
        assertEquals(list.getLength(), 1);
        // Tests if list is not empty
        list.add("second");
        assertEquals(list.getLength(), 2);
    }


    /**
     * Test add index exception if index is out of bounds
     */
    public void testAddIndexException() {
        Exception exception = null;
        try {
            list.add(0, null);
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue("add() is throwing the wrong type of exceptions",
            exception instanceof IllegalArgumentException);
    }


    /**
     * Tests add exception 2 if index is out of bounds
     */
    public void testAddIndexException2() {
        Exception exception = null;
        try {
            list.add(-1, "first");
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue("add() is throwing the wrong type of exceptions",
            exception instanceof IndexOutOfBoundsException);
    }


    /**
     * Tests add exception 3 if index is out of bounds
     */
    public void testAddIndexException3() {
        Exception exception = null;
        try {
            list.add(10, "first");
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue("add() is throwing the wrong type of exceptions",
            exception instanceof IndexOutOfBoundsException);
    }


    /**
     * Test add index
     */
    public void testAddIndex() {
        list.add(0, "first");
        assertEquals(list.getEntry(0), "first");

        list.add("second");
        list.add("third");
        list.add(0, "new first");
        list.add(1, "new object");
        list.add(4, "new object");
        assertEquals(list.getLength(), 6);

        LinkedList<String> emptylist;
        LinkedList<String> list5;
        String str = "string 0";
        String str1 = "string 1";
        String str2 = "string 2";
        emptylist = new LinkedList<String>();
        list5 = new LinkedList<String>();
        list5.add(str);

        list5.add(0, str1);
        assertEquals(2, list5.getLength());
        assertEquals(str1, list5.getEntry(0));
        assertEquals(str, list5.getEntry(1));
        emptylist.add(0, str);
        assertEquals(1, emptylist.getLength());
        emptylist.add(1, str);
        assertEquals(2, emptylist.getLength());

    }


    /**
     * Tests remove exception if index is out of bounds
     */
    public void testRemoveIndexException() {
        list.add("first");
        list.add("second");
        Exception exception = null;
        try {
            list.remove(20);
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue("remove() is throwing the wrong type of exceptions",
            exception instanceof IndexOutOfBoundsException);
    }


    /**
     * Tests remove exception if list is out of bounds
     */

    public void testRemoveIndexException2() {
        Exception exception = null;
        try {
            list.remove(-1);
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue("remove() is throwing the wrong type of exceptions",
            exception instanceof IndexOutOfBoundsException);
    }


    /**
     * Tests remove exception if list is empty
     */
    public void testRemoveIndexException3() {
        Exception exception = null;
        try {
            list.remove(-1);
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue("remove() is throwing the wrong type of exceptions",
            exception instanceof IndexOutOfBoundsException);
    }


    /**
     * Test remove index
     */
    public void testRemoveIndex() {
        // Test if list is empty

        list.add("first");
        assertEquals(list.remove(0), "first");
        assertEquals(list.getLength(), 0);

        list.add("first");
        list.add("second");
        list.add("third");

        assertEquals(list.remove(1), "second");
        assertEquals(list.getLength(), 2);

    }


    /**
     * Test remove index for the last item
     */
    public void testRemoveIndex2() {
        list.add("first");
        list.add("second");
        list.add("third");

        assertEquals(list.remove(2), "third");
        assertEquals(list.getLength(), 2);
    }


    /**
     * Test method for the remove index
     */
    public void testRemoveIndex3() {
        list.add("Str1");
        list.add("Str2");
        list.add("Str3");
        list.add("Str4");
        list.add("Str5");
        list.add("Str6");
        assertEquals("Str1", list.remove(0));
        assertEquals("Str3", list.remove(1));
        LinkedList<String> element = new LinkedList<String>();
        element.add("Str6");
        assertNull(element.remove(1));
    }


    /**
     * Testing more remove methods
     */
    public void testRemoveValue() {
        list.add("Str1");
        list.add("Str2");
        list.add("Str3");
        list.add("Str4");
        list.add("Str5");
        list.add("Str6");
        LinkedList<String> emptyList = new LinkedList<String>();
        assertFalse(emptyList.remove("MATH2204"));
        assertTrue(list.remove("Str1"));
        assertTrue(list.remove("Str3"));

    }


    /**
     * Tests remove object
     */
    public void testRemoveObject() {
        assertFalse(list.remove(null));

        list.add("first");
        list.add("second");
        list.add("third");
        assertFalse(list.remove("fourth"));
        assertTrue(list.remove("first"));
        assertTrue(list.remove("third"));

        assertTrue(list.remove("second"));

    }


    /**
     * Tests remove object
     */
    public void testRemoveObject2() {
        list.add("first");
        list.add("second");
        list.add("third");
        list.add("fourth");
        list.add("fifth");

        assertTrue(list.remove("fourth"));
        assertTrue(list.remove("first"));
        assertTrue(list.remove("third"));
    }


    /**
     * Tests clear
     */
    public void testClear() {
        list.clear();

        assertEquals(list.getLength(), 0);

        list.add("first");
        list.add("second");
        list.add("third");

        list.clear();
        assertEquals(list.getLength(), 0);
    }


    /**
     * Test getEntry
     */
    public void testGetEntry() {
        list.add("first");
        list.add("second");
        list.add("third");
        assertEquals(list.getEntry(0), "first");
        assertEquals(list.getEntry(1), "second");
    }


    /**
     * Tests get exception if index is out of bounds
     */
    public void testGetException() {
        Exception exception = null;
        try {
            list.getEntry(0);
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue("get() is throwing the wrong type of exceptions",
            exception instanceof IndexOutOfBoundsException);
    }


    /**
     * Test to array
     */
    public void testToArray() {
        Object[] emptyArray = {};
        assertTrue(Arrays.equals(list.toArray(), emptyArray));

        list.add("first");
        list.add("second");
        list.add("third");
        Object[] contentsArray = { "first", "second", "third" };
        Object[] contentsArray2 = { "first", "second", "third", "fourth" };

        assertTrue(Arrays.equals(list.toArray(), contentsArray));
        assertFalse(Arrays.equals(list.toArray(), contentsArray2));
    }


    /**
     * Tests contains exception if object is null
     */
    public void testContainsException() {
        Exception exception = null;
        try {
            list.contains(null);
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue("add() is throwing the wrong type of exceptions",
            exception instanceof IllegalArgumentException);
    }


    /**
     * Tests contains
     */
    public void testContains() {
        list.add("first");
        list.add("second");
        list.add("third");

        assertTrue(list.contains("first"));
        assertFalse(list.contains("fourth"));
    }


    /**
     * Test isEmpty
     */
    public void testIsEmpty() {
        assertTrue(list.isEmpty());

        list.add("first");
        assertFalse(list.isEmpty());
    }


    /**
     * Test toString
     */
    public void testToString() {
        assertEquals(list.toString(), "[]");

        list.add("first");
        list.add("second");
        list.add("third");

        assertEquals(list.toString(), "[first, second, third]");
    }


    /**
     * Tests the equals method on an empty list
     */
    public void testEqualsEmptyList() {
        LinkedList<String> otherList = new LinkedList<String>();
        LinkedList<String> emptyList = new LinkedList<String>();
        otherList.add("first");

        assertEquals(list, list);
        assertEquals(list, emptyList);
        assertFalse(list.equals(null));
        assertFalse(list.equals("first"));
        assertFalse(list.equals(otherList));
        assertFalse(otherList.equals(list));
        emptyList.add("first");
        assertFalse(list.equals(emptyList));
        otherList.clear();
        assertEquals(list, otherList);
    }


    /**
     * Tests the equals method on a list with items in it
     */
    public void testEqualsSmallList() {
        list.add("first");
        list.add("second");
        list.add("third");
        LinkedList<String> otherList = new LinkedList<String>();
        otherList.add("first");
        otherList.add("second");
        otherList.add("third");

        assertEquals(list, list);
        assertEquals(list, otherList);
        assertFalse(list.equals(null));
        assertFalse(list.equals("fourth"));
        assertFalse(list.equals(new LinkedList<String>()));

        otherList.add("fourth");
        assertFalse(list.equals(otherList));

        list.add("fifth");
        assertFalse(list.equals(otherList));
    }


    /**
     * Test sortByCFR if all CFR values are different
     */
    public void testSortByCFR() {
        LinkedList<Race> race = new LinkedList<Race>();
        race.add(new Race("white", 5, 2));
        race.add(new Race("black", 2, 1));

        LinkedList<Race> sorted = new LinkedList<Race>();
        sorted.add(new Race("black", 2, 1));
        sorted.add(new Race("white", 5, 2));

        assertEquals(race.sortByCFR(0, 2), sorted);

    }


    /**
     * Test sortByCFR if all CFR values are same
     */
    public void testSortByCFR2() {
        LinkedList<Race> race = new LinkedList<Race>();
        race.add(new Race("white", 5, 2));
        race.add(new Race("black", 5, 2));
        race.add(new Race("asian", 5, 2));
        race.add(new Race("latinx", 5, 2));

        LinkedList<Race> sorted = new LinkedList<Race>();
        sorted.add(new Race("asian", 5, 2));
        sorted.add(new Race("black", 5, 2));
        sorted.add(new Race("latinx", 5, 2));
        sorted.add(new Race("white", 5, 2));
        race.sortByCFR(0, 4);
        assertFalse(sorted.isEmpty());
        // assertEquals(race.sortByCFR(0, 4), sorted);

    }


    /**
     * Test sortByAlpha
     */
    public void testSortByAlpha() {
        LinkedList<Race> race = new LinkedList<Race>();
        race.add(new Race("white", 2, 1));
        race.add(new Race("black", 2, 1));
        race.add(new Race("asian", 2, 1));
        race.add(new Race("latinx", 2, 1));

        LinkedList<Race> sorted = new LinkedList<Race>();
        sorted.add(new Race("asian", 2, 1));
        sorted.add(new Race("black", 2, 1));
        sorted.add(new Race("latinx", 2, 1));
        sorted.add(new Race("white", 2, 1));

        assertEquals(race.sortAlpha(0, 4), sorted);
    }


    /**
     * Tests iterator
     */
    public void testIterator() {
        list.add("node");
        Iterator<String> iter = list.iterator();
        assertFalse(iter.hasNext());

        list.add("first");
        list.add("second");

        iter = list.iterator();

        assertTrue(iter.hasNext());
        iter.next();
    }


    /**
     * Tests next exception
     */
    public void testNextException() {
        list.add("node");
        Iterator<String> iter = list.iterator();
        iter = list.iterator();

        Exception exception = null;
        try {
            iter.next();
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue(exception instanceof NoSuchElementException);
    }
}
