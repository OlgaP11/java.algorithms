package homework3;

public class SingleLinkedList {
    Node head;

    /**
     * @apiNote Разворот односвязного списка
     */
    public void revert(){
        if (head != null && head.next != null){
            revert(head.next, head);
        }

    }

    private void revert(Node currentNode, Node previousNode){
        if (currentNode.next == null){
            head = currentNode;
        } else{
            revert(currentNode.next, currentNode);
        }
        currentNode.next = previousNode;
        previousNode.next = null;
    }

    /**
     * @apiNote Метод, выводящий n-е число с конца односвязного списка,
     * предварительно не узнавая его размер. Данный методы разворачивает список,
     * а затем выводит то количество элементы, которое задал пользователь.
     * @param numberOfElems - число элементов, которое надо вывести
     */
    public void elementsFromEnd (int numberOfElems){
        if (head != null && head.next != null){
            revert(head.next, head);
        }

        Node currentNode = head;

        while (numberOfElems > 0 && currentNode != null){
            System.out.printf("%d ", currentNode.value);
            currentNode = currentNode.next;
            numberOfElems -= 1;
        }
        System.out.printf("\n");
    }



    public void addFirst(int value){
        Node newNode = new Node();
        newNode.value = value;
        if (head == null){
            head = newNode;
        } else{
            newNode.next = head;
            head = newNode;
        }
    }

    public void addLast (int value){
        Node newNode = new Node();
        newNode.value = value;

        if (head == null){
            head = newNode;
        } else {
            Node currentNode = head;

            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }

            currentNode.next = newNode;
        }
    }

    public void removeLast (){
        if (head != null) {
            if (head.next == null){
                head = null;
            } else {
                Node currNode = head;
                while (currNode.next != null) {
                    if (currNode.next.next == null) {
                        currNode.next = null;
                        return;
                    }
                    currNode = currNode.next;
                }
            }
        }

    }

    public void removeFirst (){
        if (head != null)
            head = head.next;
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
    }
}
