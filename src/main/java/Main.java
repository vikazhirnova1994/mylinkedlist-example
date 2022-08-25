/**
 * @author Victoria Zhirnova
 * @project mylinkedlist-example
 */

public class Main {
    public static void main(String[] args) {

        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.addLast(4);
        list.addLast(1);
        list.addFirst(40);
        list.addLast(12);
        list.addLast(17);

        print(list);

        list.addMiddle(11);
        print(list);

        list.deleteMiddle();
        print(list);

        list.sort();
        print(list);

        list.reverseSort();
        print(list);
    }

    static void print(MyLinkedList<Integer> list) {
        Node current = list.getFirst();
        while (current.getNext() != null) {
            System.out.print(current.getValue() + " ");
            current = current.getNext();
        }
        System.out.print(current.getValue() + " ");
        System.out.println("\n-----------------");
    }

    static void printReverse(MyLinkedList<Integer> list) {
        Node current = list.getLast();
        while (current.getPrevious() != null) {
            System.out.print(current.getValue() + " ");
            current = current.getPrevious();
        }
        System.out.print(current.getValue() + " ");
        System.out.println("\n-----------------");
    }
}
