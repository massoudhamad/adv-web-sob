import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "DBServletLecture")
public class DBServletLecture extends HttpServlet {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL="jdbc:mysql://localhost:3306/vit";
    static final String DB_USER="root";
    static final String DB_PASS="";
    void processRequest(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String title = "Database Result";
        String docType =
                "<!DOCTYPE html\n";
        out.println(docType +
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body bgcolor=\"#f0f0f0\">\n" +
                "<h1 align=\"center\">" + title + "</h1>\n");
        try
        {
            //register driver
            Class.forName(JDBC_DRIVER);
            //open connection
            Connection conn = DriverManager.getConnection(DB_URL,DB_USER,DB_PASS);
            //SQL Statements
            Statement stmt = conn.createStatement();
            String sqlinsert="INSERT INTO std_sob(id,age) VALUES(2,40)";
            int outi=stmt.executeUpdate(sqlinsert);
            String sql= "SELECT * FROM std_sob";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next())
            {
                int id=rs.getInt("id");
                int age=rs.getInt("age");
                out.println("ID: " + id + "<br>");
                out.println(" Age: " + age + "<br>");
            }
            stmt.close();
            conn.close();
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally {
                //finally
        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        processRequest(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        processRequest(request,response);
    }

}
