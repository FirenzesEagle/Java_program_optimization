package cn.edu.bupt.ch3.List;

import org.junit.Test;

import java.util.*;

/**
 * Tips: 在LinkedList的实现中，首先要通过循环找到要删除的元素。
 * 如果要删除的位置处于List的前半段，则从前往后找；若其位置处于后半段，则从后往前找
 * 因此无论要删除较为靠前或者靠后的元素都是非常高小的；
 * 但要移除List中间的元素却几乎要遍历完半个List，
 * 在List拥有大量元素的情况下，效率很低
 *
 * Created by FirenzesEagle on 2016/5/24 0024.
 * Email:liumingbo2008@gmail.com
 */
public class TestList {


    private static final int CIRCLE = 100000;
    protected List list;

    protected void testAddTail(String funcName) {
        Object obj = new Object();
        long beginTime = System.currentTimeMillis();

        for (int i = 0; i < 500000; i++) {
            list.add(obj);
        }
        long endTime = System.currentTimeMillis();
        System.out.println(funcName + " 花费：" + (endTime - beginTime) + " ms");
    }

    protected void testDelTail(String funcName) {
        Object obj = new Object();
        for (int i = 0; i < CIRCLE; i++) {
            list.add(obj);
        }

        long beginTime = System.currentTimeMillis();
        while (list.size() > 0) {
            list.remove(list.size() - 1);
        }
        long endTime = System.currentTimeMillis();
        System.out.println(funcName + " 花费：" + (endTime - beginTime) + " ms");
    }

    protected void testDelFirst(String funcName) {
        Object obj = new Object();
        for (int i = 0; i < CIRCLE; i++) {
            list.add(obj);
        }

        long beginTime = System.currentTimeMillis();
        while (list.size() > 0) {
            list.remove(0);
        }
        long endTime = System.currentTimeMillis();
        System.out.println(funcName + " 花费：" + (endTime - beginTime) + " ms");
    }

    protected void testDelMiddle(String funcName) {
        Object obj = new Object();
        for (int i = 0; i < CIRCLE; i++) {
            list.add(obj);
        }

        long beginTime = System.currentTimeMillis();
        while (list.size() > 0) {
            list.remove(list.size() >> 1);
        }
        long endTime = System.currentTimeMillis();
        System.out.println(funcName + " 花费：" + (endTime - beginTime) + " ms");
    }

    protected void testAddFirst(String funcName) {
        Object obj = new Object();
        long beginTime = System.currentTimeMillis();

        for (int i = 0; i < 50000; i++) {
            list.add(0, obj);
        }
        long endTime = System.currentTimeMillis();
        System.out.println(funcName + " 花费：" + (endTime - beginTime) + " ms");
    }

    /* -------------- 测试List尾部插入元素的效率---------------*/

    /**
     * 测试在ArrayList的尾部插入元素的效率
     * testAddTailArrayList 花费：14 ms
     */
    @Test
    public void testAddTailArrayList() {
        list = new ArrayList();
        testAddTail("testAddTailArrayList");
    }

    /**
     * 测试在Vector的尾部插入元素的效率
     * testAddTailVector 花费：17 ms
     */
    @Test
    public void testAddTailVector() {
        list = new Vector();
        testAddTail("testAddTailVector");
    }

    /**
     * 测试在LinkedList的尾部插入元素的效率
     * testAddTailLinkedList 花费：13 ms
     */
    @Test
    public void testAddTailLinkedList() {
        list = new LinkedList();
        testAddTail("testAddTailLinkedList");
    }

    /* -------------- 测试List头部插入元素的效率---------------*/

    /**
     * 测试在ArrayList的头部插入元素的效率
     * testAddFirstArrayList 花费：107 ms
     */
    @Test
    public void testAddFirstArrayList() {
        list = new ArrayList();
        testAddFirst("testAddFirstArrayList");
    }

    /**
     * 测试在Vector的头部插入元素的效率
     * testAddFirstVector 花费：108 ms
     */
    @Test
    public void testAddFirstVector() {
        list = new Vector();
        testAddFirst("testAddFirstVector");
    }

    /**
     * 测试在LinkedList的头部插入元素的效率
     * testAddFirstLinkedList 花费：7 ms
     */
    @Test
    public void testAddFirstLinkedList() {
        list = new LinkedList();
        testAddFirst("testAddFirstLinkedList");
    }

    /* -------------- 测试List尾部删除元素的效率---------------*/

    /**
     * 测试在ArrayList的尾部删除元素的效率
     * testDeleteTailArrayList 花费：4 ms
     */
    @Test
    public void testDeleteTailArrayList() {
        list = new ArrayList();
        testDelTail("testDeleteTailArrayList");
    }

    /**
     * 测试在Vector的尾部删除元素的效率
     * testDeleteTailVector 花费：6 ms
     */
    @Test
    public void testDeleteTailVector() {
        list = new Vector();
        testDelTail("testDeleteTailVector");
    }

    /**
     * 测试在LinkedList的尾部删除元素的效率
     * testDeleteTailLinkedList 花费：5 ms
     */
    @Test
    public void testDeleteTailLinkedList() {
        list = new LinkedList();
        testDelTail("testDeleteTailLinkedList");
    }

    /* -------------- 测试List头部删除元素的效率---------------*/

    /**
     * 测试在ArrayList的头部删除元素的效率
     * testDeleteFirstArrayList 花费：448 ms
     */
    @Test
    public void testDeleteFirstArrayList() {
        list = new ArrayList();
        testDelFirst("testDeleteFirstArrayList");
    }

    /**
     * 测试在Vector的头部删除元素的效率
     * testDeleteFirstVector 花费：448 ms
     */
    @Test
    public void testDeleteFirstVector() {
        list = new Vector();
        testDelFirst("testDeleteFirstVector");
    }

    /**
     * 测试在LinkedList的头部删除元素的效率
     * testDeleteFirstLinkedList 花费：5 ms
     */
    @Test
    public void testDeleteFirstLinkedList() {
        list = new LinkedList();
        testDelFirst("testDeleteFirstLinkedList");
    }

    /* -------------- 测试List中部删除元素的效率---------------*/

    /**
     * 测试在LinkedList的中部删除元素的效率
     * testDeleteMiddleLinkedList 花费：3234 ms
     */
    @Test
    public void testDeleteMiddleLinkedList() {
        list = new LinkedList();
        testDelMiddle("testDeleteMiddleLinkedList");
    }

    /**
     * 测试在ArrayList的中部删除元素的效率
     * testDeleteMiddleArrayList 花费：189 ms
     */
    @Test
    public void testDeleteMiddleArrayList() {
        list = new ArrayList();
        testDelMiddle("testDeleteMiddleArrayList");
    }

}
