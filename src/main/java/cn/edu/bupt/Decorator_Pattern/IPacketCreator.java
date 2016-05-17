package cn.edu.bupt.Decorator_Pattern;

/**
 * 组件接口：组件接口是装饰者和被装饰者的超类或者接口。
 * 它定义了被装饰者的核心功能和装饰者需要加强的功能点，例如：handleContent
 *
 * Created by FirenzesEagle on 2016/5/16 0016.
 * Email:liumingbo2008@gmail.com
 */
public interface IPacketCreator {

    public String handleContent();  //用于内容处理

}
