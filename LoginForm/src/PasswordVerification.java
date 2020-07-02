import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "PasswordVerification")
public class PasswordVerification extends HttpServlet {
    String [][]user_pass ={{"xxx","111"},{"yyy","222"},{"zzz","333"}};
    protected void processRequest(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
    {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<title>Authenticated Users</title>");
        out.println("<body>");
        String usr = request.getParameter("username");
        String pd = request.getParameter("pwd");
        int i;
        for(i=0;i<user_pass.length;i++)
        {
            if(usr.equals(user_pass[i][0]) && pd.equals(user_pass[i][1]))
            {
                out.println("authenticated user");
                break;
            }
        }
        if(i==user_pass.length)
            out.println("invalid username & password");
        out.println("</body>");
        out.println("</html>");
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }
}
