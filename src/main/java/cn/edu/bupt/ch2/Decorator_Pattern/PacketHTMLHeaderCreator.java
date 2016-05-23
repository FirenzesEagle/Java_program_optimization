package cn.edu.bupt.ch2.Decorator_Pattern;

/**
 * 具体装饰者：具体实现装饰的业务逻辑，即实现了被分离的各个增强功能点。
 * 各个具体装饰者是可以相互叠加的，从而可以构成一个功能更加强大的组件对象。
 * 该装饰者负责对核心发布的内容进行HTML格式化操作
 * <p>
 * Created by FirenzesEagle on 2016/5/17 0017.
 * Email:liumingbo2008@gmail.com
 */
public class PacketHTMLHeaderCreator extends PacketDecorator {

    public PacketHTMLHeaderCreator(IPacketCreator component) {
        super(component);
    }

    /**
     * 将给定数据封装成HTML
     *
     * @return result string
     */
    @Override
    public String handleContent() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("<html>");
        stringBuffer.append("<body>");
        stringBuffer.append(component.handleContent());
        stringBuffer.append("</body>");
        stringBuffer.append("</html>\n");
        return stringBuffer.toString();
    }
}
