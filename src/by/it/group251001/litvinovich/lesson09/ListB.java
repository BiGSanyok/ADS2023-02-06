package by.it.group251001.litvinovich.lesson09;

import java.util.*;

public class ListB<E> implements List<E> {


    //Создайте аналог списка БЕЗ использования других классов СТАНДАРТНОЙ БИБЛИОТЕКИ

    /////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////
    //////               Обязательные к реализации методы             ///////
    /////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////

    private Object[] elements = new Object[1];
    private int size = 0;

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        String separator = "";
        for (int i = 0; i < size(); i++) {
            result.append(separator).append(elements[i]);
            separator = ", ";
        }
        result.append("]");
        return result.toString();
    }

    @Override
    public boolean add(E e) {
        if (elements.length == size)
            elements = Arrays.copyOf(elements, size * 2);
        elements[size++] = e;
        return true;
    }

    @Override
    public E remove(int index) {
        if (index >= size())
            return null;
        E result = (E) elements[index];
        for (int i = index; i < size() - 1; i++)
            elements[i] = elements[i + 1];
        size--;
        return result;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(int index, E element) {
        if (elements.length == size)
            elements = Arrays.copyOf(elements, size * 2);
        size++;
        for (int i = size - 1; i > index; i--)
            elements[i] = elements[i - 1];
        elements[index] = element;
    }

    @Override
    public boolean remove(Object o) {
        int index = 0;
        while (index < size() && !elements[index].equals(o))
            index++;
        if (index == size())
            return false;
        remove(index);
        return true;
    }

    @Override
    public E set(int index, E element) {
        E result = (E) elements[index];
        elements[index] = element;
        return result;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public void clear() {
        elements = new Object[1];
        size = 0;
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < size(); i++)
            if (elements[i].equals(o))
                return i;
        return -1;
    }

    @Override
    public E get(int index) {
        return (E) elements[index];
    }

    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < size(); i++)
            if (elements[i].equals(o))
                return true;
        return false;
    }

    @Override
    public int lastIndexOf(Object o) {
        for (int i = size() - 1; i >= 0; i--)
            if (elements[i].equals(o))
                return i;
        return -1;
    }


    /////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////
    //////               Опциональные к реализации методы             ///////
    /////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////


    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }


    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    /////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////
    ////////        Эти методы имплементировать необязательно    ////////////
    ////////        но они будут нужны для корректной отладки    ////////////
    /////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////
    @Override
    public Iterator<E> iterator() {
        return null;
    }

}
