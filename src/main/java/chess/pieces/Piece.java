package chess.pieces;

import static chess.common.Color.*;

import chess.common.Color;

public class Piece {
    public static final String ALLOWED_PAWN_NAME = "pawn";
    public static final String ALLOWED_KNIGHT_NAME = "knight";
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
