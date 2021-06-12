package com.example.demo.model;

public class Soldier extends Piece {
    boolean isActive;

    public Soldier(String color, Position pos, String specificpieceDetail, boolean isActive) {
        super(color, pos, specificpieceDetail);
        this.isActive = isActive;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @Override
    public boolean isMoveValid(Position from, Position to) {
        Position currentPosition = this.getPos();
        if(isMovePossible(currentPosition, to)){
            return true;
        }
        return false;
    }

    public boolean isMovePossible(Position currentPos, Position to){

        // find the list of valid positions, basically 1 forward, left alternate and right alternate based on color
        // check if to exists from the set
        // constraint checking (if a check is placed, if there is a piece in between rest of the path gets blocked)
        return true;
    }
}
