package com.example.demo.controller;

import com.example.demo.model.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class MessageController {
    Game g1 = new Game() ;
//    @GetMapping("/message")
//    Message send(){
//        return new Message("first message");
//    }

//    @PostMapping("/message")
//    Message echo (@RequestBody Message message){
//        return message;
//    }

//    @PostMapping("/startgame")
//    Position echo (@RequestBody Position pos){
//        return 10;
//    }

    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping("/boardState")
//    MakeMoveRequestBody send(){
    Map<String, Position> send(){
        return g1.getBoard().getBoardState();
//        return new MakeMoveRequestBody("whiteKing", new Position(0,3), new Position(0,4), "white");
    }

    @PostMapping("/move")
    Map<String, Position> echo (@RequestBody MakeMoveRequestBody reqBody){
        return g1.makeMove(reqBody);
    }

}
