package cn.edu.bupt.ch2.Singleton_Pattern;

import org.junit.Assert;
import org.junit.Test;

import java.io.*;

public class Main {

    public static void main(String[] args) {
        Singleton.createString();
    }

    @Test
    public void test() throws Exception {
        SerSingleton s1 = null;
        SerSingleton s = SerSingleton.getInstance();
        //先将实例串行化到文件
        FileOutputStream fos = new FileOutputStream("src/main/resources/tempDir/SerSingleton.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(s);
        oos.flush();
        oos.close();
        //从文件读出原有的单例类
        FileInputStream fis = new FileInputStream("src/main/resources/tempDir/SerSingleton.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        s1 = (SerSingleton) ois.readObject();

        Assert.assertEquals(s, s1);
    }
}
