package com.fxb.custom;

/**
 * @create by: wangxiyue on 2017/7/31 10:54.
 * @ClassName:
 * @userfor:
 * @description:
 */
public class LinkedList<E> {


    /**
     * @title 定义linkedList的数据结构
     */
    private static class Node<E> {
        E item;  //存储数据
        Node<E> prev;
        Node<E> next;

        Node(Node<E> prev,Node<E> next,E item){
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }


    public boolean add(E e){
        lastAdd(e);
        return true;
    }

    public void lastAdd(E e){


    }



}
