package cn.edu.bupt.ch3.Collection_Visit_Tuning;

import org.junit.Test;

import java.util.List;
import java.util.Vector;

/**
 * 提取重复操作，减少方法调用也是提升效率的一种方法
 *
 * Created by FirenzesEagle on 2016/6/3 0003.
 * Email:liumingbo2008@gmail.com
 */
public class TestCollectionVisitTuning extends Vector {
    static List collection = new Vector();

    static {
        collection.add("north65");
        collection.add("west20");
        collection.add("east30");
        collection.add("south40");
        collection.add("west33");
        collection.add("south20");
        collection.add("north10");
        collection.add("east9");

    }

    public TestCollectionVisitTuning() {
        this.add("north65");
        this.add("west20");
        this.add("east30");
        this.add("south40");
        this.add("west33");
        this.add("south20");
        this.add("north10");
        this.add("east9");
    }

    /**
     * 20695
     */
    @Test
    public void testCount() {
        long beginTime = System.nanoTime();
        int count = 0;
        for (int i = 0; i < collection.size(); i++) {
            if ((((String) collection.get(i)).indexOf("north") != -1)
                    || (((String) collection.get(i)).indexOf("west") != -1)
                    || (((String) collection.get(i)).indexOf("south") != -1))
                count++;
        }
        long endTime = System.nanoTime();
        System.out.println(endTime - beginTime);
    }

    /**
     * 20439
     */
    @Test
    public void testCount1() {
        long beginTime = System.nanoTime();
        int count = 0;
        int colSize = collection.size();    //提取每次循环中相同的操作
        for (int i = 0; i < colSize; i++) {
            if ((((String) collection.get(i)).indexOf("north") != -1)
                    || (((String) collection.get(i)).indexOf("west") != -1)
                    || (((String) collection.get(i)).indexOf("south") != -1))
                count++;
        }
        long endTime = System.nanoTime();
        System.out.println(endTime - beginTime);
    }

    /**
     * 19417
     */
    @Test
    public void testCount2() {
        long beginTime = System.nanoTime();
        int count = 0;
        String s = null;
        int colSize = collection.size();
        for (int i = 0; i < colSize; i++) {
            //每次访问相同的元素，在此提取
            if (((s = (String) collection.get(i)).indexOf("north") != -1)
                    || (s.indexOf("west") != -1)
                    || (s.indexOf("south") != -1))
                count++;
        }
        long endTime = System.nanoTime();
        System.out.println(endTime - beginTime);
    }

    /**
     * 15585
     */
    @Test
    public void testCount2_5() {
        long beginTime = System.nanoTime();
        int count = 0;
        String s = null;
        int colSize = this.elementCount;    //尽可能避免调用原生接口，直接访问属性
        for (int i = 0; i < colSize; i++) {
            if (((s = (String) this.get(i)).indexOf("north") != -1)
                    || (s.indexOf("west") != -1)
                    || (s.indexOf("south") != -1))
                count++;
        }
        long endTime = System.nanoTime();
        System.out.println(endTime - beginTime);
    }

    /**
     * 13286
     */
    @Test
    public void testCount3() {
        long beginTime = System.nanoTime();
        int count = 0;
        String s = null;
        int colSize = this.elementCount;
        for (int i = 0; i < colSize; i++) {
            if (((s = (String) elementData[i]).indexOf("north") != -1)  //直接访问属性，用elementData[i]代替get(i)
                    || (s.indexOf("west") != -1)
                    || (s.indexOf("south") != -1))
                count++;
        }
        long endTime = System.nanoTime();
        System.out.println(endTime - beginTime);
    }

}

