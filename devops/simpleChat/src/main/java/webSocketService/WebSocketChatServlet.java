package webSocketService;

import org.eclipse.jetty.websocket.servlet.WebSocketServlet;
import org.eclipse.jetty.websocket.servlet.WebSocketServletFactory;

import javax.servlet.annotation.WebServlet;

/**
 * Created by jedi on 19.01.16.
 */

@WebServlet(name = "WebSocketChatServlet", urlPatterns = "/chat")
public class WebSocketChatServlet extends WebSocketServlet {
    private final int LOGOUT_TIME = 1000 * 60 * 10;
    private final ChatService chatService;
    public WebSocketChatServlet() {
        this.chatService = new ChatService();
    }

    @Override
    public void configure(WebSocketServletFactory factory) {
        factory.getPolicy().setIdleTimeout(LOGOUT_TIME);
        factory.setCreator((req, resp) -> new ChatWebSocket(chatService));
    }
}
