package serialize;

import java.io.*;

/**
 * Created by wangxiyue on 2017/7/11.
 */
public class Serialize {
    public static void main(String[] args){
        Student student = new Student();
        student.setName("fxb");
        student.setAge(23);
        student.setSex("man");
        student.setAddress("China");

        File file = new File("fxb_serialized.seri");
        if (file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            //Student对象序列化的过程
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(student);
            objectOutputStream.flush();
            objectOutputStream.close();
            fileOutputStream.close();


            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Student newStudent = (Student)objectInputStream.readObject();
            System.out.println(newStudent);
            fileInputStream.close();
            objectInputStream.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}
