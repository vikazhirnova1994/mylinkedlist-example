import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Victoria Zhirnova
 * @project mylinkedlist-example
 */

public class MyLinkedListTest {

    public MyLinkedList<Person> list;
    public Person middleVika;
    public Person oldVika;
    public Person youngVika;

    @BeforeEach
    void prepareList(){
        list = new MyLinkedList<>();
        middleVika = new Person("vika", 21);
        oldVika = new Person("vika", 27);
        youngVika = new Person("vika", 15);
    }

    @Test
    void testAddLastNode() {
        list.addLast(youngVika);
        list.addLast(oldVika);
        assertEquals(list.getLast().getValue(), oldVika);
    }

    @Test
    void testAddFirstNode() {
        list.addFirst(youngVika);
        list.addFirst(oldVika);
        assertEquals(list.getFirst().getValue(), oldVika);
    }

    @Test
    void testAddMiddleNode(){
        list.addLast(youngVika);
        list.addLast(oldVika);
        list.addMiddle(middleVika);
        assertEquals(list.getMiddleNode().getValue(), middleVika);
    }


    @Test
    void testDeleteLastNode(){
        list.addFirst(youngVika);
        list.addFirst(oldVika);
        list.deleteLast();
        assertEquals(list.getFirst().getValue(), oldVika);
    }

    @Test
    void testDeleteFirstNode(){
        list.addLast(youngVika);
        list.addLast(oldVika);
        list.deleteFirst();
        assertEquals(list.getLast().getValue(), oldVika);
    }

    @Test
    void testDeleteMiddleNode(){
        list.addLast(youngVika);
        list.addLast(middleVika);
        list.addLast(oldVika);
        list.deleteMiddle();
        assertEquals(list.getLast().getValue(), oldVika);
    }



    @Test
    void testSortingLinkedList() {
        list.addLast(oldVika);
        list.addLast(youngVika);
        list.addLast(middleVika);
        list.sort(new ComparatorPerson());
        assertEquals(list.getFirst().getValue(), youngVika);
    }

    @Test
    void testSortingReverseLinkedList() {
        list.addLast(middleVika);
        list.addLast(youngVika);
        list.addLast(oldVika);
        list.reverseSort(new ComparatorPerson());
        assertEquals(list.getFirst().getValue(), oldVika);
    }

}