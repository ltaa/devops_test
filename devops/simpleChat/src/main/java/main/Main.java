package main;

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import webSocketService.WebSocketChatServlet;

/**
 * Created by jedi on 19.01.16.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.addServlet(new ServletHolder (new WebSocketChatServlet()), "/chat");

        ResourceHandler resource = new ResourceHandler();
        resource.setDirectoriesListed(true);
//        resource.setResourceBase(ResourceHandler.class.getClassLoader().getResource("public_html").toExternalForm());
        resource.setResourceBase("public_html");

        HandlerList handlerList = new HandlerList();

        handlerList.setHandlers(new Handler[] {resource, context});
        System.out.print("Server started");

        Server server = new Server(8080);
        server.setHandler(handlerList);

        server.join();
        server.start();

    }
}
