import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Victoria Zhirnova
 * @project mylinkedlist-example
 */

public class MyLinkedListTest {
    MyLinkedList<Integer> list;

    static int value1 = 3;
    static  int value2 = 4;
    static  int value3 = 5;
    static  int value4 = 1;

    @BeforeEach
    void prepareList(){
        list = new MyLinkedList<>();
        list.addLast(value1);
        list.addLast(value2);
    }

    @Test
    void testAddLastValue() {
        list.addLast(value3);
        assertEquals(list.getLast().getValue(),  value3);
    }

    @Test
    void testAddFirstValue() {
        list.addFirst(value4);
        assertEquals(list.getFirst().getValue(),  value4);
    }


    @Test
    void testSortingList() {
      /*  MyLinkedList<Integer> myLinkedList = new  MyLinkedList<>();
        myLinkedList.addLast(4);
        myLinkedList.addLast(3);
        myLinkedList.sort();
        assertEquals(myLinkedList.getFirst().getValue(),  list.getFirst().getValue());*/
    }

    @Test
    void testSortingReverseList() {
      /*  MyLinkedList<Integer> myLinkedList = new  MyLinkedList<>();
        myLinkedList.addLast(3);
        myLinkedList.addLast(4);
        myLinkedList.reverseSort();
        assertEquals(myLinkedList.getLast().getValue(),  list.getFirst().getValue());*/
    }

    @Test
    void testDeleteLastValue(){
        list.deleteLast();
        assertEquals(list.getFirst().getValue(),  value1);
    }

    @Test
    void testDeleteFirstValue(){
        list.deleteFirst();
        assertEquals(list.getLast().getValue(),  value2);
    }

}