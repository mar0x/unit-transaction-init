package nginx.unit;

import com.atomikos.icatch.jta.UserTransactionImp;
import java.util.Set;
import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import org.eclipse.jetty.plus.jndi.Transaction;

public class TransactionInit implements ServletContainerInitializer
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
    public void onStartup(Set<java.lang.Class<?>> c, ServletContext ctx)
               throws ServletException
    {
    }
}
