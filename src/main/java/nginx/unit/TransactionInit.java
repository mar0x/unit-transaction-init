package nginx.unit;

import com.atomikos.icatch.jta.UserTransactionImp;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRegistration;

import org.eclipse.jetty.plus.jndi.Transaction;

public class TransactionInit implements ServletContextListener
{
    static {
        try {
            UserTransactionImp ti = new UserTransactionImp();
            Transaction tr = new Transaction(ti);

            tr.bindToENC();
        } catch (Exception e) {
        }
    }

    public TransactionInit()
    {
    }

    @Override
    public void contextInitialized(ServletContextEvent sce)
    {
        ((ServletRegistration.Dynamic) sce.getServletContext().getServletRegistration("jsp")).setLoadOnStartup(1);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce)
    {
    }
}
