package cn.edu.bupt.ch3.Map;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by FirenzesEagle on 2016/5/27 0027.
 * Email:liumingbo2008@gmail.com
 */
public class MapHashcodeTest {

    public static class GoodHash {
        double d;

        public GoodHash(double d) {
            this.d = d;
        }
    }

    public static class BadHash {
        double d;

        public BadHash(double d) {
            this.d = d;
        }

        @Override
        public int hashCode() {
            return 1;
        }
    }

    Map map;
    final int CIRCLE = 10000;

    /**
     * testGetGoodHash: 3 ms
     */
    @Test
    public void testGetGoodHash() {
        map = new HashMap();
        for (int i = 0; i < CIRCLE; i++) {
            GoodHash key = new GoodHash(Math.random());
            map.put(key, key);
        }
        long beginTime = System.currentTimeMillis();
        for (int i = 0; i < CIRCLE; i++) {
            GoodHash key = new GoodHash(Math.random());
            map.get(key);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("testGetGoodHash" + ": " + (endTime - beginTime) + " ms");
    }

    /**
     * 此时的操作等于链表遍历
     * testGetBadHash: 1540 ms
     */
    @Test
    public void testGetBadHash() {
        map = new HashMap();
        for (int i = 0; i < CIRCLE; i++) {
            BadHash key = new BadHash(Math.random());
            map.put(key, key);
        }
        long beginTime = System.currentTimeMillis();
        for (int i = 0; i < CIRCLE; i++) {
            BadHash key = new BadHash(Math.random());
            map.get(key);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("testGetBadHash" + ": " + (endTime - beginTime) + " ms");
    }

}
