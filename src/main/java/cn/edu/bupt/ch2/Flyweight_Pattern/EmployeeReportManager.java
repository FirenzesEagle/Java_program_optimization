package cn.edu.bupt.ch2.Flyweight_Pattern;

/**
 * 具体享元类：实现抽象享元类的接口，完成某一具体逻辑
 *
 * 员工个人信息报表
 *
 * Created by FirenzesEagle on 2016/5/16 0016.
 * Email:liumingbo2008@gmail.com
 */
public class EmployeeReportManager implements IReportManager {

    protected String tenantId = null;

    public EmployeeReportManager(String tenantId){
        this.tenantId = tenantId;
    }

    @Override
    public String createReport() {
        return "This is a employee report";
    }
}
