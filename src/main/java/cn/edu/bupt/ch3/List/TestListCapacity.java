package cn.edu.bupt.ch3.List;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 如果需要用到频繁的add操作，new ArrayList()的时候指定其大小效率会更高，
 * 不然数组扩容的过程中会导致整个数组进行一次内存复制。
 * 每次扩容将新的数组大小设置为原大小的1.5倍
 *
 * Created by FirenzesEagle on 2016/5/26 0026.
 * Email:liumingbo2008@gmail.com
 */
public class TestListCapacity {

    protected List list;

    protected void testAddTail(String funcName) {
        Object obj = new Object();
        long beginTime = System.currentTimeMillis();

        for (int i = 0; i < 1000000; i++) {
            list.add(obj);
        }
        long endTime = System.currentTimeMillis();
        System.out.println(funcName + " 花费：" + (endTime - beginTime) + " ms");
    }

    /**
     * testAddTailArrayList 花费：17 ms
     */
    @Test
    public void testAddTailArrayList() {
        list = new ArrayList();
        testAddTail("testAddTailArrayList");
    }

    /**
     * testAddTailArrayListCapacity 花费：11 ms
     */
    @Test
    public void testAddTailArrayListCapacity() {
        list = new ArrayList(1000000);
        testAddTail("testAddTailArrayListCapacity");
    }

}
