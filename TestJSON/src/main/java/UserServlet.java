import com.example.json.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import com.google.gson.Gson;


@WebServlet(name = "UserServlet")
public class UserServlet extends HttpServlet {
    private static final long serialVersionUID = 1;

    private Gson gson = new Gson();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        User user = new User();
        user.setId(100);
        user.setFirstName("Ramesh");
        user.setLastName("Fadatare");
        user.setCreatedAt(new Date());
        user.setCreatedBy("Admin");
        user.setEmailId("ramesh@gmail.com");
        user.setUpdatedAt(new Date());
        user.setUpdatedby("Admin");

        String userJsonString = this.gson.toJson(user);

        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.print(userJsonString);
        out.flush();
    }
}
