package com.example.demo.model;

public class Position {
    int hor;
    int vert;

    public Position(int hor, int vert) {
        this.hor = hor;
        this.vert = vert;
    }

    public int getHor() {
        return hor;
    }

    public void setHor(int hor) {
        this.hor = hor;
    }

    public int getVert() {
        return vert;
    }

    public void setVert(int vert) {
        this.vert = vert;
    }
}
