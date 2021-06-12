package com.example.demo.model;

public class Knight extends Piece {
    boolean isActive;

    public Knight(String color, Position pos, String specificpieceDetail, boolean isActive) {
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
        return super.isMoveValid(from, to, color);
    }
}
