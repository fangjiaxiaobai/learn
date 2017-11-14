package serialize;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * Created by wangxiyue on 2017/7/11.
 */
public class StudentExternalizable implements Externalizable {


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


    @Override
    public void writeExternal(ObjectOutput out) throws IOException{
        out.writeObject(name);
        out.writeObject(age);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException{
        this.name = (String)in.readObject();
        this.age = (int)in.readObject();
    }
}
