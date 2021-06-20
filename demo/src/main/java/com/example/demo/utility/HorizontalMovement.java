package com.example.demo.utility;

import com.example.demo.model.Position;

public class HorizontalMovement {
    public static boolean isHorizontalMoveValid(Position from, Position to){
        return (from.getHor() == to.getHor()) ^ (from.getVert() == to.getVert());
    }
}
