package cn.edu.bupt.Decorator_Pattern;

/**
 * 具体组件：具体组件实现了组件接口的核心方法，完成了某一个具体的业务逻辑，它是被装饰的对象
 *
 * 本例中用于返回数据包的核心数据
 *
 * Created by FirenzesEagle on 2016/5/16 0016.
 * Email:liumingbo2008@gmail.com
 */
public class PacketBodyCreator implements IPacketCreator {
    @Override
    public String handleContent() {
        return "Content of Packet"; //构造核心数据，但不包括格式
    }
}
