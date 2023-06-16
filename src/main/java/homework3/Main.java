package homework3;

public class Main {
    public static void main(String[] args) {
        DoubleLinkedList list1 = new DoubleLinkedList();
        list1.addLast(1);
        list1.addLast(2);
        list1.addLast(3);
        list1.addLast(4);
        list1.addLast(5);

        list1.revert();
        System.out.println("Разворот двусвязного списка: ");
        list1.print();

        SingleLinkedList list2 = new SingleLinkedList();
        list2 .addLast(6);
        list2.addLast(7);
        list2.addLast(8);
        list2.addLast(9);
        list2.addLast(0);

        list2.revert();
        System.out.println("Разворот односвязного списка: ");
        list2.print();

        System.out.println("Вывод трех элементов с конца списка: ");
        list2.elementsFromEnd(3);

    }
}
