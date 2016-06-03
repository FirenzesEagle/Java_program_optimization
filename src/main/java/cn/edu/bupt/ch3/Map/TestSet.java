package cn.edu.bupt.ch3.Map;

import org.junit.Test;

import java.util.*;

/**
 * 所有类型Set的实现都只是对应的Map的一种封装而已
 *
 * Created by FirenzesEagle on 2016/6/3 0003.
 * Email:liumingbo2008@gmail.com
 */
public class TestSet {
    Set set;

    public void initSet() {
        set.add(100);
        set.add(10);
        set.add(4);
        set.add(33);
        set.add(9);
    }

    /**
     * testHashSet
     * 33
     * 100
     * 4
     * 9
     * 10
     */
    @Test
    public void testHashSet() {
        set = new HashSet();
        initSet();
        System.out.println("testHashSet");
        for (Iterator iterator = set.iterator(); iterator.hasNext(); ) {
            Integer key = (Integer) iterator.next();
            System.out.println(key);
        }
    }

    /**
     * 100
     * 10
     * 4
     * 33
     * 9
     */
    @Test
    public void testLinkedHashSet() {
        set = new LinkedHashSet();
        initSet();
        System.out.println("testLinkedHashSet");
        for (Iterator iterator = set.iterator(); iterator.hasNext(); ) {
            Integer key = (Integer) iterator.next();
            System.out.println(key);
        }
    }

    /**
     * testTreeSet
     * 4
     * 9
     * 10
     * 33
     * 100
     */
    @Test
    public void testTreeSet() {
        set = new TreeSet();
        initSet();
        System.out.println("testTreeSet");
        for (Iterator iterator = set.iterator(); iterator.hasNext(); ) {
            Integer key = (Integer) iterator.next();
            System.out.println(key);
        }
    }

}
