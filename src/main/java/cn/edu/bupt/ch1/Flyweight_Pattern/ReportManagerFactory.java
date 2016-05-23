package cn.edu.bupt.ch1.Flyweight_Pattern;

import java.util.HashMap;
import java.util.Map;

/**
 * 享元工厂：用以创建具体享元类，维护相同的享元对象
 * 它保证相同的享元对象可以被系统共享。即，其内部使用了类似单例模式的算法，当请求对象已经存在时，直接返回对象，不存在时，再创建对象。
 * <p>
 * Created by FirenzesEagle on 2016/5/16 0016.
 * Email:liumingbo2008@gmail.com
 */
public class ReportManagerFactory {

    Map<String, IReportManager> financialReportManager = new HashMap<String, IReportManager>();
    Map<String, IReportManager> employeeReportManager = new HashMap<String, IReportManager>();

    /**
     * 通过租户的ID获取享元
     *
     * @param tenantId 租户ID
     * @return 享元对象
     */
    IReportManager getFinancialReportManager(String tenantId) {
        IReportManager reportManager = financialReportManager.get(tenantId);
        if (reportManager == null) {
            reportManager = new FinancialReportManager(tenantId);
            financialReportManager.put(tenantId, reportManager);    //维护已创建的享元对象
        }
        return reportManager;
    }

    /**
     * 通过租户的ID获取享元
     *
     * @param tenantId 租户ID
     * @return 享元对象
     */
    IReportManager getEmployeeReportManager(String tenantId) {
        IReportManager reportManager = employeeReportManager.get(tenantId);
        if (reportManager == null) {
            reportManager = new EmployeeReportManager(tenantId);
            employeeReportManager.put(tenantId, reportManager);    //维护已创建的享元对象
        }
        return reportManager;
    }

}
