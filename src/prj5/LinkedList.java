package prj5;

import java.util.Iterator;
import java.util.NoSuchElementException;
import prj5.LinkedList.Node;

/**
 * This project uses a singly linked list
 * 
 * @author Keshav Goyal, Sharanya Pathakota, Gabriel Holder
 * 
 * @version 4/21/2022
 *
 * @param <T>
 *            is the LinkedList type i.e. its generic type
 */
public class LinkedList<T> implements Iterable<T> {
    private Node<T> head;
    private int size;

    /**
     * This is the default constructor for Singly LinkedList class,
     * setting the first node to be null and the size of the LinkedList to
     * become zero.
     */
    public LinkedList() {
        this.head = null;
        this.size = 0;
    }


    /**
     * The value of the firstNode i.e. the head is returned.
     * 
     * @return the value of the firstNode i.e. the head.
     */
    public Node<T> getFirstNode() {
        return head;
    }


    /**
     * The total number of items in the LinkedList is returned.
     * 
     * @return will return the length of the LinkedList
     */
    public int getLength() {
        return this.size;
    }


    /**
     * Adds the object to the end of the list.
     * 
     * @param obj
     *            the object to add
     * @throws IllegalArgumentException
     *             if obj is null
     */
    public void add(T obj) {
        if (obj == null) {
            throw new IllegalArgumentException();
        }
        if (isEmpty()) {
            Node<T> tempNode = new Node<T>(obj);
            head = tempNode;
            size++;
        }
        else {
            Node<T> current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            Node<T> newNode = new Node<T>(obj);
            current.setNext(newNode);
            size++;
        }
    }


