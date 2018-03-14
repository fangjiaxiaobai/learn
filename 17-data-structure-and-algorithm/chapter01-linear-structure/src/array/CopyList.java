package array;

import array.sortAlogrithm.SortAlogrithm;

import java.util.Arrays;

/**
 * @Title 线性表
 * @tip 底层：数组
 * @author fangjiaxiaobai@163.com
 * @date 2018/3/12
 * @contains 1.ArrayList源码。
 *           2.数据结构-线性表
 *           3.排序算法：冒泡，选择，插入，shell
 *           4.设计模式-策略设计模式
 */
public class CopyList<T> implements CopyCollection {
    
    // 默认初始容量
    private static final int CAPACITY = 10;
    
    // 存放数据的"数据池"---根源：数组。
    private Object[] elements = {};
    
    // 有参构造时的 容量大小
    private int initCapacity = CAPACITY;
    
    // 借鉴JDK--ArrayList
    private static final Object[] EMPTY_ELEMENTS = {};
    
    // 必须声明为volatile，保证与其他线程的可见性。
    // 本类中没有什么作用，在迭代器中使用。
    private volatile int modCount = 0;
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE-8;
    
    // 当前数组的大小。
    private int size;
    public CopyList(){
    
    }
    
    public CopyList(int capacity){
        if(0>capacity){
            throw new IllegalArgumentException("初始化的容器不能<0!");
        }else if(0==capacity){
            elements =EMPTY_ELEMENTS;
        }else{
            initCapacity = capacity;
        }
    }
    
    
    /*************增*********************/
    
    public int add(T t){
        // 首先确定当前数组的大小和容量。
        ensureArraySize(size+1);
        this.elements[size++] = t;
        modCount++;
        return size-1;
    }
    
    public void add(int j, T k) {
        if(j>0 && j<=MAX_ARRAY_SIZE){
            ensureArraySize(j);
            
            if(j<elements.length){
                System.arraycopy(elements,j-1,elements,j,size-j);
            }else{
                elements[j-1]=k;
            }
            modCount++;
        }
    }
    private void ensureArraySize(int i) {
       // 首先判断 数组有没有初始化；
        if(elements == EMPTY_ELEMENTS){
            i = Math.max(CAPACITY,i);
        }
        ensureExplicitCapacity(i);
    }
    
    /**
     * 判断是否需要扩容
     * @param i
     */
    private void ensureExplicitCapacity(int i) {
        modCount++;
        if(i>elements.length){
            grow(i);
        }
    }
    
    // 扩容及初始化
    private void grow(int i) {
        int oldCapacity = elements.length;
        int newCapacity = oldCapacity+(oldCapacity>>1); // 3/2倍的原来容量
        if(newCapacity<i){
            newCapacity = i;
        }
        // 超过了最大容量。
        if(newCapacity>MAX_ARRAY_SIZE){
            newCapacity = hugeCapacity(newCapacity);
        }
        elements = Arrays.copyOf(elements,newCapacity);
    }
    
    private int hugeCapacity(int newCapacity) {
        if(newCapacity<0){
            throw new OutOfMemoryError();
        }
        return newCapacity<Integer.MAX_VALUE?Integer.MAX_VALUE:MAX_ARRAY_SIZE;
    }
    
    /******************删除***********************/
    public T remove(int index){
        // 检查索引是否合法
        checkRange(index);
        modCount++;
        T oldElement =(T) elements[index];
        int movedNum = size - index -1;
        if(movedNum>0){
            //
            System.arraycopy(elements,index+1,elements,index,movedNum);
        }
        // 将最后一位置为null!!!!不要忘记了。
        elements[--size] = null;
        modCount++;
        return oldElement;
    }
    
    private void checkRange(int index) {
        if(index < 0 || index>elements.length){
            throw new IndexOutOfBoundsException("索引不合法");
        }
    }
    
/************************修改***********************************/
    public boolean update(int index,T t){
        checkRange(index);
        modCount++;
        elements[index-1] = t;
        modCount++;
        return true;
    }
    
    /********************查找*************************/
    public T contains(int index){
        return indexOf(index);
    }
    
    public int contains(T t){
        return indexOf(t);
    }
    
    private T indexOf(int index){
        checkRange(index);
        return (T) elements[index];
    }
    
    private int indexOf(T t) {
        if(null == t ){
            for (int i=0; i < size; i++) {
                if(elements[i] == null){
                    return i;
                }
            }
        }else{
            for (int i=0; i < size; i++) {
                if(t.equals(elements[i])){
                    return i;
                }
            }
        }
        return 0;
    }
    
    
    public int size(){
        return size;
    }
    
    public T get(int index){
        return indexOf(index);
    }
    
 /********************排序*********************************/
 
    public void sort(SortAlogrithm sortAlogrithm){
        sortAlogrithm.sort(this);
    }
    

}
