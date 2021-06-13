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

        }
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

//    public static void main(String[] args) {
//        Board b1 = new Board();
//        Map<String, Position> bdState =
//        b1.makeMove("white_Soldier_0",new Position(1,0),new Position(2,1), "white");
//
//        System.out.println("Final board state: "+ bdState.toString());
//    }

}
