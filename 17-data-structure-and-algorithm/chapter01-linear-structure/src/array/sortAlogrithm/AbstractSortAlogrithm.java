package array.sortAlogrithm;

import array.CopyCollection;
import array.CopyList;

/**
 * 实现排序的默认算法----冒泡排序
 * @author fangjiaxiaobai@163.com
 * @date 2018/3/12
 */
public class AbstractSortAlogrithm<T extends Comparable> implements SortAlogrithm {
    @Override
    public void sort(CopyCollection collection) {
        if(collection instanceof CopyList){
            CopyList cl =(CopyList<T>) collection;
            for(int i = 0;i<cl.size();i++){
                for(int j = i-1;j>0;j--){
                    if(((T) cl.get(j - 1)).compareTo((T) cl.get(j))>0){
                        T t =(T) cl.get(j);
                        cl.update(j,cl.get(j-1));
                        cl.update(j-1,t);
                    }
                }
            }
        }
    }
    
}
