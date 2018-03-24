package demo1_automic;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author fangjiaxiaobai@163.com
 * @date 2018/3/20
 */
public class AtomicReferenceDemo {
    
    public static void main(String[] args) {
        ConcurrentStack<String> stack = new ConcurrentStack();
        stack.push("123");
        stack.push("456");
        stack.push("789");
        System.out.println(stack.pop());
    }



}

class ConcurrentStack<T> {
    private AtomicReference<Node<T>> stacks = new AtomicReference<Node<T>>();
    
    public T push(T e){
        Node<T> oldNode ,newNode;
        while(true){
            oldNode =  stacks.get();
            newNode = new Node<>(e,oldNode);
            if(stacks.compareAndSet(oldNode,newNode)){
                return e;
            }
        }
    }
    
    public T pop(){
        Node<T> oldNode,newNode;
        while(true){
            oldNode = stacks.get();
            newNode = oldNode.next;
            if(stacks.compareAndSet(oldNode,newNode)){
                return oldNode.t;
            }
        }
    }
    
    private static final class Node<T>{
        private T t;
        private Node<T> next;
        private Node(T t,Node<T> next){
            this.t = t ;
            this.next = next;
        }
    }
    
}
