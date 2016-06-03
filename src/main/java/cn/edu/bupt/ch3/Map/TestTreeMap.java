package cn.edu.bupt.ch3.Map;

import org.junit.Test;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * 基于红黑树实现的有序Map，根据元素的key进行排序，可以使用两种方法指定排序方式：
 * 1、在TreeMap的构造函数中注入一个Comparator
 * 2、使用一个实现了Comparable接口的key
 *
 * Created by FirenzesEagle on 2016/6/1 0001.
 * Email:liumingbo2008@gmail.com
 */
public class TestTreeMap {

    Map map;

    public static class Student implements Comparable<Student> {
        public Student(String name, int s) {
            this.name = name;
            this.score = s;
        }

        String name;
        int score;

        @Override
        public int compareTo(Student o) {
            if (o.score < this.score)
                return 1;
            else if (o.score > this.score)
                return -1;
            return 0;
        }

        @Override
        public String toString() {
            StringBuffer sb = new StringBuffer();
            sb.append("name:");
            sb.append(name);
            sb.append("  ");
            sb.append("score:");
            sb.append(score);
            return sb.toString();
        }
    }

    public static class StudentDetailInfo {
        Student s;

        public StudentDetailInfo(Student s) {
            this.s = s;
        }

        @Override
        public String toString() {
            return s.name + "'s detail information";
        }
    }

    /**
     * name:Cissy  score:68->Cissy's detail information
     * name:Billy  score:70->Billy's detail information
     * name:David  score:85->David's detail information
     * name:Kite  score:92->Kite's detail information
     */
    @Test
    public void testOrderKey() {
        map = new TreeMap();
        Student s1 = new Student("Billy", 70);
        Student s2 = new Student("David", 85);
        Student s3 = new Student("Kite", 92);
        Student s4 = new Student("Cissy", 68);
        map.put(s1, new StudentDetailInfo(s1));
        map.put(s3, new StudentDetailInfo(s3));
        map.put(s2, new StudentDetailInfo(s2));
        map.put(s4, new StudentDetailInfo(s4));

        for (Iterator iterator = map.keySet().iterator(); iterator.hasNext(); ) {
            Student key = (Student) iterator.next();
            System.out.println(key + "->" + map.get(key));
        }
    }

    /**
     * name:Cissy  score:68->Cissy's detail information
     * name:Billy  score:70->Billy's detail information
     * subMap end
     * name:Cissy  score:68->Cissy's detail information
     * headMap end
     * name:Billy  score:70->Billy's detail information
     * name:David  score:85->David's detail information
     * name:Kite  score:92->Kite's detail information
     * tailMap end
     */
    @Test
    public void testSubMap() {
        map = new TreeMap();
        Student s1 = new Student("Billy", 70);
        Student s2 = new Student("David", 85);
        Student s3 = new Student("Kite", 92);
        Student s4 = new Student("Cissy", 68);
        map.put(s1, new StudentDetailInfo(s1));
        map.put(s3, new StudentDetailInfo(s3));
        map.put(s2, new StudentDetailInfo(s2));
        map.put(s4, new StudentDetailInfo(s4));

        // 筛选出成绩介于Cissy和David之间的所有学生
        Map subMap = ((TreeMap) map).subMap(s4, s2);
        for (Iterator iterator = subMap.keySet().iterator(); iterator.hasNext(); ) {
            Student key = (Student) iterator.next();
            System.out.println(key + "->" + subMap.get(key));
        }
        System.out.println("subMap end");

        // 筛选出成绩低于Billy的学生
        subMap = ((TreeMap) map).headMap(s1);
        for (Iterator iterator = subMap.keySet().iterator(); iterator.hasNext(); ) {
            Student key = (Student) iterator.next();
            System.out.println(key + "->" + subMap.get(key));
        }

        System.out.println("headMap end");

        // 筛选出成绩大于等于Billy的学生
        subMap = ((TreeMap) map).tailMap(s1);
        for (Iterator iterator = subMap.keySet().iterator(); iterator.hasNext(); ) {
            Student key = (Student) iterator.next();
            System.out.println(key + "->" + subMap.get(key));
        }
        System.out.println("tailMap end");
    }

}
