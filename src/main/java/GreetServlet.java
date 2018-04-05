import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GreetServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title> " + username  + "</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<h1> Привет  " + username + " !!! </h1>\n<a href=\"/\"> На главную </a>" +
                "</body>\n" +
                "</html>");
    }
}
