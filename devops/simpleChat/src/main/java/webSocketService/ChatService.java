package webSocketService;

//import java.util.Collections;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by jedi on 19.01.16.
 */
public class ChatService {
    Set<ChatWebSocket> webSockets;
    ChatService() {
        this.webSockets = Collections.newSetFromMap(new ConcurrentHashMap<>());
    }

    public void addWebSocket(ChatWebSocket ws) {
        this.webSockets.add(ws);
    }


    public  void sendMessage(String message) {
        for(ChatWebSocket ws: webSockets) {
            ws.sendString(message);
        }

    }


    public void removeWebSocket(ChatWebSocket ws) {
        this.webSockets.remove(ws);
    }

}
