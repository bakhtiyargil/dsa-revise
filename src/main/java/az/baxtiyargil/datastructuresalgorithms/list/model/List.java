package az.baxtiyargil.datastructuresalgorithms.list.model;

public interface List<E> {

    int size();

    boolean isEmpty();

    E get(int i) throws IndexOutOfBoundsException;

    /**
     * Replaces the element at index i with element
     *
     * @param i       index to replace
     * @param element element to replace with provided index
     * @return Returns replaced element
     * @throws IndexOutOfBoundsException when i index is out of bounds
     */
    E set(int i, E element) throws IndexOutOfBoundsException;

    void add(int i, E element) throws IndexOutOfBoundsException;

    E remove(int i) throws IndexOutOfBoundsException;

}
