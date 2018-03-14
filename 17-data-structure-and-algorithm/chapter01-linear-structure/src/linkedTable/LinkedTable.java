package linkedTable;

/**
 * @author fangjiaxiaobai@163.com
 * @date 2018/3/13
 */
public class LinkedTable<T> {
    
    private Node<T> first;
    private Node<T> last;
    private int size;
    private volatile int modCount = 0;
    /**
     * 节点。
     * @param <T>
     */
    private class Node<T> {
        T item;
        private Node<T> pre;
        private Node<T> aft;
    
        public Node(T item, Node pre, Node aft) {
            this.item=item;
            this.pre=pre;
            this.aft=aft;
        }
    }
    
    public LinkedTable(){}
    
    public LinkedTable(T t){
        this();
        addAll(t);
    }
    
    private void addAll(T t) {
        linkLast(t);
    }
    /***********************增加****************************/
    public void add(int index,T element){
        checkIndex(index); // 检查索引是否合法
        
        if(size == index){
            linkLast(element);
        }else{
            // 只要知道第index位置上的那个Node就可以了。
            linkBefore(element,node(index));
        }
    }
    
    
    private void linkBefore(T element, Node<T> node) {
        Node prev = node.pre;
        Node<T> tNode=new Node<>(element, prev, node);
        node.pre = tNode;
        if(prev==null){
            prev = tNode;
        }else {
            prev.aft = tNode;
        }
    }
    
    /**
     * 查找指定位置上的Element
     * @param index
     * @return
     */
    private Node node(int index) {
        if(index < size>>1){
            Node x = first;
            for (int i=0; i <index; i++) {
                 x = x.aft;
            }
            return x;
        }else {
            Node<T>  x = last;
            for (int i=size-1; i > index; i--) {
                x = x.pre;
            }
          return x;
        }
        
    }
    
    private void linkLast(T element) {
        Node<T> l = last.pre;
        Node<T> node=new Node<>(element, last.pre, null);
        if(null==l){
            l = node;
        }else{
            l.aft = node;
        }
        modCount ++;
        size++;
    }
    
    private void checkIndex(int index) {
        if(index < 0 || index>=size){
            throw new IndexOutOfBoundsException("index 不合法");
        }
    }
    
    /****************删************************/
    public T remove(int index){
        checkIndex(index);
        return (T) unlink(node(index));
    }
    
    private T unlink(Node<T> node) {
        
        node.pre.aft = node.aft;
        node.aft.pre = node.pre;
        node.pre = null;
        node.aft = null;
        node.item = null;
        size--;
        modCount++;
        return node.item;
    }
    
    
}


