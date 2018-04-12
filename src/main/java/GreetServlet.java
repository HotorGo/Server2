import freemarker.cache.FileTemplateLoader;
import freemarker.core.HTMLOutputFormat;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GreetServlet extends HttpServlet  {
    private Configuration conf = new Configuration(  Configuration.VERSION_2_3_28);


    public GreetServlet() throws IOException {
        conf.setDefaultEncoding("UTF-8");
        conf.setTemplateLoader(new FileTemplateLoader(new File(".")));
        conf.setOutputFormat(HTMLOutputFormat.INSTANCE);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        resp.setCharacterEncoding("UTF-8");
        List<String> friends = new ArrayList<>();
        friends.add("!!!");
        friends.add("???");
        Template template = conf.getTemplate("greet.html");
        Map<String, Object> date = new HashMap<>();
        date.put("user", username);
        date.put("friends" , friends);
        try {
            template.process(date, resp.getWriter());
        } catch (TemplateException e) {
            throw new ServletException(e);
        }
    }
}
