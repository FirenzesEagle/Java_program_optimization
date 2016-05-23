package cn.edu.bupt.ch2.Buffer;

import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

import java.io.Serializable;

/**
 * EHCache工具类
 * <p>
 * Created by FirenzesEagle on 2016/5/19 0019.
 * Email:liumingbo2008@gmail.com
 */
public class EHCacheUtil {

    static CacheManager manager = null;
    static String configFilePath = "ehcache.xml";

    static {
        manager = CacheManager.create(EHCacheUtil.class.getClassLoader().getResourceAsStream(configFilePath));
    }

    public static void put(String cacheName, Serializable key, Serializable value) {
        manager.getCache(cacheName).put(new Element(key, value));
    }

    public static Serializable get(String cacheName, Serializable key) {
        Element element = manager.getCache(cacheName).get(key);
        if (element == null) return null;
        return element.getValue();

    }

    public static void clearCache(String cacheName) {
        manager.getCache(cacheName).removeAll();
    }

    public static void remove(String cacheName, Serializable key) {
        manager.getCache(cacheName).remove(key);
    }

}
