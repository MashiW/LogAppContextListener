package contextlogin;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Login extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response) throws IOException, ServletException {

        response.setContentType("text/html");
        Database db = (Database) getServletContext().getAttribute("db");
        PrintWriter out = response.getWriter();

        String username = request.getParameter("txtUn"); // get the name entered by user's input
        String password = request.getParameter("txtPw"); //get the password entered by user's input

//sql - query for the data extraction from tbl_user and compare with user's input name and password
        //password is compared after hashing
        String sql = "select usrName, usrPass from tbl_user where usrName=\"" + username + "\" and usrPass=md5(\"" + password + "\");";
        ResultSet rs;
        try {
            Connection con = Database.getConn();
            Statement st = con.createStatement();
            rs = st.executeQuery(sql);

            if (rs.first()) {
                response.sendRedirect("success.html");
            } else {
                response.sendRedirect("error.html");
            }
        } catch (SQLException e) {
        }
    }

}
