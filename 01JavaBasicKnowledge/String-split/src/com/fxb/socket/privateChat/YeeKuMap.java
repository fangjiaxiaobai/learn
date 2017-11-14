package com.fxb.socket.privateChat;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @create by: wangxiyue on 2017/7/14 17:13.
 * @ClassName:
 * @userfor:
 * @description:
 */
public class YeeKuMap<K,V> extends HashMap<K,V> {
    //根据value删除指定项
    public void removeByValue(Object value){
        for (K key : keySet()) {
            if(get(key) == value){
                remove(key);
                break;
            }
        }
    }

    //获取所有Value组成的Set集合
    public Set<V> valueSet(){
        Set<V> result = new HashSet<V>();
        for (K key : keySet()) {
            result.add(get(key));
        }
        return result;
    }

    //根据Value查找key
    public K getKeyByValue(V val){
        for (K key : keySet()) {
            if (get(key).equals(val)&&get(key)==val) {
                return key;
            }
        }
        return null;
    }

    //重写HashMap的put方法，该方法不允许value重复
    public V put(K key,V value){
        for (V val : valueSet()) {
            if(val.equals(value)&&val.hashCode()==value.hashCode()){
                throw  new RuntimeException("MyMap 实例中不允许有重复的value");
            }
        }
        return super.put(key,value);
    }

}
