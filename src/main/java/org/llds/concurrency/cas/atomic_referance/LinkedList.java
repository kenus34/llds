package org.llds.concurrency.cas.atomic_referance;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class LinkedList<T> {
    static class Node<T>{
        T val;
        Node<T> next;
        public Node(T val){
            this.val=val;
            this.next=null;
        }
    }
    private AtomicReference<Node<T>> head = new AtomicReference<>(null);
    AtomicInteger size = new AtomicInteger(0);
    public int size(){
        return size.get();
    }
    void add(T val){
        Node<T> node = new Node<>(val);
        size.incrementAndGet();
        while (true){
            Node<T> expectedHead = head.get();
            node.next = head.get();
            if(head.compareAndSet(expectedHead,node)){
                return;
            }
        }
    }

    T pull(){
        if(head.get()==null){
            return null;
        }
        while (true){
            Node<T> expected = head.get();
            Node<T> nextHead = expected.next;
            if(head.compareAndSet(expected, nextHead)){
                return expected.val;
            }
        }
    }
}
