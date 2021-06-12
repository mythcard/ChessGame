package com.example.demo.model;

public abstract class Piece {
    String color;
    Position pos;
    String specificpieceDetail;

    public Piece(String color, Position pos, String specificpieceDetail) {
        this.color = color;
        this.pos = pos;
        this.specificpieceDetail = specificpieceDetail;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Position getPos() {
        return pos;
    }

    public void setPos(Position pos) {
        this.pos = pos;
    }

    public String getSpecificpieceDetail() {
        return specificpieceDetail;
    }

    public void setSpecificpieceDetail(String specificpieceDetail) {
        this.specificpieceDetail = specificpieceDetail;
    }

    public boolean isMoveValid(Position from, Position to){
        return false;
    }
}
