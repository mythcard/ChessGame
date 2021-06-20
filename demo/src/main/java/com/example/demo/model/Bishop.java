package com.example.demo.model;

import com.example.demo.utility.DiagonalMovement;

public class Bishop extends Piece {
    boolean isActive;

    public Bishop(String color, Position pos, String specificpieceDetail, boolean isActive) {
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
    public boolean isMoveValid(Position from, Position to, String color) {
        //Bishop travels in 45 or 135 therefore slope which is tan(angle) is +-1
        //Slope is (y2-y1)/(x2-x1)
        return DiagonalMovement.isDiagonalMoveValid(from,to);
    }
}
