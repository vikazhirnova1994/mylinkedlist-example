import java.util.Comparator;
import java.util.LinkedList;

/**
 * @author Victoria Zhirnova
 * @project mylinkedlist-example
 */

public class Main {
    public static void main(String[] args) {

        MyLinkedList<Person> list = new MyLinkedList<>();

        Person middleVika = new Person("vika", 21);
        Person oldVika = new Person("vika", 27);
        Person youngVika = new Person("vika", 15);

        list.addLast(middleVika);
        list.addLast(youngVika);
        list.addLast(oldVika);
        list.print();

        list.sort(new ComparatorPerson());
        list.print();

        list.reverseSort(new ComparatorPerson());
        list.print();
    }

}