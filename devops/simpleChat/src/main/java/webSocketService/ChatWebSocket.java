package webSocketService;

import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketClose;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketConnect;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketMessage;
import org.eclipse.jetty.websocket.api.annotations.WebSocket;

import java.io.IOException;

/**
 * Created by jedi on 19.01.16.
 */
@WebSocket
public class ChatWebSocket {
    private final ChatService chatService;
    private Session session;
    public ChatWebSocket(ChatService chatService) {
        this.chatService = chatService;

    }

    @OnWebSocketConnect
    public void onConnect(Session session) {
        this.chatService.addWebSocket(this);
        this.session = session;
    }

    @OnWebSocketMessage
    public void onMessage(String message) {
        chatService.sendMessage(message);

    }

    public void sendString(String data) {
        try {
            session.getRemote().sendString(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }





    @OnWebSocketClose
    public void onClose (int statusCode, String reason) {
        this.chatService.removeWebSocket(this);
    }
}
