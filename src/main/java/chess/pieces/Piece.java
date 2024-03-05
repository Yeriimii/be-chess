package chess.pieces;

import static chess.common.Color.*;

import chess.common.Color;

public class Piece {
    public static final String ALLOWED_PAWN_NAME = "pawn";
    public static final String ALLOWED_KNIGHT_NAME = "knight";
    public static final String ALLOWED_BISHOP_NAME = "bishop";
    public static final String ALLOWED_ROOK_NAME = "rook";
    public static final String ALLOWED_QUEEN_NAME = "queen";
    public static final String ALLOWED_KING_NAME = "king";
    private final Color color;
    private final String name;

    private Piece(Color color, String name) {
        this.color = color;
        this.name = name;
    }

    public static Piece createWhitePawn() {
        return new Piece(WHITE, ALLOWED_PAWN_NAME);
    }

    public static Piece createBlackPawn() {
        return new Piece(BLACK, ALLOWED_PAWN_NAME);
    }

    public static Piece createWhiteKnight() {
        return new Piece(WHITE, ALLOWED_KNIGHT_NAME);
    }

    public static Piece createBlackKnight() {
        return new Piece(BLACK, ALLOWED_KNIGHT_NAME);
    }

    public static Piece createWhiteBishop() {
        return new Piece(WHITE, ALLOWED_BISHOP_NAME);
    }

    public static Piece createBlackBishop() {
        return new Piece(BLACK, ALLOWED_BISHOP_NAME);
    }

    public static Piece createWhiteRook() {
        return new Piece(WHITE, ALLOWED_ROOK_NAME);
    }

    public static Piece createBlackRook() {
        return new Piece(BLACK, ALLOWED_ROOK_NAME);
    }

    public static Piece createWhiteQueen() {
        return new Piece(WHITE, ALLOWED_QUEEN_NAME);
    }

    public static Piece createBlackQueen() {
        return new Piece(BLACK, ALLOWED_QUEEN_NAME);
    }

    public static Piece createWhiteKing() {
        return new Piece(WHITE, ALLOWED_KING_NAME);
    }

    public static Piece createBlackKing() {
        return new Piece(BLACK, ALLOWED_KING_NAME);
    }

    public Color getColor() {
        return color;
    }

    public String getName() {
        return name;
    }

    public String getRepresentation() {
        return PieceShape.find(this).getUnicode();
    }
}
