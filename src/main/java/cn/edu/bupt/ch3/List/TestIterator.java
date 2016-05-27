package cn.edu.bupt.ch3.List;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by FirenzesEagle on 2016/5/27 0027.
 * Email:liumingbo2008@gmail.com
 */
public class TestIterator {

    List<String> list = null;
    private static final int CIRCLE = 1000000;

    public void initList(List<String> list) {
        list.clear();
        for (int i = 0; i < CIRCLE; i++) {
            list.add(String.valueOf(0));
        }
    }

    public void internalTest() {
        String tmp;
        long beginTime = System.currentTimeMillis();
        for (String s : list) {
            tmp = s;
        }
        System.out.println("foreach spend:" + (System.currentTimeMillis() - beginTime) + " ms");

        beginTime = System.currentTimeMillis();
        for (Iterator<String> it = list.iterator(); it.hasNext(); ) {
            tmp = it.next();
        }
        System.out.println("Iterator spend;" + (System.currentTimeMillis() - beginTime) + " ms");

        if (list instanceof LinkedList) return;
        beginTime = System.currentTimeMillis();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            tmp = list.get(i);
        }
        System.out.println("for spend;" + (System.currentTimeMillis() - beginTime) + " ms");
    }

    /**
     * foreach spend:9 ms
     * Iterator spend;9 ms
     * for spend;7 ms
     */
    @Test
    public void testArrayList() {
        list = new ArrayList<String>();
        initList(list);
        internalTest();
    }

    /**
     * foreach spend:18 ms
     * Iterator spend;15 ms
     */
    @Test
    public void testLinkedList() {
        list = new LinkedList<String>();
        initList(list);
        internalTest();
    }

}
