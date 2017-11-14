package serialize;
import java.io.Serializable;

/**
 * Created by wangxiyue on 2017/7/11.
 * ClassName:Student
 * UseFor:用于演示序列化和反序列化的demo类
 */
public class Student implements Serializable{

    private String name;
    private int age;
    private String sex;
    private String address;

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name=name;
    }

    public int getAge(){
        return age;
    }

    public void setAge(int age){
        this.age=age;
    }

    public String getSex(){
        return sex;
    }

    public void setSex(String sex){
        this.sex=sex;
    }

    public String getAddress(){
        return address;
    }

    public void setAddress(String address){
        this.address=address;
    }

    @Override
    public String toString(){
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
