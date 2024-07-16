package com.denco.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/webhook")
public class HomeController {

    @PostMapping("/receive")
    public ResponseEntity<String> receivePayload(
            @RequestBody String payload,
            @RequestHeader(value = "X-Event-Type", required = false) String eventType) {

        System.out.println("Received payload: " + payload);
        System.out.println("Event type: " + eventType);

        return new ResponseEntity<>("Payload received", HttpStatus.OK);
    }
    
    @GetMapping("/get-working-status")
    public String getWorkingStatus() {
    	return "Working perfectly";
    }
}