    /**
     * Adds the object to the position in the list
     * 
     * @param index
     *            where to add the object
     * @param obj
     *            the object to add
     * @throws IndexOutOfBoundsException
     *             if index is less than zero or greater than size
     * @throws IllegalArgumentException
     *             if obj is null
     */
    public void add(int index, T obj) {
        if (obj == null) {
            throw new IllegalArgumentException();
        }
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            Node<T> temp = new Node<T>(obj);
            temp.setNext(head);
            head = temp;
            size++;
        }
        else {
            Node<T> current = head;
            int count = 0;
            while (current.getNext() != null) {
                if ((count + 1) == index) {
                    Node<T> tempOne = new Node<T>(obj);
                    tempOne.setNext(current.getNext());
                    current.setNext(tempOne);
                    size++;
                    break;
                }
                current = current.getNext();
                count++;
            }
        }
    }


    /**
     * Removes the object at the given position
     *
     * @param index
     *            the position of the object
     * @return value in T format if the removal was successful
     * @throws IndexOutOfBoundsException
     *             if there is not an element at the index
     */
    public T remove(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            T itemRemoved = getFirstNode().getData();
            head = head.getNext();
            size--;
            return itemRemoved;
        }
        Node<T> currentNode = head;
        int i = 0;
        while (currentNode.getNext() != null) {
            if ((i + 1) == index) {
                T removedItemTwo = currentNode.getNext().getData();
                Node<T> removeNode = currentNode.getNext().getNext();
                currentNode.setNext(removeNode);
                size--;
                return removedItemTwo;
            }
            currentNode = currentNode.getNext();
            i++;
        }
        return null;
    }


    /**
     * Removes the first instance of the given object from the list
     *
     * @param obj
     *            the object to remove
     * @return true if successful
     */
    public boolean remove(T obj) {
        if (obj == null) {
            throw new IllegalArgumentException();
        }
        if (head != null && head.getData().equals(obj)) {
            head = head.getNext();
            size--;
            return true;
        }
        Node<T> currentNode = head;
        while (size >= 2) {
            if (currentNode.getNext().getData().equals(obj)) {
                Node<T> tempNode = currentNode.getNext().getNext();
                currentNode.setNext(tempNode);
                size--;
                return true;
            }
            currentNode = currentNode.getNext();
        }
        return false;
    }


    /**
     * Removes all of the elements from the list
     */
    public void clear() {
        size = 0;
        head = null;
    }


    /**
     * This method will replace a item at specific index with the item that is
     * provided as the second parameter
     * 
     * @param index
     *            the position the item needs to be replaced item the item we
     *            wish to be replaced
     * @param obj
     *            is the value of the object that the previous value has to be
     *            replaced with
     * @throws IndexOutOfBoundsException
     *             the index is within the specific range
     *             IllegalArgumentException the object
     *             item is not set to be null.
     * @return the object or the item to be replaced
     */
    public T replace(int index, T obj) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (obj == null) {
            throw new IllegalArgumentException();
        }
        T data = null;
        if (index == 0) {
            data = getFirstNode().getData();
            head.setData(obj);
            return data;
        }
        Node<T> currentNode = head;
        int count = 0;
        while (currentNode.getNext() != null) {
            if ((count + 1) == index) {
                data = currentNode.getNext().getData();
                currentNode.getNext().setData(obj);
                break;
            }
            currentNode = currentNode.getNext();
            count++;
        }
        return data;
    }


    /**
     * This method will return the specific entry at the index provided
     * 
     * @param index
     *            the number of position to get the entry from.
     * @throws IndexOutOfBoundsException
     *             the index is out of bounds
     * @return the data at index position that is provided as parameter.
     */
    public T getEntry(int index) {
        if (head == null || index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            return getFirstNode().getData();
        }
        Node<T> currNode = head;
        int count = 0;
        T data = null;
        while (currNode.getNext() != null) {
            if ((count + 1) == index) {
                data = currNode.getNext().getData();
            }
            currNode = currNode.getNext();
            count++;
        }
        return data;
    }


    /**
     * This method will return the data of specific Node at the index provided
     * 
     * @param index
     *            the index of the specific node
     * @return the node corresponding to each index
     */
    public Node<T> getNodeAt(int index) {
        if (head == null || index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            return head;
        }
        Node<T> currentNode = head;
        int i = 0;
        while (currentNode.getNext() != null) {
            if ((i + 1) == index) {
                return currentNode.getNext();
            }
            currentNode = currentNode.getNext();
            i++;
        }
        throw new IndexOutOfBoundsException();
    }


    /**
     * Returns an array representation of the list
     *
     * @return an array representing the list
     */
    public Object[] toArray() {
        @SuppressWarnings("unchecked")
        T[] temp = (T[])new Object[size];
        int i = 0;
        Node<T> currNode = head;
        while (currNode != null) {
            temp[i] = currNode.getData();
            currNode = currNode.getNext();
            i++;
        }
        return temp;
    }


    /**
     * Checks if the list contains the given object
     *
     * @param obj
     *            the object to check for
     * @thrown IllegalArgumentException if the input onj is null.
     * @return true if it contains the object
     */
    public boolean contains(T obj) {
        if (obj == null) {
            throw new IllegalArgumentException();
        }
        Node<T> current = head;
        while (current != null) {
            if (current.getData().equals(obj)) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }


    /**
     * Checks if the array is empty
     *
     * @return true if the array is empty
     */
    public boolean isEmpty() {
        return this.size == 0;
    }


    /**
     * Returns a string representation of the list
     *
     * @return a string representing the list
     */
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append('[');
        Node<T> current = head;
        boolean noComa = true;
        while (current != null) {
            if (!noComa) {
                builder.append(", ");
            }
            else {
                noComa = false;
            }
            builder.append(current.getData());
            current = current.getNext();
        }
        builder.append(']');
        return builder.toString();
    }


    /**
     * Returns true if both lists are the same
     *
     * @param obj
     *            the LinkedList object we need to compare.
     * @return If two lists have the same contents
     */
    @SuppressWarnings("unchecked")
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() == obj.getClass()) {
            LinkedList<T> list = (LinkedList<T>)obj;
            if (this.size == list.size) {
                Node<T> currentNode = this.head;
                Node<T> tempNode = list.head;
                while (currentNode != null) {
                    if (!(currentNode.getData().equals(tempNode.getData()))) {
                        return false;
                    }
                    currentNode = currentNode.getNext();
                    tempNode = tempNode.getNext();
                }
                return true;
            }
        }
        return false;
    }


    /**
     * This method will return the list in descending order of their CFR values
     * 
     * @param begin
     *            the first index
     * @param end
     *            the last index
     * @return LinkedList will return the list of CFR values in descending order
     *         i.e. largest to smallest.
     * 
     * 
     */
    public LinkedList<Race> sortByCFR(int begin, int end) {
        CompareByCFR compareCFR = new CompareByCFR();
        LinkedList<Race> list = new LinkedList<Race>();
        Object[] cfr = toArray();
        for (int i = begin; i <= end; i++) {
            for (int j = 0; j < cfr.length - 1; j++) {
                Race cfr1 = (Race)cfr[j];
                Race cfr2 = (Race)cfr[j + 1];
                if (compareCFR.compare(cfr1, cfr2) < 0) {
                    Object temp = cfr[j];
                    cfr[j] = cfr[j + 1];
                    cfr[j + 1] = temp;
                }
            }
        }

        for (int a = 0; a < cfr.length; a++) {
            list.add((Race)cfr[a]);
        }
        return list;
    }


    /**
     * This method helps to sort the list according to the alphabetical order.
     * 
     * @param begin
     *            the first index
     * @param end
     *            the last index
     * @return LinkedList sorted in alphabetical order.
     * 
     */
    public LinkedList<Race> sortByAlpha(int begin, int end) {
        CompareByAlpha comp1 = new CompareByAlpha();
        LinkedList<Race> tempList = new LinkedList<Race>();
        Object[] alphabetArray = toArray();
        for (int i = begin; i <= end; i++) {
            for (int j = 0; j < size - 1; j++) {
                Race alphabet1 = (Race)alphabetArray[j];
                Race alphabet2 = (Race)alphabetArray[j + 1];
                if (comp1.compare(alphabet1, alphabet2) > 0) {
                    Object temp = alphabetArray[j];
                    alphabetArray[j] = alphabetArray[j + 1];
                    alphabetArray[j + 1] = temp;
                }
            }
        }
        for (int a = 0; a < alphabetArray.length; a++) {
            tempList.add((Race)alphabetArray[a]);
        }
        return tempList;

    }

    public static class Node<D> {

        private D data;
        private Node<D> next;

        /**
         * Creates a new node with the given data
         *
         * @param d
         *            the data to put inside the node
         */
        public Node(D d) {
            data = d;
        }


        /**
         * Sets the node after this node
         *
         * @param n
         *            the node after this one
         */
        public void setNext(Node<D> n) {
            next = n;
        }


        /**
         * The getNext() method returns the next node in the LinkedList.
         * 
         * @return the next node in the LinkedList
         */
        public Node<D> getNext() {
            return next;
        }


        /**
         * The setData() method is to be set the data in the node.
         * 
         * @param value
         *            the data in the node
         */
        public void setData(D value) {
            data = value;
        }


        /**
         * Gets the data in the node
         *
         * @return the data in the node
         */
        public D getData() {
            return data;
        }

    }


    private class ListIterator<A> implements Iterator<T> {

        private Node<T> next;
        private boolean calledNext;

        /**
         * Creates a new ListIterator
         */
        public ListIterator() {
            next = head;
            calledNext = false;
        }


        /**
         * Checks if there are more elements in the list
         *
         * @return true if there are more elements in the list
         */
        @Override
        public boolean hasNext() {
            return next.getNext() != null;
        }


        /**
         * Gets the next value in the list
         *
         * @return the next value
         * @throws NoSuchElementException
         *             if there are no nodes left in the list
         */
        @Override
        public T next() {
            if (next.getNext() == null) {
                throw new NoSuchElementException("No nodes left in list");
            }
            next = next.getNext();
            calledNext = true;
            T nodeData = next.getData();
            return nodeData;
        }
    }

    @Override
    public Iterator<T> iterator() {

        return null;
    }

}
