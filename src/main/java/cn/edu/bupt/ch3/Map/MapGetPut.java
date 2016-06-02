package cn.edu.bupt.ch3.Map;

import org.junit.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * Created by FirenzesEagle on 2016/6/1 0001.
 * Email:liumingbo2008@gmail.com
 */
public class MapGetPut {

    Map map;
    final int CIRCLE = 100000;

    protected void testGet(String funcName) {
        for (int i = 0; i < CIRCLE; i++) {
            String key = Double.toString(Math.random());
            map.put(key, key);
        }
        long beginTime = System.currentTimeMillis();
        for (int i = 0; i < CIRCLE; i++) {
            String key = Double.toString(Math.random());
            map.get(key);
        }
        long endTime = System.currentTimeMillis();
        System.out.println(funcName + ": " + (endTime - beginTime) + " ms");
    }

    /**
     * testHashtableGet: 69 ms
     */
    @Test
    public void testHashtableGet() {
        map = new Hashtable();
        testGet("testHashtableGet");
    }

    /**
     * testSyncHashMapGet: 41 ms
     */
    @Test
    public void testSyncHashMapGet() {
        map = Collections.synchronizedMap(new HashMap());
        testGet("testSyncHashMapGet");
    }

    /**
     * testHashMapGet: 57 ms
     */
    @Test
    public void testHashMapGet() {
        map = new HashMap();
        testGet("testHashMapGet");
    }

}
