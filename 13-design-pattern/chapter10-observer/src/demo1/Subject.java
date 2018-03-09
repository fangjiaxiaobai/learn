package demo1;

/**
 * @author fangjiaxiaobai@163.com
 * @date 2018/3/9
 */
public interface Subject {
    
    /**
     * 添加观察者
     * @param observer
     */
    void add(Observer observer);
    
    /**
     * 删除观察者
     * @param observer
     */
    void delete(Observer observer);
    
    /**
     * 通知所有观察者
     */
    void notifyObservers();
    
    /**
     * 自身的操作
     */
    void operation();
}
