package array.sortAlogrithm;

import array.CopyCollection;

/**
 * 排序接口
 * @author fangjiaxiaobai@163.com
 * @date 2018/3/12
 */
public interface SortAlogrithm<T extends Comparable> {
    void sort(CopyCollection<T> collection);
}
