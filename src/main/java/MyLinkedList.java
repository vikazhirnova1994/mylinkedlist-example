import java.util.NoSuchElementException;

/**
 * @author Victoria Zhirnova
 * @project mylinkedlist-example
 *
 * Кастомный односвязный список со свойствами <b>first</b> и <b>last</b>
 */

public class MyLinkedList <T extends Comparable<T>> implements MyList {

    /** первый элеменет списка */
    private Node<T> first;

    /** последений элеменет списка */
    private Node<T> last;

    /**
     * добавление элемента в конец списка
     * новый элемент назначается последним
     * next старого последнего элемента назначается новый элемнет
     * previous нового элемента назначается старому последнему элемнета
     *
     *  @param  value добавляемый элемент
     *
     *  */
    @Override
    public void addLast(Comparable value) {
        Node newLink = new Node(value);
        Node oldLast = last;
        if (isEmpty()) {
            first = newLink;
            last = newLink;
        } else {
            oldLast.setNext(newLink);
            last = newLink;
            last.setPrevious(oldLast);
        }
    }

    /**
     * добавление элемента в конец начало списка
     * назначается новый элемент  первым
     * next нового элемента назначается старый первый элемнет
     * previous старого первого элемнета назначается новый элемент
     *
     *  @param  value добавляемый элемент
     *  */
    @Override
    public void addFirst(Comparable value) {
        Node newLink = new Node(value);
        Node oldFirst = first;
        if (isEmpty()) {
            first = newLink;
            last = newLink;
        } else {
            newLink.setNext(oldFirst);
            oldFirst.setPrevious(newLink);
            first = newLink;
        }
    }

    /**
     * добавление элемента в середину списка
     * получение элемента из середине списка middleNode
     * next элемнета перед middleNode назначается новый элемент
     *  next нового элемнета назначается middleNode
     *  previous нового элемнета   назначается middleNode
     *  previous middleNode  назначается новый элемента
     *
     *  @param  value добавляемое значение элемента
     *  @throws   NullPointerException выбрасываемая ошибка в ситуации, когда список пуст
     *  */
    @Override
    public void addMiddle(Comparable value) {
        if (!isEmpty()) {
            Node<T> middleNode = getMiddleNode();
            Node<T> previous = middleNode.getPrevious();
            Node<T> newLink = new Node(value);

            previous.setNext(newLink);
            newLink.setNext(middleNode);
            newLink.setPrevious(previous);
            middleNode.setPrevious(newLink);
        } else {
            throw new NullPointerException("Список пуст");
        }
    }

    /**
     * удаление элемента по хранимому значению
     * если удаляемый элемент - первый,  первым элементом назначается элемент после первого
     * если удаляемый элемент - последний,  последним  назначается элемент перед удаляемым
     * если удаляемый элемент не первый и не последний
     *  @param  value хранимое значение элемента
     * @throws   NullPointerException выбрасываемая ошибка в ситуации, когда список пуст
     *  */
    @Override
    public void delete(Comparable value) {
        Node<T> current = first;

        //удаляемый элемнет является первым
        if (first.getValue().compareTo((T) value) == 0) {
            first = first.getNext();
            current.setPrevious(current);
        }

        while (current.getNext() != null) {
            //если искомый элемнет найден
            if (current.getValue() == value) {
                current.getPrevious().setNext(current.getNext());
                current.getNext().setPrevious(current.getPrevious());
                return;
            }
            current = current.getNext();
        }
        //удаляемый элемнет последний
        if (isLast(current) && current.getValue() == value) {
            //  System.out.println("-----------------");
            current.getPrevious().setNext(null);
            last = current.getPrevious();
        }
        // если искомый элемнет равен == data и он последний
        else {
            throw new NullPointerException("Список пуст");
        }
    }

    /**
     * удаление первого элемнета
     * первым элемнетом назначается элемент после первого
     * @throws   NoSuchElementException выбрасываемая ошибка в ситуации, когда удаляемый элемнет не найдет
     */
    @Override
    public void deleteFirst() {
        if (!isEmpty()) {
            Node<T> next = first.getNext();
            next.setPrevious(null);
            first.setNext(null);
            first  = next;
        } else {
            throw new NullPointerException("Список пуст");
        }

    }
    /**
     * удаление последнего элемнета
     * последним элемнетом назначается элемент перед последним
     * @throws   NullPointerException выбрасываемая ошибка в ситуации, когда список пуст
     */
    @Override
    public void deleteLast() {
        if (!isEmpty()) {
            Node<T> previous = last.getPrevious();
            previous.setNext(null);
            last.setPrevious(null);
            last  = previous;
        } else {
            throw new NoSuchElementException("Список пуст");
        }
    }

