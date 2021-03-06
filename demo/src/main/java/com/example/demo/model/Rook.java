package com.example.demo.model;

import com.example.demo.utility.HorizontalMovement;

public class Rook extends Piece {
    boolean isActive;

    public Rook(String color, Position pos, String specificpieceDetail, boolean isActive) {
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
        //Check for whether from and to position's row or column values are equal to simulate rook unconstrained movement
        return HorizontalMovement.isHorizontalMoveValid(from,to);
    }
}
