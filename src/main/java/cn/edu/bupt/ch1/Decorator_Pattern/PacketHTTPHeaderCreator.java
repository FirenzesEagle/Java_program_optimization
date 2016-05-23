package cn.edu.bupt.ch1.Decorator_Pattern;

/**
 * 具体装饰者：具体实现装饰的业务逻辑，即实现了被分离的各个增强功能点。
 * 各个具体装饰者是可以相互叠加的，从而可以构成一个功能更加强大的组件对象。
 * 该装饰者负责完成数据包HTTP头部的处理。
 * <p>
 * Created by FirenzesEagle on 2016/5/17 0017.
 * Email:liumingbo2008@gmail.com
 */
public class PacketHTTPHeaderCreator extends PacketDecorator {

    public PacketHTTPHeaderCreator(IPacketCreator component) {
        super(component);
    }

    /**
     * 对给定数据加上HTTP头部信息
     *
     * @return result string
     */
    @Override
    public String handleContent() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Cache-Control:no-cache\n");
        stringBuffer.append("Date:Tue, 17 May 2016 07:17:01 GMT\n");
        stringBuffer.append(component.handleContent());
        return stringBuffer.toString();
    }
}
