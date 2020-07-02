import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ViewCookiesServlet")
public class ViewCookiesServlet extends HttpServlet {
    public void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Cookie cookie = null;
        Cookie[] cookies = null;
// Get an array of Cookies associated with this domain
            cookies = request.getCookies();

        PrintWriter out = response.getWriter();
        String title = "Reading Cookies Example";
        String docType =
                "<!doctype html public \"-//w3c//dtd html 4.0 " +
                        "transitional//en\">\n";
        out.println(docType +
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body bgcolor=\"#f0f0f0\">\n" );
        if( cookies != null ){
            out.println("<h2> Found Cookies Name and Value</h2>");
            for (int i = 0; i < cookies.length; i++){
                cookie = cookies[i];
                out.print("Name : " + cookie.getName( ) + ", ");
                out.print("Value: " + cookie.getValue( )+" <br/>");

                HttpSession session=request.getSession(false);
                String n=(String)session.getAttribute("name");
                out.println(n);
            }
        }else{
            out.println(
                    "<h2>No cookies founds</h2>");
        }
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
