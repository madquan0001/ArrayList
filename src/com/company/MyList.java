package com.company;

import java.util.Arrays;

public class MyList <E> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private E[] elements;

    MyList(){
        elements = (E[]) new Object[DEFAULT_CAPACITY];
    }

    MyList(int capacity){
        elements = (E[])new Object[capacity];
    }

    private boolean isEmpty(){
        int count = 0;
        for(int i = 0; i < elements.length; i++){
            if(elements[i] == null){
                count++;
            }
        }
        if(count == elements.length){
            return true;
        }
        return false;
    }

    public void add(int index, E element){
        if(index < elements.length && index >= 0) {
            if (index == 0) {
                if (elements[0] == null) {
                    elements[0] = element;
                    size++;
                } else {
                    E[] temp = (E[]) new Object[elements.length];
                    for (int i = 0; i < elements.length; i++) {
                        temp[i] = elements[i];
                    }
                    elements = Arrays.copyOf(elements, elements.length + 1);
                    elements[0] = element;
                    for (int i = 1; i < elements.length; i++) {
                        elements[i] = temp[i - 1];
                    }
                    size++;
                }
            } else {
                if (elements[index - 1] != null) {
                    if (elements[index] == null) {
                        elements[index] = element;
                        size++;
                    } else {
                        E[] temp = (E[]) new Object[elements.length - index];
                        for (int i = index; i < elements.length; i++) {
                            temp[i - index] = elements[i];
                        }
                        elements = Arrays.copyOf(elements, elements.length + 1);
                        elements[index] = element;
                        for (int i = index; i < elements.length-1; i++) {
                            elements[i+1] = temp[i - index];
                        }
                        size++;
                    }
                }
            }
        }
    }

    public E remove(int index){
        if(index < elements.length && index >= 0) {
            if (elements[index] != null) {
                E[] temp = (E[]) new Object[elements.length - 1];
                if (index == 0) {
                    for (int i = 0; i < elements.length - 1; i++) {
                        temp[i] = elements[i + 1];
                    }
                } else if (index == elements.length - 1) {
                    for (int i = 0; i < elements.length - 1; i++) {
                        temp[i] = elements[i];
                    }
                }
                for (int i = 0; i < index; i++) {
                    temp[i] = elements[i];
                }
                for (int i = index; i < elements.length - 1; i++) {
                    temp[i] = elements[i + 1];
                }
                elements = Arrays.copyOf(temp, temp.length);
                size--;
            }
        }
        return (E) this;
    }

    public int size(){
        return size;
    }

    public E clone(){
        return (E) this;
    }

    public boolean contains(E o){
        for(int i = 0; i < elements.length; i++){
            if(elements[i] == o){
                return true;
            }
        }
        return false;
    }

    public int indexOf(E o){
        for(int i = 0; i < elements.length; i++){
            if(elements[i] == o){
                return i;
            }
        }
        return -1;
    }

    public boolean add(E e){
        if(!this.contains(e)){
            return true;
        }
        return false;
    }

    public void ensureCapacity(int minCapacity){
        elements = Arrays.copyOf(elements, elements.length+minCapacity);
    }

    public E get(int i){
        return elements[i];
    }

    public void clear(){
        elements = (E[]) new Object[0];
    }
}