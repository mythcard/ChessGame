package com.example.demo.utility;

import com.example.demo.model.Position;

public class DiagonalMovement {
    public static boolean isDiagonalMoveValid(Position from, Position to){
        return Math.abs(from.getHor() - to.getHor()) == Math.abs(from.getVert() - to.getVert());
    }
}
