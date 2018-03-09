package demo1;

import java.util.Enumeration;
import java.util.Vector;

/**
 * @author fangjiaxiaobai@163.com
 * @date 2018/3/9
 */
public abstract class AbstractSubject implements Subject {
    
    private Vector<Observer> vector = new Vector<>();
    
    @Override
    public void add(Observer observer) {
         vector.add(observer);
    }
    
    @Override
    public void delete(Observer observer) {
            vector.remove(observer);
    }
    
    @Override
    public void notifyObservers() {
        Enumeration<Observer> elements=vector.elements();
        while (elements.hasMoreElements()) {
            elements.nextElement().update();
        }
    }
    
}
