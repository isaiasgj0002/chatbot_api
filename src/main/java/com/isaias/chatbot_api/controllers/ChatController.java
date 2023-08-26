package com.isaias.chatbot_api.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ChatController {

     @PostMapping("/chatbot")
    public ResponseEntity<ChatResponse> chatbot(@RequestBody RequestBodyClass requestBody) {
        String receivedMessage = requestBody.getMessage();
        String responseMessage = processMessage(receivedMessage);
        ChatResponse response = new ChatResponse(responseMessage);
        return ResponseEntity.ok(response);
    }

    private String processMessage(String message) {
        // Implementa la lógica para procesar el mensaje y generar una respuesta
        // Puedes usar condiciones, bases de datos, algoritmos de procesamiento de lenguaje natural, etc.
        if (message.equalsIgnoreCase("Hola")) {
            return "¡Hola! ¿En qué puedo ayudarte?";
        } else if (message.equalsIgnoreCase("Cómo estás")) {
            return "Estoy bien, gracias por preguntar.";
        } else {
            return "Lo siento, no entiendo tu pregunta.";
        }
    }

    public static class RequestBodyClass {
        private String message;

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }

    class ChatResponse {
        private String response;
    
        public ChatResponse(String response) {
            this.response = response;
        }
    
        public String getResponse() {
            return response;
        }
    
        public void setResponse(String response) {
            this.response = response;
        }
    }

    // Agrega más métodos manejadores aquí

}