    /**
     * удаление последнего элемнета
     * получение элемента из середине списка middleNode
     * next элемента перед middleNode назначается элемент, следующий после middleNode
     *  previous элемент, следующий после middleNode,  назначается элементу перед middleNode
     *  обнуление сслок next, previous  у middleNode
     * @throws   NullPointerException выбрасываемая ошибка в ситуации, когда список пуст
     */
    @Override
    public void deleteMiddle() {
        if (!isEmpty()) {
            Node<T> middleNode = getMiddleNode();
            Node<T> previous = middleNode.getPrevious();
            Node<T> next = middleNode.getNext();

            previous.setNext(next);
            next.setPrevious(previous);
            middleNode.setPrevious(null);
            middleNode.setNext(null);
        } else {
            throw new NullPointerException("Список пуст");
        }

    }

    /** сортировка списка  */
    @Override
    public void sort() {
        quickSort(first, last);
    }

    /** сортировка списка в обратном порядке  */
    @Override
    public void reverseSort() {
        quickSortReverse(first, last);
    }

    /**
     * проверка наличия элемента в списке
     * @param  value проверяемое значение на наличие в списке
     */
    @Override
    public boolean contains(Comparable value) {
        Node<T> current = first;
        while (current.getNext() != null) {
            if (current.getValue() == value) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    public Node<T> getFirst() {
        return first;
    }

    public Node<T> getLast() {
        return last;
    }

    private boolean isEmpty() {
        return first == null && last == null;
    }

    private boolean isLast(Node<T> node) {
        return node.getValue() == last.getValue();
    }

    /**
     * сортировка на базе quicksort
     * рекурсивный вызов метода для разделения листа на маленькие блоки
     *  @param first  последний элемнет списка
     *  @param last последний элемнет списка
     */
    private void quickSort(Node<T> first, Node<T>  last) {
        Node<T>  mid = null;
        if (first != last) {
            mid = partition(first, last);
            quickSort(first, mid);
            quickSort(mid.getNext(), last);
        } else {
            partition(last, mid);
        }
    }

    private void quickSortReverse(Node<T> first, Node<T> last) {
        Node<T> mid = null;
        if (last != first) {
            mid = partitionReverse(last, first);
            quickSortReverse(mid, last);
            quickSortReverse(first, mid.getPrevious());
        }
        else {
            partitionReverse(first, mid);
        }
    }

    /**
     * разделение на базе quicksort
     * назначение опорного элемнета pivotValue, текущего current, следующего next
     * сравнение next с pivotValue в цикле,
     * по завершению каждой итерации цикла передвижение next на один элемнет
     * если next > pivotValue, передвижение current на один элемнет
     * по завершению цикла, current будет иметь наименьшее значние
     * перестановка элемнетов первого элемента
     * @param first  последний элемнет списка
     * @param last последний элемнет списка
     * @return current текущий элемент до которого лист отсорован
     */
    private Node<T>  partition(Node<T>  first, Node<T> last) {
        T pivotValue = first.getValue();
        Node<T>  current = first;
        Node<T>  next = first.getNext();
        while (next != last) {
            if (next.getValue().compareTo(pivotValue) == -1) {
                current = current.getNext();
                swap(current, next);
            }
            next = next.getNext();
        }
        swap(current, first);
        return current;
    }
    private Node<T> partitionReverse(Node<T> last, Node<T> first ) {
        T pivotValue = last.getValue();
        Node<T> current = last;
        Node<T> previous = last.getPrevious();
        while (previous != first) {
            if (previous.getValue().compareTo(pivotValue) == -1) {
                current = current.getPrevious();
                swap(previous, current);
            }
            previous = previous.getPrevious();
        }
        swap(current, last);
        return current;
    }

    /**
     * перестановка элемнетов
     * используется временный элемнет temp для замены значений элементов
     */
    private void swap(Node<T>  element1, Node<T>  element2) {
        T temp = element1.getValue();
        element1.setValue(element2.getValue());
        element2.setValue(temp);
    }

    /**
     * поиск среднего элемнета
     * назначение previous, current
     * previous продвигается на элемнет пока условие true
     * current продвигается на два элемнет пока условие true
     * когда условие станет false, current дойдет до конца листа, previous будет на середине
     * @return Node<T> previous средний элемнет
     */
    public Node<T> getMiddleNode(){
        if(first == null || first.getNext() == null) {
            return first;
        }
        Node<T> previous= first;
        Node<T> current= first;

        while(current != null &&  current.getNext() != null){
            previous = previous.getNext();
            current = current.getNext().getNext();

        }
        return previous;
    }
}
