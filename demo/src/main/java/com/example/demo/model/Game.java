package com.example.demo.model;

import java.util.Map;

public class Game {
    private Board board;

    public Game() {
        this.board = new Board();
    }

    public Board getBoard() {
        return board;
    }

    public Map<String,Position> makeMove(MakeMoveRequestBody reqBody){
        System.out.println("In Game: ");
        System.out.println(reqBody.toString());
        return board.makeMove(reqBody.getSpecificPieceDetail(),reqBody.getFrom(), reqBody.getTo(), reqBody.getColor());
    }

}
