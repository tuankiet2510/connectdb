package connect;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
@WebServlet("/test-sql-connection")
public class TestSqlConnectionServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        Connection conn = null;
        String jdbcUrl = "jdbc:sqlserver://localhost;"
    + "databaseName=quanlybanram;"
    + "socketFactoryClass=com.google.cloud.sql.sqlserver.SocketFactory;"
    + "ipTypes=PRIVATE;"
    + "socketFactoryConstructorArg=java-cloud-app-407108:asia-east2:banram;"
    + "user=sqlserver;"
    + "password=12345;"
    + "encrypt=true;"
    + "trustServerCertificate=true"; // Added this line

        try {
            // Thực hiện kết nối SQL Server
           
        
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        conn = DriverManager.getConnection(jdbcUrl);
            // Kiểm tra kết nối thành công
            if (conn != null) {
                out.println("Connect succes!");
                conn.close(); // Đóng kết nối
            } else {
                out.println("Failed");
            }
        } catch (SQLException | ClassNotFoundException e) {
            out.println("Failed" + e.getMessage());
        }
    }
}