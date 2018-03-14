package array.sortAlogrithm;

import array.CopyCollection;
import array.CopyList;

/**
 * 插入排序
 * @author fangjiaxiaobai@163.com
 * @date 2018/3/12
 */
public class InsertSortAlogrithm<T extends Comparable> extends AbstractSortAlogrithm{
    
    @Override
    public void sort(CopyCollection collection) {
    
        CopyList cl =(CopyList) collection;
        
        T  k ;
        for (int i=1; i < cl.size()-1; i++) {
            k =(T) cl.get(i);
            int j = 0;
            for (j=i; j > 0 && ((T)cl.get(j)).compareTo(cl.get(i))>0; j--) {
            }
            cl.remove(i);
            cl.add(j,k);
        }
    }
}
