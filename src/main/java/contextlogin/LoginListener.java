package contextlogin;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class LoginListener implements ServletContextListener {
    /**
     * coventntext listener class for database connection
     */

    public void contextInitialized(ServletContextEvent event) {

        ServletContext sc = event.getServletContext();

        String dburl = sc.getInitParameter("dburl");//  url of the database
        String dbUname = sc.getInitParameter("db_uname");// user name for database
        String dbPasswd = sc.getInitParameter("db_pswd");// password for the database
        String databse = sc.getInitParameter("database");//database name
        Database db = new Database(dburl + databse, dbUname, dbPasswd);
        sc.setAttribute("db", db);
    }

    public void contextDestroyed(ServletContextEvent arg1) {

    }

}