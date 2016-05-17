package cn.edu.bupt.Decorator_Pattern;

/**
 * 装饰者：实现组件接口，并持有一个具体的被装饰者对象
 * 它负责告诉子类，其核心业务逻辑应该全权委托component完成，自己仅仅是做增强处理
 *
 * Created by FirenzesEagle on 2016/5/16 0016.
 * Email:liumingbo2008@gmail.com
 */
public abstract class PacketDecorator implements  IPacketCreator{

    IPacketCreator component;

    public PacketDecorator(IPacketCreator component){
        this.component = component;
    }

}
