package com.afam.cocodeapi.Controllers;

import com.afam.cocodeapi.Services.WebSocketService;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketController {

    private final WebSocketService webSocketService;

    public WebSocketController(WebSocketService webSocketService) {
        this.webSocketService = webSocketService;
    }

    @MessageMapping("/{roomId}/userinput")
    @SendTo("/codespace/{roomId}/codeupdate")
    public String handleUserInput(@DestinationVariable String roomId, @Payload String userInput) {
        return webSocketService.handleUserInput(userInput);
    }
}
