package com.afam.cocodeapi.Controllers;

import com.afam.cocodeapi.Services.WebSocketService;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketController {

    private final WebSocketService webSocketService;

    public WebSocketController(WebSocketService webSocketService) {
        this.webSocketService = webSocketService;
    }

    @MessageMapping("/userinput")
    @SendTo("/topic/codeupdate")
    public String handleUserInput(String userInput) {
        return webSocketService.handleUserInput(userInput);
    }
}
