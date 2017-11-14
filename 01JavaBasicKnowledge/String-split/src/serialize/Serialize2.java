package serialize;

import java.io.*;

/**
 * Created by wangxiyue on 2017/7/11.
 */
public class Serialize2 {
    public static void main(String[] args){
        StudentExternalizable student=new StudentExternalizable();
        student.setName("fxb");
        student.setAge(23);
        student.setSex("man");
        student.setAddress("China");

        File file=new File("fxb_externalizable.exter");
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            ObjectOutputStream objectOutputStream=new ObjectOutputStream(new FileOutputStream(file));
            objectOutputStream.writeObject(student);
            objectOutputStream.close();

            ObjectInputStream objectInputStream=new ObjectInputStream(new FileInputStream(file));
           StudentExternalizable newstudent = (StudentExternalizable)objectInputStream.readObject();
            objectInputStream.close();
            System.out.println(newstudent);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
