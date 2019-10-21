package p4_5;

import java.io.*;

/**
 * @ClassName ObjectOperation
 * @Description Java i/o——对象操作
 * @Author shishi
 * @Date 2019/10/18 13:57
 **/
public class ObjectOperation {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        A a1 = new A(1, "shishi");
        String objectFile = "C:\\Users\\89467\\Desktop\\object.txt";

        // 序列化
        // 定义一个文件输出字节流
        FileOutputStream fileOutputStream = new FileOutputStream(objectFile);
        // 然后利用这个文件输出字节流，构建一个对象输出字节流
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(a1);
        objectOutputStream.close();

        // 反序列化
        FileInputStream fileInputStream = new FileInputStream(objectFile);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        A a2 = (A) objectInputStream.readObject();
        System.out.println(a2.toString());

    }

    // 实现了Serializable接口的静态内部类
    private static class A implements Serializable{
        private int x;
        private String y;

        public A(int x, String y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "x=" + x + ", y='" + y + "'";
        }
    }
}