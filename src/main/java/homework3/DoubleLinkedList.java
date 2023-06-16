package homework3;

public class DoubleLinkedList {
    Node head;
    Node tail;

    /**
     * @apiNote Разворот двусвязного списка
     */
    public void revert() {
        Node currentNode = head;

        while (currentNode != null){
            Node temp = currentNode.next;
            currentNode.next= currentNode.previous;
            currentNode.previous = temp;

            if (currentNode.previous == null){
                head = currentNode;
            }

            if (currentNode.next == null){
                tail = currentNode;
            }

            currentNode = currentNode.previous;
        }
    }

    public void addFirst(int value){
        Node newNode = new Node();
        newNode.value = value;

        if (head == null){
            head = newNode;
            tail = newNode;
        } else{
            newNode.next = head;
            head.previous = newNode;
            head = newNode;
        }
    }

    public void addLast (int value){
        Node newNode = new Node();
        newNode.value = value;

        if (head == null && tail == null){
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;
        }
    }

    public void removeLast (){
        if (tail != null && tail.previous != null) {
            tail.previous.next = null;
            tail = null;
        } else if (head.next == null){
            head = null;
            tail = null;
        }
    }

    public void removeFirst (){
        if (head.next != null && head != null) {
            head = head.next;
            head.previous = null;
        } else {
            head = null;
            tail = null;
        }
    }

    public boolean contains (int value){
        Node currentNode = head;
        while (currentNode != null){
            if (currentNode.value == value){
                return true;
            }
            currentNode = currentNode.next;
        }
        return false;
    }

    public void print (){
        Node currNode = head;
        while (currNode != null){
            System.out.printf("%d ", currNode.value);
            currNode = currNode.next;
        }
        System.out.printf("\n");

    }

    public class Node{
        int value;
        Node next;
        Node previous;
    }
}
