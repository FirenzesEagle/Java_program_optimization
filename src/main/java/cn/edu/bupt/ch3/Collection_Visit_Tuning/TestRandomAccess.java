package cn.edu.bupt.ch3.Collection_Visit_Tuning;

import org.junit.Test;

import java.util.*;

/**
 * Created by FirenzesEagle on 2016/6/3 0003.
 * Email:liumingbo2008@gmail.com
 */
public class TestRandomAccess {

    List list = null;

    /**
     * testArrayList 花费：6998619 nanoTime
     */
    @Test
    public void testArrayList() {
        list = new ArrayList();
        initList();
        testRandomAccess("testArrayList");
    }

    /**
     * testLinkedList 花费：31957370 nanoTime
     */
    @Test
    public void testLinkedList() {
        list = new LinkedList();
        initList();
        testRandomAccess("testLinkedList");
    }

    public void initList() {
        for (int i = 0; i < 1000; i++)
            list.add(i);
    }

    public void testRandomAccess(String funcName) {
        long beginTime = System.nanoTime();
        for (int k = 0; k < 10000; k++) {
            Object o;
            if (list instanceof RandomAccess) {
                for (int i = 0, n = list.size(); i < n; i++) {
                    o = list.get(i);
                    //处理元素对象
                }
            } else {
                Iterator itr = list.iterator();
                for (int i = 0, n = list.size(); i < n; i++) {
                    o = itr.next();
                    //处理元素对象
                }
            }
        }
        long endTime = System.nanoTime();
        System.out.println(funcName + " 花费：" + (endTime - beginTime) + " nanoTime");
    }


}
