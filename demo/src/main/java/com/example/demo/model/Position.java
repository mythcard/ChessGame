package com.example.demo.model;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return hor == position.hor &&
                vert == position.vert;
    }

    @Override
    public int hashCode() {
        return Objects.hash(hor, vert);
    }

    @Override
    public String toString() {
        return "Position{" +
                "hor=" + hor +
                ", vert=" + vert +
                '}';
    }
}
