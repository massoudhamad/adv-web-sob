import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "DBServlet")
public class DBServlet extends HttpServlet {
    static final String JDBC_DRIVER="com.mysql.jdbc.Driver";
    static final String DB_URL="jdbc:mysql://localhost:3306/vit";

    // Database credentials
    static final String USER = "root";
    static final String PASS = "";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String title = "Database Result";
        String docType =
                "<!DOCTYPE HTML\n";
        out.println(docType +
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body bgcolor=\"#f0f0f0\">\n" +
                "<h1 align=\"center\">" + title + "</h1>\n");
        try {
// Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
// Open a connection
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
// Execute SQL query
            Statement stmt = conn.createStatement();
            String sql;
            sql = "insert into emp values(4,40)";
            int x = stmt.executeUpdate(sql);
            sql = "SELECT * from emp";
            ResultSet rs = stmt.executeQuery(sql);
// Extract data from result set
            while (rs.next()) {
//Retrieve by column name
                int id = rs.getInt("id");
                int age = rs.getInt("age");
                //Display values
                out.println("ID: " + id + "<br>");
                out.println(" Age: " + age + "<br>");
            }

            out.println("</body></html>");
// Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
//Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
//Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
        } //end try
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }
}
