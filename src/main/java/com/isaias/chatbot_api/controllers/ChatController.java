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
        if (message.toLowerCase().contains("hola") ||
            message.toLowerCase().contains("buenos") ||
            message.toLowerCase().contains("buenas")) {
            return "¡Hola! Soy el asistente virtual de la empresa 2Plo Technologies ¿En qué puedo ayudarte?";
        } else if (message.toLowerCase().contains("cómo estás")) {
            return "Estoy bien, gracias por preguntar.";
        } else if (message.toLowerCase().contains("información")) {
            return "Somos una empresa dedicada al desarrollo de software. Realizamos aplicaciones móviles, sitios web y sistemas para escritorio según tus necesidades.";
        }else if(message.toLowerCase().contains("horario")){
            return "Atendemos desde las 9:00am hasta las 8:00pm";
        }else if(message.toLowerCase().contains("dirección")||
                 message.toLowerCase().contains("ubicación")||
                 message.toLowerCase().contains("localización")
                ){
            return "Puedes encontrarnós en la calle oswaldo baca 201 en la urb magisterio 1era etapa, Cusco";
        } else if (message.toLowerCase().contains("servicios")) {
            return "Ofrecemos servicios de desarrollo de aplicaciones móviles, diseño de sitios web, desarrollo de sistemas personalizados y consultoría en tecnología.";
        } else if (message.toLowerCase().contains("tecnologías") || 
                   message.toLowerCase().contains("lenguajes")) {
            return "Trabajamos con una variedad de tecnologías y lenguajes de programación, incluyendo Java, Python, JavaScript, React, Angular, y más.";
        } else if (message.toLowerCase().contains("casos de éxito")) {
            return "Hemos trabajado en diversos proyectos exitosos, incluyendo aplicaciones móviles para negocios locales, sistemas de gestión para empresas y más.";
        } else if (message.toLowerCase().contains("equipo") || 
                   message.toLowerCase().contains("desarrolladores")) {
            return "Nuestro equipo está compuesto por profesionales altamente calificados y apasionados por la tecnología.";
        } else if (message.toLowerCase().contains("cotización") ||
                   message.toLowerCase().contains("presupuesto")) {
            return "Para obtener una cotización personalizada, te invitamos a ponerte en contacto con nosotros.";
        } else if (message.toLowerCase().contains("contacto") || 
                   message.toLowerCase().contains("asesor")) {
            return "Puedes contactarte con un asesor especializado escribiendo al +51 959 676 443 o enviando un correo a info@twoplotech.online.";
        }else if (message.toLowerCase().contains("gracias")) {
            return "De nada, no olvides ponerte en contacto si tienes mas dudas";
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
}
