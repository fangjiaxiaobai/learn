package demo1;

import java.util.ArrayList;
import java.util.List;

/**
 * VM args: -Xms20M -Xmx20M -XX:+HeapDumpOnOutOfMemoryError
 *
 * @author 方小白 on 2017/9/29 10:29.
 * @description
 *
 *      演示  java堆溢出 异常
 *  限制java堆的大小为20MB，不可扩展(将堆的最小值-Xms参数和最大值-Xmx参数设置为一样，即可避免堆自动扩展)
 *  通过参数-XX:+HeapDumpOnOutOfMemoryError 可以让虚拟机在出现内存溢出异常时，Dump出当前的内存堆转存快照以便事后分析。
 *
 * 提示信息：
 *      java.lang.OutOfMemoryError: Java heap space
 */
public class HeapOOM {
    static class OOMObject{}
    
    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList <>();
    
        while(true) {
            list.add(new OOMObject());
        }
    }
}
