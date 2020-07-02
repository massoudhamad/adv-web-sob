import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CookiesServlet")
public class CookiesServlet extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        Cookie firstName = new Cookie("first_name", request.getParameter("first_name"));
        Cookie lastName = new Cookie("last_name", request.getParameter("last_name"));
        firstName.setMaxAge(60);
        lastName.setMaxAge(60);
        response.addCookie(firstName);
        response.addCookie(lastName);
        //Set Session
        HttpSession session=request.getSession();
        session.setAttribute("name",lastName);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String title = "Setting Cookies Example";
        String docType =
                "<!doctype html public \"-//w3c//dtd html 4.0 " +
                        "transitional//en\">\n";
        out.println(docType +
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body bgcolor=\"#f0f0f0\">\n" +
                "<h1 align=\"center\">" + title + "</h1>\n" +
                "<ul>\n" +
                " <li><b>First Name</b>: "
                + request.getParameter("first_name") + "\n" +
                " <li><b>Last Name</b>: "
                + request.getParameter("last_name") + "\n" +
                "</ul>\n");

                out.println("<a href='ViewCookiesServlet'>View Cookies</a>");

                out.println("</body></html>");
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }
}
