package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

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
        List<Position> moves = new ArrayList<>();
        moves.add(new Position(from.getHor()+2,from.getVert()+1));
        moves.add(new Position(from.getHor()+1,from.getVert()+2));
        moves.add(new Position(from.getHor()-1, from.getVert()+2));
        moves.add(new Position(from.getHor()-2, from.getVert()+1));
        moves.add(new Position(from.getHor()-2, from.getVert()-1));
        moves.add(new Position(from.getHor()-1, from.getVert()-2));
        moves.add(new Position(from.getHor()+1, from.getVert()-2));
        moves.add(new Position(from.getHor()+2, from.getVert()-1));
        for(Position pos:moves){
            if((pos.getHor()==to.getHor())&&(pos.getVert()==to.getVert()))return true;
        }
        return false;
    }
}
