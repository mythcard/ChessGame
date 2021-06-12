package com.example.demo.model;

public class King extends Piece {
    boolean isActive;

    public King(String color, Position pos, String specificpieceDetail, boolean isActive) {
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
        return super.isMoveValid(from, to);
    }
}
