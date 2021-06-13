package com.example.demo.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    public boolean isMoveValid(Position from, Position to, String color) {
        Position currentPosition = this.getPos();
        if(isMovePossible(currentPosition, to, color)){
            return true;
        }
        return false;
    }

    public boolean isMovePossible(Position currentPos, Position to, String color){

        // find the list of valid positions, basically 1 forward, left alternate and right alternate based on color
        Set<Position> validPosset = new HashSet<>();

        calculateValidPositions(currentPos, color, validPosset);

        // check if to exists from the set
        if(validPosset.contains(to)){
            return true;
        }
        // constraint checking (if a check is placed, if there is a piece in between rest of the path gets blocked)
        return false;
    }

    private void calculateValidPositions(Position currentPos, String color, Set<Position> validPosset){
        if(color.equalsIgnoreCase("white")){
            moveForwardForWhite(currentPos, validPosset);
            validPosset.add(moveAlternateLeftForWhite(currentPos));
            validPosset.add(moveAlternateRightForWhite(currentPos));
        }
        else{
            moveForwardForBlack(currentPos, validPosset);
            validPosset.add(moveAlternateLeftForBlack(currentPos));
            validPosset.add(moveAlternateRightForBlack(currentPos));
        }
    }

    private void moveForwardForWhite(Position pos, Set<Position> validPosset){
        if(pos.getHor() == 1){
            validPosset.add(createPosition(pos.getHor() + 2, pos.getVert()));
        }
        validPosset.add(createPosition(pos.getHor() + 1, pos.getVert()));
    }

    private Position moveAlternateLeftForWhite(Position pos){
        return createPosition(pos.getHor() + 1, pos.getVert()+1);
    }

    private Position moveAlternateRightForWhite(Position pos){
        return createPosition(pos.getHor() + 1, pos.getVert()-1);
    }

    private void moveForwardForBlack(Position pos, Set<Position> validPosset){
        if(pos.getHor() == 6){
            validPosset.add(createPosition(pos.getHor() - 2, pos.getVert())) ;
        }
        validPosset.add(createPosition(pos.getHor() - 1, pos.getVert())) ;
    }

    private Position moveAlternateLeftForBlack(Position pos){
        return createPosition(pos.getHor() - 1, pos.getVert()+1);
    }

    private Position moveAlternateRightForBlack(Position pos){
        return createPosition(pos.getHor() - 1, pos.getVert()-1);
    }

    private Position createPosition(int hor, int ver){
        return new Position(hor, ver);
    }


}
