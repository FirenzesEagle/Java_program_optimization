package cn.edu.bupt.ch1.Buffer;

import org.junit.Test;

import java.io.*;

/**
 * 有缓冲与无缓冲的文件写入操作耗时对比
 *
 * Created by FirenzesEagle on 2016/5/19 0019.
 * Email:liumingbo2008@gmail.com
 */
public class FileWriterBufferTest {

    public static final int CIRCLE = 100000;

    @Test
    public void testFileWriter() throws IOException {
        Writer writer = new FileWriter(new File("src/main/resources/tempDir/file.txt"));
        long begin = System.currentTimeMillis();
        for (int i = 0; i < CIRCLE; i++) {
            writer.write(i);
        }
        writer.close();
        System.out.println("testFileWriter spend:" + (System.currentTimeMillis() - begin));
    }

    @Test
    public void testFileWriterBuffer() throws IOException {
        Writer writer = new BufferedWriter(new FileWriter(new File("src/main/resources/tempDir/file.txt")));
        long begin = System.currentTimeMillis();
        for (int i = 0; i < CIRCLE; i++) {
            writer.write(i);
        }
        writer.close();
        System.out.println("testFileWriterBuffer spend:" + (System.currentTimeMillis() - begin));

    }

}
