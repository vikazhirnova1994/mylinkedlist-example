import java.util.Comparator;
import java.util.LinkedList;

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

        System.out.println("List contains 30 "+ list.contains(30));

        System.out.println("Middle Node "+ list.getMiddleNode().getValue());
        list.addMiddle(11);
        print(list);
        System.out.println("Middle Node "+ list.getMiddleNode().getValue());

        list.deleteMiddle();
        print(list);
    }

    static void print(MyLinkedList<Integer> list) {
        Node current = list.getFirst();
        System.out.print("Values of list ");
        while (current.getNext() != null) {
            System.out.print(current.getValue() + " ");
            current = current.getNext();
        }
        System.out.print(current.getValue() + " ");
        System.out.println("\n-----------------");
    }

    static void printReverse(MyLinkedList<Integer> list) {
        Node current = list.getLast();
        System.out.print("Values of list ");
        while (current.getPrevious() != null) {
            System.out.print(current.getValue() + " ");
            current = current.getPrevious();
        }
        System.out.print(current.getValue() + " ");
        System.out.println("\n-----------------");
    }
}