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
        whiteKing = new King("white", new Position(0,3), "whiteking",true);
        boardState.put(whiteKing.getSpecificpieceDetail(),whiteKing.getPos());
        blackKing = new King("black", new Position(7,3), "blackking",true);
        boardState.put(blackKing.getSpecificpieceDetail(),blackKing.getPos());

        whiteQueen = new Queen("white", new Position(0,4), "whitequeen",true);
        blackQueen = new Queen("black", new Position(7,4), "blackqueen",true);

        boardState.put(whiteQueen.getSpecificpieceDetail(), whiteQueen.getPos());
        boardState.put(blackQueen.getSpecificpieceDetail(), blackQueen.getPos());

        kingSideWhiteRook = new Rook("white",new Position(0,0),"kingsidewhiterook",true);
        queenSideWhiteRook = new Rook("white",new Position(0,7),"queensidewhiterook",true);
        kingSideBlackRook = new Rook("black",new Position(7,0),"kingsideblackrook",true);
        queenSideBlackRook = new Rook("black",new Position(7,7),"queensideblackrook",true);

        boardState.put(kingSideWhiteRook.getSpecificpieceDetail(), kingSideWhiteRook.getPos());
        boardState.put(queenSideWhiteRook.getSpecificpieceDetail(), queenSideWhiteRook.getPos());
        boardState.put(kingSideBlackRook.getSpecificpieceDetail(), kingSideBlackRook.getPos());
        boardState.put(queenSideBlackRook.getSpecificpieceDetail(), queenSideBlackRook.getPos());

        kingSideWhiteBishop = new Bishop("white",new Position(0,2),"kingsidewhitebishop",true);
        queenSideWhiteBishop = new Bishop("white",new Position(0,5),"queensidewhitebishoop",true);
        kingSideBlackBishop = new Bishop("black",new Position(7,2),"kingsideblackbishop",true);
        queenSideBlackBishop = new Bishop("black",new Position(7,5),"queensideblackbishop",true);

        boardState.put(kingSideWhiteBishop.getSpecificpieceDetail(), kingSideWhiteBishop.getPos());
        boardState.put(queenSideWhiteBishop.getSpecificpieceDetail(), queenSideWhiteBishop.getPos());
        boardState.put(kingSideBlackBishop.getSpecificpieceDetail(), kingSideBlackBishop.getPos());
        boardState.put(queenSideBlackBishop.getSpecificpieceDetail(), queenSideBlackBishop.getPos());

        kingSideWhiteKnight = new Knight("white",new Position(0,1),"kingsidewhiteknight",true);
        queenSideWhiteKnight = new Knight("white",new Position(0,6),"queensidewhiteknight",true);
        kingSideBlackKnight = new Knight("black",new Position(7,1),"kingsideblackknight",true);
        queenSideBlackKnight = new Knight("black",new Position(7,6),"queensideblackknight",true);

        boardState.put(kingSideWhiteKnight.getSpecificpieceDetail(), kingSideWhiteKnight.getPos());
        boardState.put(queenSideWhiteKnight.getSpecificpieceDetail(), queenSideWhiteKnight.getPos());
        boardState.put(kingSideBlackKnight.getSpecificpieceDetail(), kingSideBlackKnight.getPos());
        boardState.put(queenSideBlackKnight.getSpecificpieceDetail(), queenSideBlackKnight.getPos());

        whiteSoldiers = new ArrayList<>();
        blackSoldiers = new ArrayList<>();

        for(int i = 0; i < 8; i++){
            whiteSoldiers.add(new Soldier("white", new Position(1,i), ("whiteSoldier" + i),true));
            blackSoldiers.add(new Soldier("black", new Position(6,i), ("blackSoldier" + i),true));
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
        // check if the move is valid
        // check if the position is occupied by another piece
        // if the move is valid and if the another piece from another color is occupying that position
        // kill the piece by deactivating the piece and setting the position to -1, -1
        return  getBoardState();
    }



}
