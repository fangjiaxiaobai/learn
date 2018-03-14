package array.sortAlogrithm;

import array.CopyCollection;
import array.CopyList;

/**
 *  希尔排序算法
 * @author fangjiaxiaobai@163.com
 * @date 2018/3/12
 */
public class ShellSortAlogrithm<T extends Comparable> extends AbstractSortAlogrithm {
    
    @Override
    public void sort(CopyCollection collection) {
        CopyList cl =(CopyList) collection;
        for (int i=cl.size(); i > 0 ; i>>=1) {
            for (int j=0; j < cl.size(); j++) {
                for (int k=j-i; k >0 && ((T)cl.get(k)).compareTo(cl.get(k-j))>0 ; k++) {
                    T t =(T) cl.get(k);
                    cl.update(k,cl.get(k-j));
                    cl.update(k-j,t);
                }
            }
        }
//        super.sort(collection);
    }
}
