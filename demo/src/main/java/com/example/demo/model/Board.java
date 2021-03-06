package com.example.demo.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Board {
    Map<String,Position> boardState;

    Piece whiteKing;
    Piece blackKing;

    Piece whiteQueen;
    Piece blackQueen;

    Piece kingSideWhiteRook;
    Piece queenSideWhiteRook;
    Piece kingSideBlackRook;
    Piece queenSideBlackRook;

    Piece kingSideWhiteBishop;
    Piece queenSideWhiteBishop;
    Piece kingSideBlackBishop;
    Piece queenSideBlackBishop;

    Piece kingSideWhiteKnight;
    Piece queenSideWhiteKnight;
    Piece kingSideBlackKnight;
    Piece queenSideBlackKnight;

    List<Piece> whiteSoldiers;
    List<Piece> blackSoldiers;


    public Board() {
        boardState = new HashMap<>();
        initializeAllPieces();
    }

    private void initializeAllPieces(){
        whiteKing = new King("white", new Position(0,3), "white_king",true);
        boardState.put(whiteKing.getSpecificpieceDetail(),whiteKing.getPos());
        blackKing = new King("black", new Position(7,3), "black_king",true);
        boardState.put(blackKing.getSpecificpieceDetail(),blackKing.getPos());

        whiteQueen = new Queen("white", new Position(0,4), "white_queen",true);
        blackQueen = new Queen("black", new Position(7,4), "black_queen",true);

        boardState.put(whiteQueen.getSpecificpieceDetail(), whiteQueen.getPos());
        boardState.put(blackQueen.getSpecificpieceDetail(), blackQueen.getPos());

        kingSideWhiteRook = new Rook("white",new Position(0,0),"king_side_white_rook",true);
        queenSideWhiteRook = new Rook("white",new Position(0,7),"queen_side_white_rook",true);
        kingSideBlackRook = new Rook("black",new Position(7,0),"king_side_black_rook",true);
        queenSideBlackRook = new Rook("black",new Position(7,7),"queen_side_black_rook",true);

        boardState.put(kingSideWhiteRook.getSpecificpieceDetail(), kingSideWhiteRook.getPos());
        boardState.put(queenSideWhiteRook.getSpecificpieceDetail(), queenSideWhiteRook.getPos());
        boardState.put(kingSideBlackRook.getSpecificpieceDetail(), kingSideBlackRook.getPos());
        boardState.put(queenSideBlackRook.getSpecificpieceDetail(), queenSideBlackRook.getPos());

        kingSideWhiteBishop = new Bishop("white",new Position(0,2),"king_side_white_bishop",true);
        queenSideWhiteBishop = new Bishop("white",new Position(0,5),"queen_side_white_bishoop",true);
        kingSideBlackBishop = new Bishop("black",new Position(7,2),"king_side_black_bishop",true);
        queenSideBlackBishop = new Bishop("black",new Position(7,5),"queen_side_black_bishop",true);

        boardState.put(kingSideWhiteBishop.getSpecificpieceDetail(), kingSideWhiteBishop.getPos());
        boardState.put(queenSideWhiteBishop.getSpecificpieceDetail(), queenSideWhiteBishop.getPos());
        boardState.put(kingSideBlackBishop.getSpecificpieceDetail(), kingSideBlackBishop.getPos());
        boardState.put(queenSideBlackBishop.getSpecificpieceDetail(), queenSideBlackBishop.getPos());

        kingSideWhiteKnight = new Knight("white",new Position(0,1),"king_side_white_knight",true);
        queenSideWhiteKnight = new Knight("white",new Position(0,6),"queen_side_white_knight",true);
        kingSideBlackKnight = new Knight("black",new Position(7,1),"king_side_black_knight",true);
        queenSideBlackKnight = new Knight("black",new Position(7,6),"queen_side_black_knight",true);

        boardState.put(kingSideWhiteKnight.getSpecificpieceDetail(), kingSideWhiteKnight.getPos());
        boardState.put(queenSideWhiteKnight.getSpecificpieceDetail(), queenSideWhiteKnight.getPos());
        boardState.put(kingSideBlackKnight.getSpecificpieceDetail(), kingSideBlackKnight.getPos());
        boardState.put(queenSideBlackKnight.getSpecificpieceDetail(), queenSideBlackKnight.getPos());

        whiteSoldiers = new ArrayList<>();
        blackSoldiers = new ArrayList<>();

        for(int i = 0; i < 8; i++){
            whiteSoldiers.add(new Soldier("white", new Position(1,i), ("white_Soldier_" + i),true));
            blackSoldiers.add(new Soldier("black", new Position(6,i), ("black_Soldier_" + i),true));
        }

        for(Piece piece: whiteSoldiers){
            boardState.put(piece.getSpecificpieceDetail(),piece.getPos());
        }

        for(Piece piece: blackSoldiers){
            boardState.put(piece.getSpecificpieceDetail(),piece.getPos());
        }

    }

    public Map<String, Position> getBoardState() {
        return boardState;
    }


    // what is the definition of game status
    // board state: "done": dummy position new Position(-1,-1)
    // if the key "done" not present game is active
    // Position (-1, -1) is dummy and will be in the game after its done

    public Map<String, Position> makeMove(String specificPieceDetail, Position from, Position to, String color){
        // to do
        // //check for out of bounds for to position
        // switch statement to recognise the piece and validate if its active,

        System.out.println("In board: ");
        System.out.println("Specific detail: "+ specificPieceDetail);
        System.out.println("Position from: "+ from.toString());
        System.out.println("Position to: "+ to.toString());

        String whatPiece = recognisePiece(specificPieceDetail);
        Piece soldier = null;
        Piece rook = null; //Why not use 1 var for all?
        Piece bishop = null;
        Piece knight = null;
        Piece queen = null;

        switch(whatPiece){
            case "Soldier":
                if(color.equalsIgnoreCase("white"))
                    soldier = getRightSoldier(this.whiteSoldiers, specificPieceDetail);
                else
                    soldier = getRightSoldier(this.blackSoldiers, specificPieceDetail);
                if(soldier.isMoveValid(from, to, color)){
                    soldier.setPos(to);
                    boardState.put(specificPieceDetail,soldier.getPos());
                }
            case "rook":
                rook = getRightRook(specificPieceDetail,color);
                if(rook.isMoveValid(from,to,color)){
                    rook.setPos(to);
                    boardState.put(specificPieceDetail,rook.getPos());
                }
            case "bishop":
                bishop = getRightBishop(specificPieceDetail,color);
                if(bishop.isMoveValid(from,to,color)){
                    bishop.setPos(to);
                    boardState.put(specificPieceDetail, bishop.getPos());
            }
            case "knight":
                knight = getRightKnight(specificPieceDetail,color);
                if(knight.isMoveValid(from,to,color)){
                    knight.setPos(to);
                    boardState.put(specificPieceDetail,knight.getPos());
                }

            case "queen":
                queen = getRightQueen(color);
                if(queen.isMoveValid(from,to,color)){
                    queen.setPos(to);
                    boardState.put(specificPieceDetail,queen.getPos());
                }
        }
        //TODO: From Position and Current Position validation
        // check if the move is valid
        // check if the position is occupied by another piece
        // if the move is valid and if the another piece from another color is occupying that position
        // kill the piece by deactivating the piece and setting the position to -1, -1
        return  getBoardState();
    }

    private static String recognisePiece(String specificPieceDetail){
        String [] strlst = specificPieceDetail.split("_");
        String result = null;
        for(String itm : strlst){
            if(itm.equalsIgnoreCase("Soldier")){
                return itm;
            }
            result = itm;
        }
        return result;
    }

    private static Piece getRightSoldier(List<Piece> whiteOrBlackSolLst, String specificPieceDetail){
        String res = null;
        String[] lst = specificPieceDetail.split("_");
        for(String itm: lst){
            res = itm;
        }

        Piece pc = whiteOrBlackSolLst.get(Integer.parseInt(res));

        return pc;

    }

    private Piece getRightRook(String specificPieceDetail,String color){
        String[] lst = specificPieceDetail.split("_");
        if(lst[0].equals("king"))return (color.equals("white")) ? this.getKingSideWhiteRook() : this.getKingSideBlackRook();
        return (color.equals("queen") ? this.getQueenSideWhiteRook() : this.getQueenSideBlackRook());
    }

    private Piece getRightBishop(String specificPieceDetail, String color){
        String[] lst = specificPieceDetail.split("_");
        if(lst[0].equals("king"))return (color.equals("white") ? this.getKingSideWhiteBishop() : this.getKingSideBlackBishop());
        //Return this when queen is included
        return (color.equals("queen") ? this.getQueenSideWhiteBishop() : this.getQueenSideBlackBishop());
    }

    private Piece getRightKnight(String specificPieceDetail , String color){
        String[] lst = specificPieceDetail.split("_");
        if(lst[0].equals("king"))return (color.equals("white")) ? this.getKingSideWhiteKnight() : this.getKingSideBlackKnight();
        return (color.equals("queen") ? this.getQueenSideWhiteKnight() : this.getQueenSideBlackKnight());
    }

    private Piece getRightQueen(String color){
        if(color.equals("white"))return this.getWhiteQueen();
        return this.getBlackQueen();
    }

    public void setBoardState(Map<String, Position> boardState) {
        this.boardState = boardState;
    }

    public Piece getWhiteKing() {
        return whiteKing;
    }

    public void setWhiteKing(Piece whiteKing) {
        this.whiteKing = whiteKing;
    }

    public Piece getBlackKing() {
        return blackKing;
    }

    public void setBlackKing(Piece blackKing) {
        this.blackKing = blackKing;
    }

    public Piece getWhiteQueen() {
        return whiteQueen;
    }

    public void setWhiteQueen(Piece whiteQueen) {
        this.whiteQueen = whiteQueen;
    }

    public Piece getBlackQueen() {
        return blackQueen;
    }

    public void setBlackQueen(Piece blackQueen) {
        this.blackQueen = blackQueen;
    }

    public Piece getKingSideWhiteRook() {
        return kingSideWhiteRook;
    }

    public void setKingSideWhiteRook(Piece kingSideWhiteRook) {
        this.kingSideWhiteRook = kingSideWhiteRook;
    }

    public Piece getQueenSideWhiteRook() {
        return queenSideWhiteRook;
    }

    public void setQueenSideWhiteRook(Piece queenSideWhiteRook) {
        this.queenSideWhiteRook = queenSideWhiteRook;
    }

    public Piece getKingSideBlackRook() {
        return kingSideBlackRook;
    }

    public void setKingSideBlackRook(Piece kingSideBlackRook) {
        this.kingSideBlackRook = kingSideBlackRook;
    }

    public Piece getQueenSideBlackRook() {
        return queenSideBlackRook;
    }

    public void setQueenSideBlackRook(Piece queenSideBlackRook) {
        this.queenSideBlackRook = queenSideBlackRook;
    }

    public Piece getKingSideWhiteBishop() {
        return kingSideWhiteBishop;
    }

    public void setKingSideWhiteBishop(Piece kingSideWhiteBishop) {
        this.kingSideWhiteBishop = kingSideWhiteBishop;
    }

    public Piece getQueenSideWhiteBishop() {
        return queenSideWhiteBishop;
    }

    public void setQueenSideWhiteBishop(Piece queenSideWhiteBishop) {
        this.queenSideWhiteBishop = queenSideWhiteBishop;
    }

    public Piece getKingSideBlackBishop() {
        return kingSideBlackBishop;
    }

    public void setKingSideBlackBishop(Piece kingSideBlackBishop) {
        this.kingSideBlackBishop = kingSideBlackBishop;
    }

    public Piece getQueenSideBlackBishop() {
        return queenSideBlackBishop;
    }

    public void setQueenSideBlackBishop(Piece queenSideBlackBishop) {
        this.queenSideBlackBishop = queenSideBlackBishop;
    }

    public Piece getKingSideWhiteKnight() {
        return kingSideWhiteKnight;
    }

    public void setKingSideWhiteKnight(Piece kingSideWhiteKnight) {
        this.kingSideWhiteKnight = kingSideWhiteKnight;
    }

    public Piece getQueenSideWhiteKnight() {
        return queenSideWhiteKnight;
    }

    public void setQueenSideWhiteKnight(Piece queenSideWhiteKnight) {
        this.queenSideWhiteKnight = queenSideWhiteKnight;
    }

    public Piece getKingSideBlackKnight() {
        return kingSideBlackKnight;
    }

    public void setKingSideBlackKnight(Piece kingSideBlackKnight) {
        this.kingSideBlackKnight = kingSideBlackKnight;
    }

    public Piece getQueenSideBlackKnight() {
        return queenSideBlackKnight;
    }

    public void setQueenSideBlackKnight(Piece queenSideBlackKnight) {
        this.queenSideBlackKnight = queenSideBlackKnight;
    }

    public List<Piece> getWhiteSoldiers() {
        return whiteSoldiers;
    }

    public void setWhiteSoldiers(List<Piece> whiteSoldiers) {
        this.whiteSoldiers = whiteSoldiers;
    }

    public List<Piece> getBlackSoldiers() {
        return blackSoldiers;
    }

    public void setBlackSoldiers(List<Piece> blackSoldiers) {
        this.blackSoldiers = blackSoldiers;
    }

//    public static void main(String[] args) {
//        Board b1 = new Board();
//        Map<String, Position> bdState =
//        b1.makeMove("white_Soldier_0",new Position(1,0),new Position(2,1), "white");
//        b1.makeMove("king_side_black_rook",new Position(7,0),new Position(4,0),"white");
//        b1.makeMove("black_queen",new Position(7,4),new Position(7,6),"white");
//        b1.makeMove("king_side_black_bishop",new Position(()))
//        System.out.println("Final board state: "+ bdState.toString());
//    }
}
