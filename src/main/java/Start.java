import handler.HelloWorldHandler;
import org.eclipse.jetty.server.Server;

/**
 * Created by Anthony on 22/06/2015.
 */
public class Start {

    public static void main(String[] args) throws Exception {

        Server server = new Server(8081);
        server.setHandler(new HelloWorldHandler());

        server.start();
        server.join();

    }
}
