package demo1_staticProxy;

/**
 * @author fangjiaxiaobai@163.com
 * @date 2018/3/5
 */
public interface IUserDao {

     default void save(){
         System.out.println("this is save method in demo1_staticProxy.IUserDao");
     }

}
