/**
 * @author Victoria Zhirnova
 * @project mylinkedlist-example
 *
 *  Параметризованный тип T характеризет тип хранимых элемнетов в списке.
 *  Для корректного сравнения элемнетов между собой хранимые элемнеты должны наследоваться от Comparable
 *
 */

public interface MyList<T extends Comparable> {

    /** добавление элемента в конец списка */
    public void addLast(T value);

    /** добавление элемента в начало списка */
    public void addFirst(T value);

    /** добавление элемента в середину списка */
    public void addMiddle(T value);

    /** удаление элемента по значению */
    public void delete(T value);

    /** удаление первого элемента  */
    public void deleteFirst();

    /** удаление последнего элемента */
    public void deleteLast();

    /** удаление элемента из середины списка */
    public void deleteMiddle();

    /** натурильная сортировка списка в середину списка */
    public void sort();

    /** сортировка в обратном порядке */
    public void reverseSort();

    /** проверка наличия элемента в списке */
    public boolean contains(T value);
}
