package net.tihz.jetty;

import net.tihz.jetty.servlet.DefaultServlet;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class Start {

    public static void main(String[] args) throws Exception {

        Server server = new Server();


        ServerConnector connector8081 = new ServerConnector(server);
        connector8081.setPort(8081);
        server.addConnector(connector8081);

        ServerConnector connector8082 = new ServerConnector(server);
        connector8082.setPort(8082);
        server.addConnector(connector8082);

        // Simple Jetty Handler
//        server.setHandler(new HelloWorldHandler());

        // Servlet handler
        ServletContextHandler servletHandler = new ServletContextHandler(ServletContextHandler.SESSIONS);
        servletHandler.setContextPath("/");
        server.setHandler(servletHandler);

        DefaultServlet servlet = new DefaultServlet();
        servletHandler.addServlet(new ServletHolder(servlet), "/*");



        server.start();
        server.join();
    }
}
