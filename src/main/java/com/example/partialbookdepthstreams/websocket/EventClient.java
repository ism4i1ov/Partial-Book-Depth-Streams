package com.example.partialbookdepthstreams.websocket;

import com.example.partialbookdepthstreams.config.ApplicationConfiguration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.socket.WebSocketHttpHeaders;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;

import javax.annotation.PostConstruct;
import java.io.IOException;

@Service
public class EventClient {

    private final EventHandler eventHandler;

    public EventClient(EventHandler eventHandler) {
        this.eventHandler = eventHandler;
    }

    @PostConstruct
    public void init() throws IOException {
        StandardWebSocketClient socketClient = new StandardWebSocketClient();
        WebSocketSession webSocketSession = null;
        WebSocketHttpHeaders webSocketHttpHeaders = new WebSocketHttpHeaders();
        try {
            ListenableFuture<WebSocketSession> webSocketSessionListenableFuture =
                    socketClient.doHandshake(eventHandler, ApplicationConfiguration.getBinanceSocketUrl());
            webSocketSession = webSocketSessionListenableFuture.get();
            webSocketSession.setTextMessageSizeLimit(1024 * 1024);
            webSocketSession.setBinaryMessageSizeLimit(1024 * 1024);
            System.err.println("Is open = " + webSocketSession.isOpen());
        } catch (Exception exception) {
            if (webSocketSession != null) {
                webSocketSession.close();
            }
            exception.printStackTrace();
        }
    }
}
