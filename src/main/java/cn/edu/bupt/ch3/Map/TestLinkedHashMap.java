package cn.edu.bupt.ch3.Map;

import org.junit.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 有序的HashMap，可以提供两种类型的顺序：
 * 1、元素插入时的顺序   false
 * 2、最近访问顺序 true
 * <p>
 * Created by FirenzesEagle on 2016/6/1 0001.
 * Email:liumingbo2008@gmail.com
 */
public class TestLinkedHashMap {

    Map<String, String> map;

    public void testOutputMap(String funcName) {
        map.put("1", "aa");
        map.put("2", "bb");
        map.put("3", "cc");
        map.put("4", "dd");
        map.get("3");
        for (Iterator iterator = map.keySet().iterator(); iterator.hasNext(); ) {
            String name = (String) iterator.next();
            System.out.println(name + "->" + map.get(name));
        }
    }

    /**
     * 因为LinkedHashMap的get()方法会修改元素的顺序，在迭代器中不能对集合的结构进行修改，
     * 所以会抛出 java.util.ConcurrentModificationException 异常
     */
    @Test
    public void testLinkedHashMap() {
        map = new LinkedHashMap<String, String>(16, 0.75f, true);
        testOutputMap("LinkedHashMap_false");
    }

    /**
     * 1->aa
     * 2->bb
     * 3->cc
     * 4->dd
     */
    @Test
    public void testHashMap() {
        map = new HashMap<String, String>();
        testOutputMap("testHashMap");
    }

}
