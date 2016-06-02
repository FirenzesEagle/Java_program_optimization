package cn.edu.bupt.ch3.Map;

import java.util.Map;

/**
 * Created by FirenzesEagle on 2016/6/1 0001.
 * Email:liumingbo2008@gmail.com
 */
public class TestTreeMap {

    Map map;

    public static class Student implements Comparable<Student>{
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

}
