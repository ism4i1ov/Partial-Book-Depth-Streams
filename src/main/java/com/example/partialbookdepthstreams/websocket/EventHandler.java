package com.example.partialbookdepthstreams.websocket;

import com.example.partialbookdepthstreams.dto.CommonResponse;
import com.example.partialbookdepthstreams.service.DepthService;
import com.google.gson.Gson;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component
public class EventHandler extends TextWebSocketHandler implements WebSocketHandler {

    private final DepthService depthService;

    public EventHandler(DepthService depthService) {
        this.depthService = depthService;
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        super.afterConnectionEstablished(session);
        System.err.println("Socket Connection = " + session);
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        CommonResponse commonResponse = new Gson().fromJson(message.getPayload(), CommonResponse.class);
        depthService.validationAndSave(commonResponse.getData());
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        System.err.println("Socket Closed = " + status);
        super.afterConnectionClosed(session, status);
    }
}
