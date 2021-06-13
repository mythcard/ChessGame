package com.example.demo.model;

public class MakeMoveRequestBody {
    String specificPieceDetail;
    Position from;
    Position to;
    String color;

    public MakeMoveRequestBody(String specificPieceDetail, Position from, Position to, String color) {
        this.specificPieceDetail = specificPieceDetail;
        this.from = from;
        this.to = to;
        this.color = color;
    }

    public String getSpecificPieceDetail() {
        return specificPieceDetail;
    }

    public void setSpecificPieceDetail(String specificPieceDetail) {
        this.specificPieceDetail = specificPieceDetail;
    }

    public Position getFrom() {
        return from;
    }

    public void setFrom(Position from) {
        this.from = from;
    }

    public Position getTo() {
        return to;
    }

    public void setTo(Position to) {
        this.to = to;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "MakeMoveRequestBody{" +
                "specificPieceDetail='" + specificPieceDetail + '\'' +
                ", from=" + from +
                ", to=" + to +
                ", color='" + color + '\'' +
                '}';
    }
}
