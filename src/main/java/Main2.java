import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.DefaultServlet;
import org.eclipse.jetty.servlet.ServletContextHandler;

public class Main2 {


    public static void main(String[] args) throws Exception {
        Server server = new Server(88);
        ServletContextHandler handler = new ServletContextHandler();
        server.setHandler(handler);
        handler.addServlet(DefaultServlet.class , "/");
        handler.setResourceBase(".");
        handler.addServlet(GreetServlet.class , "/Great.html");
        server.start();

    }
}
