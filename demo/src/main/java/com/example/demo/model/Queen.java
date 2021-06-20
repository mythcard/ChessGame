package com.example.demo.model;

import com.example.demo.utility.DiagonalMovement;
import com.example.demo.utility.HorizontalMovement;

public class Queen extends Piece {
    boolean isActive;

    public Queen(String color, Position pos, String specificpieceDetail, boolean isActive) {
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
        return (HorizontalMovement.isHorizontalMoveValid(from, to) ^ DiagonalMovement.isDiagonalMoveValid(from, to));
    }
}
