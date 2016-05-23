package cn.edu.bupt.ch2.Decorator_Pattern;

/**
 * 共生成3个对象实例，作为核心组件的PacketBodyCreator最先被构造，其次是PacketHTMLHeaderCreator，最后才是PacketHTTPHeaderCreator
 *
 * Created by FirenzesEagle on 2016/5/17 0017.
 * Email:liumingbo2008@gmail.com
 */
public class Main {

    public static void main(String[] args) {
        IPacketCreator iPacketCreator = new PacketHTTPHeaderCreator(new PacketHTMLHeaderCreator(new PacketBodyCreator()));
        System.out.println(iPacketCreator.handleContent());
    }

}
