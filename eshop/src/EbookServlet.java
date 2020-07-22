import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "EbookServlet")
public class EbookServlet extends HttpServlet {
    protected void processRequest(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><title>Query Response</title></head>");
        out.println("<body>");
        try
        {
            //register driver
            //Class.forName("com.mysql.jdbc.Driver");
            //Connection conn = DriverManager.getConnection();
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebook","root", "xxxx");
            String author = request.getParameter("author");
            String price = request.getParameter("price");

            String sqlqry = "SELECT id,title,price FROM books where author = "+author+" and price > "+price+" order by qty";

            Statement stmt = conn.createStatement();
            ResultSet rset = stmt.executeQuery(sqlqry);
            while(rset.next()) {
                String author1 = rset.getString("author");
                String title = rset.getString("title");
                double price1 = rset.getDouble("price");
                int qty = rset.getInt("qty");

                out.println();
            }
        }
        catch(Exception ex)
        {

        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
