package com.codecool.datastructure;

public class SinglyLinkedList {

    private class Link {

        private int value;
        private Link next;

        Link(int value) {
            this.value = value;
        }

        int getValue() {
            return value;
        }

        Link getNext() {
            return next;
        }

        void setNext(Link next) {
            this.next = next;
        }
    }

    private Link head;


    public SinglyLinkedList() {
        this.head = null;
    }

    // Returns the number at 'index'.
    public int access(int index) {
        int indexShadow = 0;
        if (index == 0) {
            return head.getValue();
        }
        Link currentNode = head;
        Link previousNode = null;

        while(indexShadow <= index) {
            previousNode = currentNode;
            currentNode = currentNode.getNext();
            indexShadow ++;
            if (currentNode == null) {
                break;
            }

        }
        return previousNode.getValue();
    }

    // Returns the index of 'number' if it's in the array, otherwise -1;
    public int search(int number) {
        int indexShadow = 0;
        Link current_node = head;
        while (current_node.getNext() != null) {
            System.out.println(current_node.getValue());
            if(current_node.getValue() == number) {
                return indexShadow;
            }
            indexShadow++;
            current_node = current_node.getNext();
        }
        return -1;
    }

    // Inserts 'number' at 'index' into the array shifting elements if necessary.
    //
    // e.g. the result of inserting 42 at index 3 into [0, 1, 2, 3, 4] is [0, 1, 2, 42, 3, 4]
    public void insert(int index, int number) {
        int indexShadow = 0;
        Link insertMe = new Link(number);

        //if the list is empty(the head is null) the head becomes the element form the function call
        if (head == null) {
            if (index != 0) {
                return;
            } else {
                head = new Link(number);
            }
        }

        // inserting an element at the beginning when the list isn't empty
        if (head != null && index == 0) {
            insertMe.setNext(head);
            head = insertMe;
            return;
        }

        //the list is being traversed until either the end or until the insert position is less than the position at which
        //the insert is being made
        Link currentNode = head;
        Link previous = null;
        while (indexShadow < index) {
            previous = currentNode;
            currentNode = currentNode.getNext();
            if (currentNode == null) {
                break;
            }
            indexShadow++;
        }

        insertMe.setNext(currentNode);
        previous.setNext(insertMe);

    }

    // Deletes the element at 'index' from the array.
    //
    //  e.g. the result of deleting index 2 from [0, 1, 2, 3, 4] is [0, 1, 3, 4]
    public void delete(int index) {
        if (index == 0) {
            if (head == null) {
                throw new IndexOutOfBoundsException();
            } else {
                head = head.getNext();
            }
            return;
        }
        Link elementBeforeIndex = head;
        while (index - 1 > 0) {
            elementBeforeIndex = elementBeforeIndex.getNext();
            index--;
            if (elementBeforeIndex == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        Link elementAtIndex = elementBeforeIndex.getNext();
        if (elementAtIndex == null) {
            throw new IndexOutOfBoundsException();
        }
        elementBeforeIndex.setNext(elementAtIndex.getNext());
    }

    public void printThis() {
        Link current_node = head;
        while (current_node.getNext() != null) {
            System.out.println(current_node.getValue());
            current_node = current_node.getNext();
        }
    }
}
